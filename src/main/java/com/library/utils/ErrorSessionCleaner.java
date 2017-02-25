package com.library.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ErrorSessionCleaner {

    public void clearSessionError(HttpServletRequest request, String fieldName, String fieldAge){
        request.getSession().setAttribute(fieldName, "");
        request.getSession().setAttribute(fieldAge, "");
    }

}
