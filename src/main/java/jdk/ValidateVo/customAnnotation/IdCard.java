package jdk.ValidateVo.customAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//身份证合法性校验
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IdCardValidator.class)
public @interface IdCard {

    String message() default "身份证必须合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}