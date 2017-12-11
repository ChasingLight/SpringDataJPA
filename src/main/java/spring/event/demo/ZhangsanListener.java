package spring.event.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class ZhangsanListener implements ApplicationListener<ContentEvent> {  //ApplicationListener<ContentEvent>：通过泛型指定事件类型
    @Override
    public void onApplicationEvent(final ContentEvent event) {
        System.out.println("张三收到了新的内容：" + event.getSource());
    }
}
