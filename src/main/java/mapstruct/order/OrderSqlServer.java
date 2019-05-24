package mapstruct.order;

import orika.DestStu;

import java.util.List;

public class OrderSqlServer {
    private Long orderID;
    private String name;
    private int age;


    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
