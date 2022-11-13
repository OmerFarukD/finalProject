package com.example.finalproject.Annotations.UniqueUser;


import com.example.finalproject.Service.Constants.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueUserValidator.class})

public @interface UniqueUser {
    String message() default Messages.userAlreadyExistsMessage;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}