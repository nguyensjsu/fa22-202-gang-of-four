package com.zetcode.BackgroundMusic;

import javax.sound.sampled.Clip;

public class Music2 implements IMusicStrategy{
    private Clip cp;
    @Override
    public void runMusic() {
        cp = SoundHandler.runMusic("resources/music2.wav");
    }
    public void closeMusic() {
        SoundHandler.closeMusic(cp);
    }
    public String toString() {
        return "music2";
    }
}
