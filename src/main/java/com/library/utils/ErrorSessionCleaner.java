package com.library.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ErrorSessionCleaner {

    public void clearUserDetailError(HttpServletRequest request){
        request.getSession().setAttribute("nameUserDetailError", "");
        request.getSession().setAttribute("ageUserDetailError", "");
    }

    public void clearCreatingUserError(HttpServletRequest request){
        request.getSession().setAttribute("nameCreatingUserError", "");
        request.getSession().setAttribute("ageCreatingUserError", "");
    }
}
