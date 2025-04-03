package com.shopping_cart.eshoppers.dto.myAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

/*
 ** 2024, July 17, Wednesday, 5:55 AM
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatcherValidator.class)
public @interface PasswordMatcher {
    String message() default "password not matching!";

    String first();
    String second();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
