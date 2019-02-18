package multiThreadProgramming.chap4.MutexLockTest;

//验证：MutexLock-互斥锁，是不可重入锁；而ReentranLock是可重入锁
//扩充：可重入锁，即一个线程得到一个对象锁后，再次请求“此对象锁”是可以在
public class Test {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Service service = new Service();
                service.service1();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }//end main
}
