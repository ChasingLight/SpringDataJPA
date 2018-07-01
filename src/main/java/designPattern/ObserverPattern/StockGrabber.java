package designPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {
    private List<Observer> observers;
    private double ibmPrice;
    private double applePrice;
    private double googlePrice;

    public StockGrabber(){
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);

        System.out.println("Observer " + (observerIndex+1) + "deleted");

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {   //通知观察者具体行为实现
        for (Observer temp : observers) {
            temp.update(ibmPrice, applePrice, googlePrice);
        }
    }



    //主题状态改变(state changes)时，通知观察者
    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }



    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
        notifyObserver();
    }


    public void setGooglePrice(double googlePrice) {
        this.googlePrice = googlePrice;
        notifyObserver();
    }
}
