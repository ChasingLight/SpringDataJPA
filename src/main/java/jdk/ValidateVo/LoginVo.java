package jdk.ValidateVo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by JadenOliver on 2018/5/22.
 */
public class LoginVo {

    @NotBlank(message = "发送验证码交易类型不能为空")
    @Pattern(regexp = "^[0-1]{1}$", message = "参数值不合法")
    private String tradeType;

    @NotBlank(message = "登录用户名不能为空")
    private String userName;

    @NotBlank(message = "登录密码不能为空")
    private String userPwd;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄必须是正整数")
    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
}
