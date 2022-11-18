package com.zetcode;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

public class LiveScoreSubject implements ILiveScoreSubject {

    private List<LiveScoreObserver> observers;
    private int score;

    public LiveScoreSubject(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(LiveScoreObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(LiveScoreObserver o) {
        int observerIndex = observers.indexOf(o);
        if(observerIndex >= 0){
            observers.remove(observerIndex);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> {
                    o.update(score);
                }
        );
    }
    @Override
    public void notifyObservers(Graphics g) {
        observers.forEach(o -> {
                    o.update(score,g);
                }
        );
    }

    public int scoreUp(int score){
        this.score = score + 1 ;
        notifyObservers();
        return this.score;
    }

    public void scoreDown(int score){
        this.score = score - 1 ;
        notifyObservers();
    }

    public void drawScore(int currentScore, Graphics g) {
        //g.drawString("Score: "+ currentScore , Commons.BOARD_WIDTH - 90, 20);
        notifyObservers(g);
    }
}
