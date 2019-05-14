package jdk.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseLambda {

    public static void main(String[] args) {
        // 此行代码的变量e，由编译器推理而来
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );

        Arrays.asList( "jinhaodong", "chenlongji", "xinghuayang" ).forEach( (String e) -> System.out.println( e ) );

        // lambda表达式复杂，可使用'花括号'整合成代码块
        List<String> myFriends = new ArrayList<>();
        myFriends.add("jinhaodong");
        myFriends.add("chenlongji");
        myFriends.add("xinghuayang");
        myFriends.forEach( (String friendName) -> {
            System.out.println(friendName);
            System.out.println("大学最亲密室友");
        });

        // lambda表达式，引用-类成员或局部变量
        final String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach( (String e) -> System.out.println( e + separator ) );

        // lambda表达式，返回值
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            System.out.println(e1 + "---" + e2 + "----" +result);
            return result;
        } );

    }
}
