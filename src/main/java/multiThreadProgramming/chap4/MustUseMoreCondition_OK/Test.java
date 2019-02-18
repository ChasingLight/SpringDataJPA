package multiThreadProgramming.chap4.MustUseMoreCondition_OK;

//验证：使用ReentrantLock的Condition，实现多路分支通知
public class Test {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        ThreadB b = new ThreadB(service);
        b.start();
        Thread.sleep(3000);
        service.signalAll_B();
    }
}
