package com.zetcode.TimerObserver;

import java.util.ArrayList;


public class TimerSubject implements ITimerSubject{

    //===========
    private long time;
    private ArrayList<ITimerObserver> observers = new ArrayList<ITimerObserver>();

    public TimerSubject(long inTime){
        time = inTime;
    }

    public long getState(){
        return this.time;
    }

    @Override
    public void attach(ITimerObserver obj) {
        observers.add(obj);
    }

    @Override
    public void detach(ITimerObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (ITimerObserver obj : observers) {
            obj.update();
        }
    }



}
