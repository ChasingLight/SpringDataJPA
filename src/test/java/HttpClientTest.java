import org.jaden.jpa.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JadenOliver on 2018/4/18.
 */
public class HttpClientTest {

    private final static String URL = "http://localhost:8080/SpringDataJPA/httpclient/testKeyValueParams";   //testStringParams  testKeyValueParams

    public static void main(String[] args) {
        //1.key-value请求

        Map<String, String> map = new HashMap<>();
        map.put("name", "靳浩东");
        map.put("age", "24");
        map.put("gender", "1");

        String respResult = null;

        try {
            respResult = HttpClientUtils.httpPostReqEntity(URL, map, null);
            //respResult = HttpClientUtils.httpPostReqStringEntity(URL, "靳浩东");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(respResult);
    }
}
