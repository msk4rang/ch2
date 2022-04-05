package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("UserValidator.validate()");

        User user = (User) target;

        String id = user.getId();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        if (errors.hasErrors()) return;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
        if (errors.hasErrors()) return;

        if (id == null || id.length() < 5 || id.length() > 12) {
            errors.rejectValue("id", "invalidLength");
        }
    }
}
