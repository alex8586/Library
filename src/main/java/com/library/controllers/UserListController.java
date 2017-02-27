package com.library.controllers;

import com.library.businesslogic.BookListService;
import com.library.businesslogic.UserListService;
import com.library.businesslogic.UserService;
import com.library.domain.User;
import com.library.utils.ErrorSessionCleaner;
import com.library.utils.PopulateErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserListController {

    private final static String FIELD_SIGH = "CreatingUserError";
    private final static String NAME_CREATING_ERROR = "nameCreatingUserError";
    private final static String AGE_CREATING_ERROR = "ageCreatingUserError";
    private final static String NAME_UPDATE_ERROR = "nameUserDetailError";
    private final static String AGE_UPDATE_ERROR = "ageUserDetailError";

    @Autowired
    private UserListService userListService;

    @Autowired
    private BookListService bookListService;

    @Autowired
    private ErrorSessionCleaner sessionCleaner;

    @Autowired
    private UserService userService;

    @Autowired
    private PopulateErrorUtil errorUtil;

    @RequestMapping(value = "/userlist/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView showUserListPage(HttpServletRequest request,
                                         @PathVariable("pageNumber") int pageNumber) {
        sessionCleaner.clearSessionError(request, NAME_UPDATE_ERROR, AGE_UPDATE_ERROR);
        ModelAndView model = new ModelAndView("user_list");
        model.addAllObjects(userListService.getUserList(pageNumber));
        model.addAllObjects(bookListService.getBookList());
        return model;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request,
                             @ModelAttribute @Valid User user,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            sessionCleaner.clearSessionError(request, NAME_CREATING_ERROR, AGE_CREATING_ERROR);
            errorUtil.populateError("name", FIELD_SIGH, bindingResult, request);
            errorUtil.populateError("age", FIELD_SIGH, bindingResult, request);
            return "redirect:/userlist/0";
        } else {
            sessionCleaner.clearSessionError(request, NAME_CREATING_ERROR, AGE_CREATING_ERROR);
            userService.createUser(user);
        }
        return "redirect:/userlist/0";
    }

}
