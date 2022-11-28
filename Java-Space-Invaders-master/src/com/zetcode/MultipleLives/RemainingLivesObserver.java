package com.zetcode.MultipleLives;

import java.awt.Graphics;

import com.zetcode.Commons;

public class RemainingLivesObserver implements IRemainingLivesObserver {

    private int lives;

    public RemainingLivesObserver(IRemainingLivesSubject remainingLives)
    {
        remainingLives.add(this);
    }





    public void update(int lives, Graphics g) {
        this.lives = lives;
        drawLives(lives,g);
    }

    public void drawLives(int currLives, Graphics g)
    {
        g.drawString("Remaining Lives: "+ currLives, Commons.BOARD_WIDTH-150, 35);
    }

    @Override
    public void update(int lives) {

    }
}

