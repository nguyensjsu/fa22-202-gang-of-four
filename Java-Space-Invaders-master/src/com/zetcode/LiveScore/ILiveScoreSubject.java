package com.zetcode.LiveScore;


public interface ILiveScoreSubject {
    public void attach(ILiveScoreObserver o);
    public void detach(ILiveScoreObserver o);
    public void notifyObservers();
}
