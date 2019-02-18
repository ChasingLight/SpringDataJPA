package multiThreadProgramming.chap3.waitReleaseLock;

//验证：Object.wait()方法，调用后会立即释放锁;
// 而sleep()方法不会释放锁。
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();  //对象监听器

        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        threadA.start();
        threadB.start();

    }
}
