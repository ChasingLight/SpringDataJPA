package spring.threadPool.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by JadenOliver on 2018/3/27.
 */
@Component
@Scope("prototype")
public class MyRunnable implements Runnable{

    private String orderNo;

    MyRunnable(){}

    MyRunnable(String orderNo){
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public void run() {
        //System.out.println("当前处理的订单号为：" + orderNo + " 当前进程的hashCode为：" + this.hashCode());
        try {
            long startTime=System.currentTimeMillis();
            Thread.sleep(10000);  //等待10s, 模拟交易处理时间
            long endTime=System.currentTimeMillis();
            System.out.println("进程:" + this.hashCode() + "已完成! 开始结束时间:" + startTime + " ~ " + endTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
