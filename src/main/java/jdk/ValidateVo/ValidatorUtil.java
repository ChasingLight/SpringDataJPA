package jdk.ValidateVo;

import javax.validation.ConstraintViolation;  //violation 违反，违规
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidatorUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Map<String,StringBuffer> validate(T obj){
        Map<String,StringBuffer> errorMap = null;
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if(set != null && set.size() >0 ){
            errorMap = new HashMap<>();
            String property = null;
            for(ConstraintViolation<T> cv : set){
                //这里循环获取错误信息，可以自定义格式
                property = cv.getPropertyPath().toString();
                if(errorMap.get(property) != null){
                    errorMap.get(property).append("," + cv.getMessage());
                }else{
                    StringBuffer sb = new StringBuffer();
                    sb.append(cv.getMessage());
                    errorMap.put(property, sb);
                }
            }
        }
        return errorMap;
    }

    public static <T> String validate2(T obj){
        String result = "success";

        if (obj == null){
            result = "请求报文为空";
        }else{
            Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
            if(set != null && set.size() >0 ){
                StringBuffer sb = new StringBuffer();
                String property = null;  //字段名
                String message = null;   //自定义提示
                for(ConstraintViolation<T> cv : set){
                    //这里循环获取错误信息，可以自定义格式
                    property = cv.getPropertyPath().toString();
                    message = cv.getMessage();
                    sb.append(property).append(":").append(message);
                }
                result = sb.toString();
            }
        }

        return result;
    }


}

