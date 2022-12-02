package com.zetcode.Command;

import com.zetcode.SpaceInvaders;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static com.zetcode.Board.playMusic;
import static com.zetcode.Board.stopMusic;

//Receiver
public class RestartButton {
    public void pressButton(){
    	SpaceInvaders.getInstance().restartGame();
        try {
            stopMusic();
            playMusic();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
