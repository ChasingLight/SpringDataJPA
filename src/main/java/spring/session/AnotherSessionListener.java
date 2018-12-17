package spring.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AnotherSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        System.out.println("哈哈哈哈哈，我是另外一个监听者，这里是另外一个自定义行为：sessionId=" + sessionId + "的Session被创建了！");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        System.out.println("哈哈哈哈哈，我是另外一个监听者，这里是另外一个自定义行为：sessionId=" + sessionId + "的Session被销毁了！");

    }
}
