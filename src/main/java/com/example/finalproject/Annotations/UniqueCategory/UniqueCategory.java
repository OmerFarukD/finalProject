package com.example.finalproject.Annotations.UniqueCategory;

import com.example.finalproject.Service.Constants.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueCategoryValidator.class})

public @interface UniqueCategory {
    String message() default Messages.categoryAlreadyExistsMessage;

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
