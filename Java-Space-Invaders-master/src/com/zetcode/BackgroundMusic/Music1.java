package com.zetcode.BackgroundMusic;

public class Music1 implements IMusicStrategy{
    @Override
    public void runMusic() {
        SoundHandler.runMusic("/Users/sankalptiwari/Downloads/Background MusicJava-Space-Invaders-master 3/res/music1.wav");
    }
}