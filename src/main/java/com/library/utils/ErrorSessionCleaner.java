package com.library.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ErrorSessionCleaner {

    public void clearSession(HttpServletRequest request){
        request.getSession().setAttribute("nameError", "");
        request.getSession().setAttribute("ageError", "");
    }
}
