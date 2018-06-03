package jdk.ValidateVo.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MoneyValidator.class)
public @interface Money {

    String message() default"金额格式要求：小数点后最多保留两位有效数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
