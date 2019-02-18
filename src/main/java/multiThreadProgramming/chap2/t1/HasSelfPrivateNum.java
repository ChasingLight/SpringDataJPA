package multiThreadProgramming.chap2.t1;

public class HasSelfPrivateNum {

    private int num = 0;

    public synchronized void addI(String username){
        //int num = 0;
        try{
            if ("a".equals(username)){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set over!");
            }

            System.out.println(username + " num=" + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }//end method
}
