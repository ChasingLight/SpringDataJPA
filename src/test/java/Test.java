import com.alibaba.fastjson.JSONObject;
import jdk.ValidateVo.LoginVo;

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

    }
}
