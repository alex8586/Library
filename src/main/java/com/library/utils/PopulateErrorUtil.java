package com.library.utils;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

@Service
public class PopulateErrorUtil {

    public void populateError(String field, String unicalField, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasFieldErrors(field)) {
            request.getSession().setAttribute(field + unicalField, bindingResult.getFieldError(field)
                    .getDefaultMessage());
        }
    }
}
