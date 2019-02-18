package multiThreadProgramming.chap3.joinTest2;

public class SubThread extends Thread{

    @Override
    public void run() {
        int secondValue = (int)(Math.random() * 5000);
        System.out.println(secondValue);
        try {
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//end method
}
