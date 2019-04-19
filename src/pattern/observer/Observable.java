package pattern.observer;

import java.util.ArrayList;

public abstract class Observable {
    public ArrayList<Observer> observers=null;
    public Observable(){
        observers=new ArrayList<>();
    }
    public void addObserver(Observer obs){
        observers.add(obs);
    }
    public void deleteObserver(Observer obs){
        observers.remove(obs);
    }
    public void notifyObservers(){
        for (Observer obs:observers){
            obs.update(this);
        }
    }
}
