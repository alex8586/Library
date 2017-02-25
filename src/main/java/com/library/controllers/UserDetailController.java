package com.library.controllers;

import com.library.businesslogic.UserService;
import com.library.domain.User;
import com.library.utils.ErrorSessionCleaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserDetailController {

    @Autowired
    private UserService userService;

    @Autowired
    private ErrorSessionCleaner sessionCleaner;

    @RequestMapping(value = "/userDetail/{userId}", method = RequestMethod.GET)
    public ModelAndView showUserDetail(HttpServletRequest request,
                                       @PathVariable("userId") long id){
        sessionCleaner.clearCreatingUserError(request);
        ModelAndView model = new ModelAndView("user_details");
        model.addAllObjects(userService.getUser(id));
        return model;
    }

    @RequestMapping(value = "/updateUserDetail", method = RequestMethod.POST)
    public String updateUserDetails(HttpServletRequest request,
                                    @ModelAttribute @Valid User user,
                                    BindingResult bindingResult){

        if(bindingResult.hasFieldErrors()){
            sessionCleaner.clearUserDetailError(request);
            populateError("name", bindingResult, request);
            populateError("age", bindingResult, request);
            return"redirect:/userDetail/" + user.getId();
        }else {
            sessionCleaner.clearUserDetailError(request);
            userService.updateUserDetails(user.getId(), user.getName(), user.getAge());
        }
        return"redirect:/userDetail/" + user.getId();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam ("id") long id, HttpServletRequest request){
        sessionCleaner.clearUserDetailError(request);
        userService.deleteUser(id);
        return new ModelAndView("redirect:/userlist/0");
    }

    private void populateError (String field, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasFieldErrors(field)) {
            request.getSession().setAttribute(field +"UserDetailError", bindingResult.getFieldError(field)
                    .getDefaultMessage());
        }
    }

}
