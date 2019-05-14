package jdk.jdkeight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//学习jdk1.8---关于集合操作的新特性[https://blog.csdn.net/lidai352710967/article/details/82496783]
public class Test {

    public static void main(String[] args) {

        // stream()很多优点：无存储、函数编程执行、惰性执行、只能消费一次。
        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        List<String> collect3 = collect.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(collect3);

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(number -> number * number).collect(Collectors.toList());
        System.out.println(collect1);


        // 测试HashMap的containsKey是强匹配的
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("jinhaodong   ","鹿");
        hashMap.put("chenlongji   ","鹤");
        hashMap.put("xinghuayang  ","象");

        System.out.println(hashMap.containsKey("jinhaodong"));

        String firstErrorCode = "COPA0602R000116";
        try{
            Integer cErrorTypeNum = Integer.valueOf(firstErrorCode.substring(6, 6 + 2));
            System.out.println(cErrorTypeNum);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
