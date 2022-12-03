package com.zetcode.LiveScore;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LiveScoreSubject implements ILiveScoreSubject {

    private int subjectState;
    private ArrayList<ILiveScoreObserver> observers = new ArrayList<ILiveScoreObserver>();

    public LiveScoreSubject(int str){
        subjectState = str;
    }

    public void setState(int status) {
        subjectState = status;
        notifyObservers();
    }

    public int getState(){
        return this.subjectState;
    }

    @Override
    public void attach(ILiveScoreObserver obj) {
        observers.add(obj);
    }

    @Override
    public void detach(ILiveScoreObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (ILiveScoreObserver obj : observers) {
            obj.update();
        }
    }
}
