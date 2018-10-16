package jdk.ValidateVo;

import jdk.ValidateVo.customAnnotation.IdCard;
import jdk.ValidateVo.customAnnotation.Money;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by JadenOliver on 2018/5/21.
 */
public class StudentInfo {

    @NotBlank(message="用户名不能为空")
    @Pattern(regexp="^[\u4E00-\u9FA5]{1,5}$",message="用户名必须为中文且最多5位")
    private String userName;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄是整数")
    private String age;

    @NotBlank(message="身份证号码不能为空")
    @IdCard
    private String idCard;

    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;

    @NotBlank(message="学校不能为空")
    private String school;

    @NotNull
    @Money  //自定义注解，自定义校验方式。
    //@Pattern(regexp = "^\\d+\\.\\d{1,2}?$", message = "金额格式不正确")  //说明：@Pattern只能用在String上，否则报异常：No validator could be found for type: java.lang.Double
    private Double money;

    @Valid   //亲测：如果不在关联属性上设置@Valid标签，便不会校验关联实体的属性值。
    private List<ParentVo> parents;  //关联实体校验

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<ParentVo> getParents() {
        return parents;
    }

    public void setParents(List<ParentVo> parents) {
        this.parents = parents;
    }
}

