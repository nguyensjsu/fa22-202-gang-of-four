package com.zetcode.utilites;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffectPlayer {
	public static void Play(String filePath){
        try {
            File f = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
        catch (Exception e){
            System.out.println("Sound error:" + e.getMessage());
        }
    }
}
