package jdk.ValidateVo;

import java.util.Arrays;
import java.util.Map;

public class ValidatorTest {

    public static void main(String[] args) {
        StudentInfo studentInfo = new StudentInfo();
        long startTime = System.currentTimeMillis();
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        String name = "欧阳浩东";

        studentInfo.setUserName(name);
        studentInfo.setAge("24");
        studentInfo.setBirthday("2016-09-01");
        studentInfo.setSchool("清华大学");

        studentInfo.setMoney(1.0);  //自定义金额注解校验规则

        studentInfo.setIdCard("410185199405201510");   //

        //关联父母实体
        ParentVo father = new ParentVo();
        father.setName("dad");
        father.setAge("45");
        ParentVo mother = new ParentVo();
        mother.setName("mom");
        mother.setAge("45");
        studentInfo.setParents(Arrays.asList(father, mother));

        startTime = System.currentTimeMillis();
        //print(ValidatorUtil.validate(studentInfo));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        /*LoginVo loginVo = new LoginVo();

        loginVo.setTradeType("3");
        loginVo.setUserName(""); //18737104575
        loginVo.setAge("243");
        loginVo.setUserPwd("");  //123456 */

        //1.展示参数方式一
        //print(ValidatorUtil.validate(loginVo));

        //2.展示参数方式二
        //loginVo = null;
        String result = ValidatorUtil.validate2(studentInfo);   //studentInfo loginVo
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

