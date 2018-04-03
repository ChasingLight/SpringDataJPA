package jdk.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JadenOliver on 2018/4/3.
 */
public class HashMapTheory {
/*
1.HashMap的实现原理---ing
1>构建一个HashMap使用，遍历展示，同时查看Entry源码---ing
2>测试HashMap能否放置key为null的值---ing
3>查看一下构造方法，put方法，hashCode方法、addEntry方法
*/

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("jin", "jin");
        map.put("hao", "hao");
        map.put("dong", "dong");
        map.put(null,"xing");
        map.put(null,null);

        System.out.println(map);
    }
}
