package jdk.ValidateVo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class ParentVo {

    @NotBlank(message = "父母名字不能为空")
    private String name;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄是整数")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
