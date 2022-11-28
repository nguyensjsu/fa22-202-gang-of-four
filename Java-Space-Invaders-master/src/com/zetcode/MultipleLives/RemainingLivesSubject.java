package com.zetcode.MultipleLives;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

public class RemainingLivesSubject implements IRemainingLivesSubject{

    private List<RemainingLivesObserver> observers;

    private int lives;

    public RemainingLivesSubject(int lives)
    {
        this.lives = lives;
        this.observers = new ArrayList<>();
    }
    @Override
    public void add(RemainingLivesObserver o) {

        observers.add(o);


    }

    @Override
    public void remove(RemainingLivesObserver o) {
        int observerIndex = observers.indexOf(o);
        if (observerIndex >= 0) {
            observers.remove(observerIndex);
        }
    }



    @Override
    public void notifyObservers() {
        observers.forEach(o -> { o.update(lives);});
    }

    @Override
    public void notifyObservers(Graphics g) {
        observers.forEach(o -> { o.update(lives,g);});
    }

    public int reduceLives(int lives)
    {
        this.lives = lives -1 ;
        notifyObservers();
        return this.lives;
    }
    
    public int increaseLives(int lives)
    {
        this.lives = lives+1 ;
        notifyObservers();
        return this.lives;
    }

    public void drawLives(int currLives, Graphics g)
    {
        notifyObservers(g);
    }

    public int liveStatus()
    {
        return  this.lives;
    }

}