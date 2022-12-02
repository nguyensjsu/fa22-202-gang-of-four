package com.zetcode.LiveScore;

import java.awt.Graphics;

import com.zetcode.Commons;

public class LiveScoreObserver implements ILiveScoreObserver {

    protected int scoreState;
    protected LiveScoreSubject subject;

    public LiveScoreObserver(LiveScoreSubject subject){
        this.subject = subject;
        scoreState = this.subject.getState();
    }

    @Override
    public void update() {
        this.scoreState = subject.getState();

    }

    public int getScore(){
        return scoreState;
    }
}
