package com.zetcode.TimerObserver;

import com.zetcode.Commons;
import java.awt.Graphics ;

public class TimerObserver implements ITimerObserver {

    private long time ;

    public TimerObserver( ITimerSubject timer ) {
        timer.attach(this) ;
    }
    
    public void update( long time ) {
        this.time = time ;
    }

    public void update( long time, Graphics g ) {
        this.time = time ;
        displayCurrent() ;
    }

    public void displayCurrent() {

    }

    public void drawTime( long currTime, Graphics g ) {
        g.drawString("Time: " + currTime, Commons.BOARD_WIDTH - 90 , 30) ;
    }
}
