package com.library.controllers;

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
public class UserDetailController {

    private final static String UNICAL_USER_DETAIL = "UserDetailError";
    private final static String NAME_ERROR = "nameUserDetailError";
    private final static String AGE_ERROR = "ageUserDetailError";

    @Autowired
    private UserService userService;

    @Autowired
    private ErrorSessionCleaner sessionCleaner;

    @Autowired
    private PopulateErrorUtil errorUtil;

    @RequestMapping(value = "/userDetail/{userId}", method = RequestMethod.GET)
    public ModelAndView showUserDetail(HttpServletRequest request,
                                       @PathVariable("userId") long id){
        sessionCleaner.clearSessionError(request, NAME_ERROR, AGE_ERROR);
        ModelAndView model = new ModelAndView("user_details");
        model.addAllObjects(userService.getUser(id));
        return model;
    }

    @RequestMapping(value = "/updateUserDetail", method = RequestMethod.POST)
    public String updateUserDetails(HttpServletRequest request,
                                    @ModelAttribute @Valid User user,
                                    BindingResult bindingResult){

        if(bindingResult.hasFieldErrors()){
            sessionCleaner.clearSessionError(request, NAME_ERROR, AGE_ERROR);
            errorUtil.populateError("name", UNICAL_USER_DETAIL, bindingResult, request);
            errorUtil.populateError("age", UNICAL_USER_DETAIL, bindingResult, request);
            return"redirect:/userDetail/" + user.getId();
        }else {
            sessionCleaner.clearSessionError(request, NAME_ERROR, AGE_ERROR);
            userService.updateUserDetails(user.getId(), user.getName(), user.getAge());
        }
        return"redirect:/userDetail/" + user.getId();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam ("id") long id, HttpServletRequest request){
        sessionCleaner.clearSessionError(request, NAME_ERROR, AGE_ERROR);
        userService.deleteUser(id);
        return new ModelAndView("redirect:/userlist/0");
    }

}
