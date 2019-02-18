package multiThreadProgramming.chap2.t7;

import multiThreadProgramming.chap2.synNotExtends.Sub;

public class ThreadB extends Thread {

    private Task task;

    public ThreadB(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }
}
