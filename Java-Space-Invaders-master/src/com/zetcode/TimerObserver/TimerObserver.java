package com.zetcode.TimerObserver;

import java.util.Timer;
import java.util.TimerTask;

public class TimerObserver extends TimerTask implements ITimerObserver {

	Timer timer;
	
    protected int minute = 0;
    protected int seconds = 0;
    
    protected TimerSubject subject;

    public TimerObserver(TimerSubject subject){
        this.subject = subject;
        this.start();
    }
    
	@Override
	public void start() {
		// TODO Auto-generated method stub

        timer = new Timer();
        timer.schedule(this, 1);
	}

    @Override
    public void update() {
    	
    }

    public String getTime(){
    	return String.format("%02d:%02d", seconds/60, seconds%60);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(timer!=null)
		{
	      try {
	    	  seconds++;		    	  
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
}
