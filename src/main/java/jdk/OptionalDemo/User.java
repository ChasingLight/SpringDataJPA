package jdk.OptionalDemo;

/**
 * Created by JadenOliver on 2018/5/16.
 */
public class User {

    String id;
    private String name;
    private String age;
    private String hobby;
    private String remark;

    User(){}
    User(String id, String name, String age, String hobby, String remark){
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
