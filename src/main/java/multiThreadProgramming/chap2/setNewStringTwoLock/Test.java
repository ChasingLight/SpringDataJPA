package multiThreadProgramming.chap2.setNewStringTwoLock;

//验证：如果多线程同时持有"相同的"锁对象，则这些线程之间运行时同步的；
//     如果多线程持有"不同的"锁对象，则线程间运行是异步的。
public class Test {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();

        MyRunnable myRunnable = new MyRunnable(myService);

        Thread threadA = new Thread(myRunnable);
        threadA.setName("A");
        Thread threadB = new Thread(myRunnable);
        threadB.setName("B");

        threadA.start();
        //Thread.sleep(50);   //核心点：让A线程先获得锁对象：“123”；让B线程后获得锁对象：“456”，这样使得两线程异步执行！
        threadB.start();

    }
}
