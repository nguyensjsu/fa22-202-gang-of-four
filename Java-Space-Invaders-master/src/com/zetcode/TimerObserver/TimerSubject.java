package com.zetcode.TimerObserver;

import java.util.ArrayList;
import java.util.List ;
import java.awt.Graphics;

public class TimerSubject implements ITimerSubject{
    
    private List<ITimerObserver> observers ;
    private long time ;

    public TimerSubject() {
        this.observers = new ArrayList<>();
    }

    public void attach( ITimerObserver obj ) {
        observers.add(obj);
    }

    public void detach( ITimerObserver obj ) {
        observers.remove(obj) ;
    }

    @Override
    public void notifyObservers() {
        for (ITimerObserver obj : observers) {
            obj.update(time) ;
        }
    }

    @Override
    public void notifyObservers( Graphics g ) {
        for (ITimerObserver obj : observers ) {
            obj.update(time, g ) ;
        }
    }

    public long getTime( long time ) {
        this.time = time ;
        return this.time ;
    }

    public void drawTime( long currTime, Graphics g ) {
        notifyObservers(g);
    }


}
