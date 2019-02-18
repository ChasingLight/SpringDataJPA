import com.alibaba.fastjson.JSONObject;
import jdk.ValidateVo.LoginVo;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JadenOliver on 2018/5/21.
 */
public class Test {

    public static void main(String[] args) {
        String surrTBJsonStr = "{\n" +
                "    \"transType\": \"301\",\n" +
                "    \"merchantNo\": \"GXPT001\",\n" +
                "    \"orgCode\": \"YWDJB\",\n" +
                "    \"sendTime\": \"20170901154820\",\n" +
                "    \"version\": \"1.0.0\",\n" +
                "    \"bizContent\": {\n" +
                "        \"mOrder\": \"201805210012\",\n" +
                "        \"insuredId\": \"321102198201141919\",\n" +
                "        \"policyNo\": \"180421800001286\",\n" +  //180421700007583
                "        \"bpId\": \"CKYW001\"\n" +  //产品代码:CKYW001  XLYW001
                "    }\n" +
                "}";

        System.out.println(surrTBJsonStr);


        String reqJsonStr = null;
        LoginVo loginVo = JSONObject.parseObject(reqJsonStr, LoginVo.class);
        System.out.println(loginVo);

        List<Long> a = new ArrayList<>();
        a.add(1L);
        a.add(2L);
        a.add(3L);

        List<Long> b = new ArrayList<>();
        b.add(1L);
        b.add(2L);
        b.add(3L);
        b.add(4L);
        b.add(5L);
        b.add(6L);

        boolean result = a.removeAll(b);
        System.out.println(a);


        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)){
                list.remove(item);
            }
        }

        System.out.println(list);

        String str = "1,2,3,,";
        String[] elements = str.split(",");
        System.out.println("切分得到的字符串数组长度：" + elements.length);
        for (String temp : elements){
            System.out.println(temp);
        }

        try{
            String result2 = URLEncoder.encode("靳浩东()靳浩东","UTF-8");
            String result3 = URLDecoder.decode(result2, "UTF-8");

            System.out.println(result2);
            System.out.println(result3);
        }catch (Exception e){

        }





    }
}
