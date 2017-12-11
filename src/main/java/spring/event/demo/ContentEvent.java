package spring.event.demo;


import org.springframework.context.ApplicationEvent;

/**
 * Created by JadenOliver on 2017/10/11.
 * 本质是观察者模式或者发布-订阅模式的使用
 */

//Step1：定义事件
public class ContentEvent extends ApplicationEvent {
    public ContentEvent(final String content) {
        super(content);
    }
}