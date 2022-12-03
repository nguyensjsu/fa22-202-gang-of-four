package com.zetcode.BackgroundMusic;

import com.zetcode.Board;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundHandler {

    public static Clip runMusic(String path) {
        try {
            Board.isMusicPlaying = true;
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(0);
            return clip;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeMusic(Clip c) {
        Board.isMusicPlaying = false;
        if(c != null){
            c.close();
            c.flush();
            c.close();
        }
    }
}
