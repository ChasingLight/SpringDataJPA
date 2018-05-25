package jdk.OptionalDemo;


import java.util.Optional;

/**
 * Created by JadenOliver on 2018/5/16.
 */
public class OptionalMainTest {

    public static void main(String[] args) {
        User user = getDBUserById("valid");
        Optional<User> userOptional = Optional.ofNullable(user);

        System.out.println(userOptional.isPresent());
        System.out.println(userOptional.orElse(null));

        /*String name = userOptional.map(u -> u.getName())
                    .map(name -> name.toString())
                    .orElse(null);

        System.out.println(name);*/

    }

    public static User getDBUserById(String id){
        //数据库实现，根据查询参数id，得到的结果不确定,可能为空

        User user = null;
        if ("valid".equals(id)){
            user = new User("valid","JadenOliver","24","music","Remark Info");
        }else{
            user = null;
        }

        return user;
    }
}
