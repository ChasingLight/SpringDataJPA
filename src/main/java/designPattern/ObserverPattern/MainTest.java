package designPattern.ObserverPattern;

public class MainTest {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();  //主体

        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(11);
        stockGrabber.setApplePrice(12);
        stockGrabber.setGooglePrice(13);

        StockObserver observer2 = new StockObserver(stockGrabber);


        stockGrabber.setIbmPrice(21);
        /*stockGrabber.setApplePrice(22);
        stockGrabber.setGooglePrice(23);

        stockGrabber.unregister(observer1);

        stockGrabber.setIbmPrice(31);
        stockGrabber.setApplePrice(32);
        stockGrabber.setGooglePrice(33);*/


    }
}
