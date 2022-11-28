package com.zetcode.BackgroundMusic;

public class Music2 implements IMusicStrategy{
    @Override
    public void runMusic() {
        SoundHandler.runMusic("resources/music2.wav");
    }
}
