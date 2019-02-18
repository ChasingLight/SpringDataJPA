package multiThreadProgramming.chap4.Fair_noFair_test;

//验证：ReentrantLock的公平锁/非公平锁使用
//公平锁：线程“获取锁”的顺序是按照线程“加锁”---lock.lock()的顺序来分配的。
public class Test {
    public static void main(String[] args) {
        Service service = new Service(false);  //true:公平锁  false:非公平锁

        Thread[] threadArray = new MyThread[10];

        for (int i = 0; i < 10; i++) {
            threadArray[i] = new MyThread(service);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
