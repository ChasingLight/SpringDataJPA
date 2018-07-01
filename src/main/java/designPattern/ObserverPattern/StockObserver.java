package designPattern.ObserverPattern;

public class StockObserver implements Observer {

    //主题所有可能的状态改变
    private double ibmPrice;
    private double applePrice;
    private double googlePrice;

    private static int observerIdTracker = 0;

    private int observerId;

    public StockObserver(){}

    public StockObserver(Subject stackGrabber){

        this.observerId = ++observerIdTracker;

        System.out.println("New Observer " + this.observerId);

        stackGrabber.register(this);

    }

    @Override
    public void update(double ibmPrice, double applePrice, double googlePrice) {
        this.ibmPrice = ibmPrice;
        this.applePrice = applePrice;
        this.googlePrice = googlePrice;

        printThePrices();
    }

    public void printThePrices(){
        System.out.println(observerId + "\nIBM:" + ibmPrice +
                "\nApple:" + applePrice +
                "\nGoogle:" + googlePrice );
    }
}
