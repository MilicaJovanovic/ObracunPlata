/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.services;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Milica
 */
public class SemesterValidator implements Validator {
    @Override
    public boolean supports(Class<?> paramClass) {
        return Semester.class.equals(paramClass);
    }
    
    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "semesterName", "valid.semester");
    }
}
