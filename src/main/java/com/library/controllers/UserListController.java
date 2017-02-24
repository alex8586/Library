package com.library.controllers;

import com.library.businesslogic.BookListService;
import com.library.businesslogic.UserListService;
import com.library.businesslogic.UserService;
import com.library.domain.User;
import com.library.utils.ErrorSessionCleaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserListController {

    @Autowired
    private UserListService userListService;

    @Autowired
    private BookListService bookListService;

    @Autowired
    private ErrorSessionCleaner sessionCleaner;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ModelAndView userlist(HttpServletRequest request){
        sessionCleaner.clearUserDetailError(request);
        ModelAndView model = new ModelAndView("user_list");
        model.addAllObjects(userListService.getUserList());
        model.addAllObjects(bookListService.getBookList());
        return model;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request,
                                   @ModelAttribute @Valid User user,
                                   BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            sessionCleaner.clearCreatingUserError(request);
            populateError("name", bindingResult, request);
            populateError("age", bindingResult, request);
            return "redirect:/userlist";
        }else {
            sessionCleaner.clearCreatingUserError(request);
            userService.createUser(user);
        }
        return"redirect:/userlist";
    }

    private void populateError (String field, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasFieldErrors(field)) {
            request.getSession().setAttribute(field +"CreatingUserError", bindingResult.getFieldError(field)
                    .getDefaultMessage());
        }
    }
}
