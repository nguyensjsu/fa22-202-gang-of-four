package com.zetcode.BackgroundMusic;

public class Music1 implements IMusicStrategy{
    @Override
    public void runMusic() {
        SoundHandler.runMusic("resources/music1.wav");
    }
}
