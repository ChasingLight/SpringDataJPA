package spring.event.demo;

/**
 * Created by JadenOliver on 2017/10/11.
 */
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class LisiListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(final ApplicationEvent event) {

        //在实现中需要判断event类型是ContentEvent才可以处理
        if(event instanceof ContentEvent) {
            System.out.println("李四收到了新的内容：" + event.getSource());
        }
    }
}
