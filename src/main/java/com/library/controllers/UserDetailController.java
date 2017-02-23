package com.library.controllers;

import com.library.businesslogic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDetailController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userDetail/{userId}", method = RequestMethod.GET)
    public ModelAndView showUserDetail(@PathVariable("userId") long id){
        ModelAndView model = new ModelAndView("user_details");
        model.addAllObjects(userService.getUser(id));
        return model;
    }

    @RequestMapping(value = "/updateUserDetail", method = RequestMethod.POST)
    public ModelAndView updateUserDetails(@RequestParam ("id") long id,
                                          @RequestParam ("name") String name,
                                          @RequestParam ("age") int age){

        userService.updateUserDetails(id, name, age);
        return new ModelAndView("redirect:/userDetail/" + id);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam ("id") long id){
        userService.deleteUser(id);
        return new ModelAndView("redirect:/userlist");
    }
}
