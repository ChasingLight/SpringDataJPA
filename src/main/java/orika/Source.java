package orika;

import java.util.List;

public class Source {
    private Long orderId;
    private String name;
    private int age;

    private SourceStu sourceStu;

    private List<Integer> integers;

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public SourceStu getSourceStu() {
        return sourceStu;
    }

    public void setSourceStu(SourceStu sourceStu) {
        this.sourceStu = sourceStu;
    }

    public Source(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Source(Long orderId, String name, int age) {
        this.orderId = orderId;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
