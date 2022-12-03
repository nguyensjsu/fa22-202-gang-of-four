package com.zetcode.TimerObserver;

public interface ITimerSubject {
    
    void attach( ITimerObserver obj ) ;
    void detach( ITimerObserver obj ) ;
    void notifyObservers() ;
}
