package multiThreadProgramming.chap2.throwExceptionNoLock;

//验证：当线程执行的代码出现异常，锁自动释放
public class Test {
    public static void main(String[] args) {
        try {
        Service service = new Service();

        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        threadA.start();

        Thread.sleep(500);


        ThreadB threadB = new ThreadB(service);
        threadB.setName("b");
        threadB.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
