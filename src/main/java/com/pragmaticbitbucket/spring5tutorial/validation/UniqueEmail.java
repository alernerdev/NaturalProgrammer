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

@Constraint(validatedBy = UniqueEmailValidator.class)
@NotBlank(message="{blankEmail}")
@Email
@Size(min=4,max=256, message="{emailSizeError}")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {
    String message() default "{duplicateEmail}";
    Class[] groups() default {};
    Class[] payload() default {};
}
