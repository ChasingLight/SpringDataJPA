package jdk;

import java.util.HashMap;
import java.util.Map;

public class ChineseToEnglishDic {

    public static Map<String, String> map = new HashMap<>();

    static{
        map.put("apple","苹果" );
        map.put("bike","自行车");
        map.put("cool","酷");
        map.put("dog","狗");
        map.put("email","电子邮件");
        map.put("friday","星期五");
        map.put("go boating","去划船");
        map.put("hot","热");
        map.put("ice cream ","冰淇淋");
        map.put("jacket","夹克衫");
    }

    public static void main(String[] args) {

        String input = "cn7ygyhouijotyu";  //输入
        String output = "";  //输出

        for (String english : map.keySet()){
            if (english.equals(input)){
                output = map.get(english);
            }
        }

        if(output.equals("")){
            System.out.println("在字典中没有单词：" + input);
        }else{
            System.out.println("单词：" + input  + "的中文意思是：" + output);
        }

    }//end main
}
