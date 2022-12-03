package com.zetcode.TimerObserver;

import com.zetcode.Commons;
import java.awt.Graphics ;

public class TimerObserver implements ITimerObserver {

    protected long time;
    protected TimerSubject subject;

    public TimerObserver(TimerSubject subject){
        this.subject = subject;
        time = this.subject.getState();
    }

    @Override
    public void update() {
        this.time = subject.getState();

    }

    public long getTime(){
        return time;
    }
}
