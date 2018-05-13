package spring.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gacl
 * cookie实例：获取用户上一次访问的时间
 */
public class CookieDemo1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置服务器端以UTF-8编码进行输出
        response.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取浏览器访问访问服务器时传递过来的cookie数组
        Cookie[] cookies = request.getCookies();
        //如果用户是第一次访问，那么得到的cookies将是null
        if (cookies!=null) {
            out.write("您上次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastAccessTime")) {
                    Long lastAccessTime =Long.parseLong(cookie.getValue());
                    Date date = new Date(lastAccessTime);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.write("这是您第一次访问本站！");
        }

        //获得请求Header信息
        String headerInfo = request.getHeader("jadenHeader");
        out.write("请求Header中key：jadenHeader对应的值为" + headerInfo);

        //用户访问过之后重新设置用户的访问时间，存储到cookie中，然后发送到客户端浏览器
        String cookieValue = System.currentTimeMillis()+"";
        Cookie cookie = new Cookie("lastAccessTime", cookieValue);//创建一个cookie，cookie的名字是lastAccessTime
        //将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
        Cookie jadenCookie = new Cookie("jadenCookie","JadenOliver" + cookieValue);

        out.write(cookieValue);

        response.addCookie(cookie);
        response.addCookie(jadenCookie);

        //设置请求Header信息
        response.setHeader("jadenHeader","Hello this beautiful world!");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}