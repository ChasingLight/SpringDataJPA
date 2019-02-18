package multiThreadProgramming.chap2.synchronizedUpdateNewValue;

public class Service {
    private boolean isRunning = true;

    public void runMethod(){    //1.synchronized关键字写在方法头部，也无法让死循环停下来

        String lock = new String();

        //synchronized (lock){}  // 2.在此处没有作用，无法让死循环停下来

        while(isRunning){
            synchronized (lock){}   //3.只有写在此处才有作用
        }

        System.out.println("---停下来了！---");
    }//end method

    public void stopMethod(){
        isRunning = false;
    }
}
