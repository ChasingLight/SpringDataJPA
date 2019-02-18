package multiThreadProgramming.chap2.setNewPropertiesLockOne;

//验证：只要锁对象不变，即使锁对象的属性被改变，运行结果还是同步的。
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Userinfo useInfo = new Userinfo();

        MyRunnable myRunnable = new MyRunnable(service, useInfo);

        Thread threadA = new Thread(myRunnable);
        threadA.setName("A");
        Thread threadB = new Thread(myRunnable);
        threadB.setName("B");

        threadA.start();
        threadB.start();

    }
}
