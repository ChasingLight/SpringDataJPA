package multiThreadProgramming.chap2.t1;

//验证：方法内变量为线程安全的，实例变量为非线程安全的。
public class Test {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();

        ThreadA threadA = new ThreadA(numRef);
        ThreadB threadB = new ThreadB(numRef);
        threadA.start();
        threadB.start();

    }
}
