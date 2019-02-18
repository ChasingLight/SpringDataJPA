package multiThreadProgramming.chap3.joinTest2;

//验证：join()方法，使得子线程对象正常执行run()方法，而使得主线程进行无限期阻塞，
//                直到子线程对象销毁，再继续执行主线程后续代码。
public class Test {
    public static void main(String[] args) {
        MainThread mainThread = new MainThread();
        mainThread.setName("mianThread");
        mainThread.start();
    }
}
