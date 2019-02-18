package multiThreadProgramming.chap2.synchronizedMethodLockObject;

//验证：调用synchronized声明的方法是排队运行的；非synchronized方法则是异步运行的。
public class Test {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        ThreadA threadA = new ThreadA(myObject);
        threadA.start();
        ThreadB threadB = new ThreadB(myObject);
        threadB.start();

    }
}
