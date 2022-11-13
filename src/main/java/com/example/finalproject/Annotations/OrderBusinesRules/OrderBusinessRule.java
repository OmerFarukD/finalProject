package com.example.finalproject.Annotations.OrderBusinesRules;

import com.example.finalproject.Service.Constants.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {OrderBusinessRuleValidator.class})


public @interface OrderBusinessRule {
    String message() default Messages.orderNotAddedMessage;

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}