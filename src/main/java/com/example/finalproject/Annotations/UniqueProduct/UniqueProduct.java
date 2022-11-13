package com.example.finalproject.Annotations.UniqueProduct;
import com.example.finalproject.Service.Constants.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueProductValidator.class})

public @interface UniqueProduct {
    String message() default Messages.productAlreadyExistMessage;

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}