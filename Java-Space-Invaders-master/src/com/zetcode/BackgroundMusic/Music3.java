package com.zetcode.BackgroundMusic;

public class Music3 implements IMusicStrategy{
    @Override
    public void runMusic() {
        SoundHandler.runMusic("resources/music3.wav");
    }
}
