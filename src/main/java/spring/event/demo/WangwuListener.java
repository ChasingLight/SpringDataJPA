package spring.event.demo;

/**
 * Created by JadenOliver on 2017/10/11.
 */
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/*
*
* supportsEventType：用于指定支持的事件类型，只有支持的才调用onApplicationEvent；
supportsSourceType：支持的目标类型，只有支持的才调用onApplicationEvent；
getOrder：即顺序，越小优先级越高*/

@Component
public class WangwuListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(final Class<? extends ApplicationEvent> eventType) {
        return eventType == ContentEvent.class;
    }
    @Override
    public boolean supportsSourceType(final Class<?> sourceType) {
        return sourceType == String.class;
    }
    @Override
    public void onApplicationEvent(final ApplicationEvent event) {
        System.out.println("王五在孙六之前收到新的内容：" + event.getSource());
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
