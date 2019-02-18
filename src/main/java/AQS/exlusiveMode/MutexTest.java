package AQS.exlusiveMode;



import java.util.Random;

public class MutexTest {

    public static void main(String[] args) {

        Sale sale = new Sale();

        Thread t1 = new Thread(sale);
        Thread t2 = new Thread(sale);
        Thread t3 = new Thread(sale);

        t1.start();
        t2.start();
        t3.start();


    } //end method
}
