package orika;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Dest {
    private Long orderID;
    private String name;
    private int age;

    private List<Integer> integers;

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    private DestStu destStu;

    public DestStu getDestStu() {
        return destStu;
    }

    public void setDestStu(DestStu destStu) {
        this.destStu = destStu;
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

    public Dest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Dest{" +
                "orderID=" + orderID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", destStu=" + destStu +
                '}';
    }
}
