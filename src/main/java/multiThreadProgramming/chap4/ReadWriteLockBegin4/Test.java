package multiThreadProgramming.chap4.ReadWriteLockBegin4;

//验证：ReentrantReadWriteLock使用：读读共享锁----写写、读写、写读互斥锁
public class Test {
    public static void main(String[] args) {
        Service service = new Service();

        Thread threadA = new ThreadA(service);
        threadA.setName("A");
        Thread threadB = new ThreadB(service);
        threadB.setName("B");

        threadA.start();
        threadB.start();

    }
}
