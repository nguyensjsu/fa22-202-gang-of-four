package com.zetcode.TimerObserver;

import java.awt.Graphics ;

public interface ITimerSubject {
    
    void attach( ITimerObserver obj ) ;
    void detach( ITimerObserver obj ) ;
    void notifyObservers() ;
    void notifyObservers( Graphics g ) ;

}
