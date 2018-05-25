package jdk.ValidateVo;

import java.util.Map;

public class ValidatorTest {

    public static void main(String[] args) {
        /*StudentInfo s = new StudentInfo();
        long startTime = System.currentTimeMillis();
        print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        s.setUserName("小明");
        s.setAge("a10");
        s.setBirthday("a2016-09-01");
        s.setSchool("清华大学");
        startTime = System.currentTimeMillis();
        print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));*/

        LoginVo loginVo = new LoginVo();

        loginVo.setTradeType("3");
        loginVo.setUserName(""); //18737104575
        loginVo.setAge("243");
        loginVo.setUserPwd("");  //123456


        //1.展示参数方式一
        //print(ValidatorUtil.validate(loginVo));

        //2.展示参数方式二
        //loginVo = null;
        String result = ValidatorUtil.validate2(loginVo);
        if ("success".equals(result)){
            System.out.println("检验成功");
        }else{
            System.out.println(result);
        }




    }

    private static void print(Map<String,StringBuffer> errorMap){
        if(errorMap != null){
            for(Map.Entry<String, StringBuffer> m : errorMap.entrySet()){
                System.out.println(m.getKey() + ":" + m.getValue().toString());
            }
        }
    }
}

