package com.library.controllers;

import com.library.businesslogic.BookListService;
import com.library.businesslogic.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserListController {

    @Autowired
    private UserListService userListService;

    @Autowired
    private BookListService bookListService;

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ModelAndView userlist(){
        ModelAndView model = new ModelAndView("user_list");
        model.addAllObjects(userListService.getUserList());
        model.addAllObjects(bookListService.getBookList());
        return model;
    }
}
