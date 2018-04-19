package jdk.characterEncodeTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by JadenOliver on 2018/4/12.
 */
public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {

        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset().name());

        String myName = "靳浩东";

        //方式1
        byte[] bytes = myName.getBytes("UTF-8");
        String newName = new String(bytes,"UTF-8");
        System.out.println("靳浩东自己的博客你是知道的!");


        //方式2
        byte[] bytes2 = myName.getBytes("GBK");
        String newName2 = new String(bytes2,"GBK");

        //方式3
        byte[] bytes3 = myName.getBytes();
        String newName3 = new String(bytes3, "UTF-8");

        System.out.println(myName);
        System.out.println(newName);
        System.out.println(newName2);
        System.out.println(newName3);

        System.out.println("默认bytes数组内容:" + Arrays.toString(bytes3));
        System.out.println("UTF-8产生bytes数组内容:" + Arrays.toString(bytes));
        System.out.println("GBK产生bytes数组内容:" + Arrays.toString(bytes2));


        String transferStr = new String(myName.getBytes("iso8859-1"), "UTF-8");  //字符黑洞ISO   tomcat7中问题---ing
        System.out.println(transferStr);

        System.out.println(new Date().getTime());
        //Thread.sleep(5000);
        System.out.println(new Date().getTime());

        String encodeUnionId = URLEncoder.encode("4FGOAnZfz8BVsMGBh3Nb+b8kh91WD5hn+X0O+ZBf8Ck=","UTF-8");
        System.out.println("encode unionId：" + encodeUnionId);
        System.out.println("decode unionId: " + URLDecoder.decode(encodeUnionId,"UTF-8"));

        String encodeAdd = URLEncoder.encode("靳浩东+++abc","UTF-8");
        System.out.println("---" + encodeAdd);
        String encodeAddAgain = URLDecoder.decode(encodeAdd,"UTF-8");
        System.out.println("---" + encodeAddAgain);

        String str = "peIW8aFdU8V4LWb6JfQvozm KI X8XGbbCWgjH2yCQ6d1dta5i0dzsLGLQvllNone";
        str = str.replace(" ","+");
        System.out.println(str);

    }
}
