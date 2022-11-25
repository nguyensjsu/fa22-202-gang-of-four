package com.zetcode.BackgroundMusic;

public class Music3 implements IMusicStrategy{
    @Override
    public void runMusic() {
        SoundHandler.runMusic("/Users/sankalptiwari/Downloads/Background MusicJava-Space-Invaders-master 3/res/music3.wav");
    }
}
