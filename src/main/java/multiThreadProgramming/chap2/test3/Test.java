package multiThreadProgramming.chap2.test3;

//验证：将任意对象作为‘对象监听器’，即 synchronized(非this对象x)，已有一个线程获得了x对象监听器。
//当其他线程执行x对象中的，1>synchronized同步方法；2>synchronized(this)代码块，都将呈现同步效果。
public class Test {
    public static void main(String[] args) {
        try {
        Service service = new Service();
        MyObject myObject = new MyObject();

        ThreadA threadA = new ThreadA(service, myObject);
        threadA.setName("a");
        threadA.start();

        Thread.sleep(100);

        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("b");
        threadB.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
