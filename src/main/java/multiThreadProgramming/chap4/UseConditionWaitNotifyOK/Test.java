package multiThreadProgramming.chap4.UseConditionWaitNotifyOK;

//验证：使用ReentrantLock的Condition，实现等待/通知。
//     且同理Condition.await()方法会立即释放锁；而Condition.signalAll()方法，则会在run()方法执行完毕后才释放锁！
public class Test {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signal();
    }
}
