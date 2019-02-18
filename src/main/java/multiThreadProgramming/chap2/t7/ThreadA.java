package multiThreadProgramming.chap2.t7;

import multiThreadProgramming.chap2.synNotExtends.Sub;

public class ThreadA extends Thread {

    private Task task;

    public ThreadA(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }
}
