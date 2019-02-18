package multiThreadProgramming.chap2.t7;

import multiThreadProgramming.chap2.synNotExtends.Sub;

//验证：一个方法中，在synchronized块中的代码同步执行，不在synchronized块中的代码是异步执行的
public class Test {
    public static void main(String[] args) {
        Task task = new Task();

        ThreadA threadA = new ThreadA(task);
        threadA.start();
        ThreadB threadB = new ThreadB(task);
        threadB.start();

    }
}
