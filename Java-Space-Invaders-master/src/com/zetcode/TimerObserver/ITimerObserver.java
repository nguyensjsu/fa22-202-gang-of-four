package com.zetcode.TimerObserver;

import java.awt.Graphics ;

public interface ITimerObserver {

    void update( long time ) ;
    void update( long time, Graphics g ); 
    
}
