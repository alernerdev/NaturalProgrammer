package com.pragmaticbitbucket.spring5tutorial.validation;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Constraint(validatedBy = {})
@NotBlank
@Size(min=6,max=32)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface Password {
    String message() default "{}";
    Class[] groups() default {};
    Class[] payload() default {};
}
