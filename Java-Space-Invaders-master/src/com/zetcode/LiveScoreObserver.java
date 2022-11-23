package com.zetcode;

import java.awt.Graphics;

public class LiveScoreObserver implements ILiveScoreObserver {

    private int score;

    public LiveScoreObserver(ILiveScoreSubject liveScore){
        liveScore.registerObserver(this);
    }

    @Override
    public void update(int score) {
        this.score = score;
        displayCurrent();
    }

    public void update(int score, Graphics g) {
        this.score = score;
        drawScore(score, g);
    }

    public void displayCurrent(){
    }

    public void drawScore(int currentScore, Graphics g) {
        g.drawString("Score: "+ currentScore , Commons.BOARD_WIDTH - 90, 20);
    }
}
