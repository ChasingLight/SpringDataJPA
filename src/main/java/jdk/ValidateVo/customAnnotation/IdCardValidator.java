package jdk.ValidateVo.customAnnotation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<IdCard, String> {


    @Override
    public void initialize(IdCard constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (StringUtils.isBlank(value))  return true;   //这里返回true，因为外围会有@NotBlank标签

        IdCardUtil idCardUtil = new IdCardUtil();
        return idCardUtil.isValidatedAllIdcard(value);

    }
}
