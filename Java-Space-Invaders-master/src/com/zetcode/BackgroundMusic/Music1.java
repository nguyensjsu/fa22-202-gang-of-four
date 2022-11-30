package com.zetcode.BackgroundMusic;

import javax.sound.sampled.Clip;

public class Music1 implements IMusicStrategy{
    private Clip cp;
    @Override
    public void runMusic() {
        cp = SoundHandler.runMusic("resources/music1.wav");
    }
    public void closeMusic() {
        SoundHandler.closeMusic(cp);
    }


    public String toString() {
        return "music1";
    }
}
