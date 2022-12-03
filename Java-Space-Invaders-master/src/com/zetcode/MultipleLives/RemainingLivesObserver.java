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
        g.drawString(" Life: "+ currLives, 40, 55);
    }

    @Override
    public void update(int lives) {

    }
}

