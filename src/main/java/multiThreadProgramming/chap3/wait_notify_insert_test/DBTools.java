package multiThreadProgramming.chap3.wait_notify_insert_test;

public class DBTools {

    volatile private boolean prevIsA = false;

    synchronized public void backupA(){
        try{
            while(prevIsA){
                wait();
            }

            System.out.println("AAAAA---" + Thread.currentThread().getName());
            prevIsA = true;
            notifyAll();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){
        try{
            while(!prevIsA){
                wait();
            }

            System.out.println("BBBBB---" + Thread.currentThread().getName());
            prevIsA = false;
            notifyAll();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
