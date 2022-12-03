package com.zetcode.Command;


import com.zetcode.BackgroundMusic.IMusicStrategy;
import com.zetcode.Board;

import javax.swing.*;
import java.awt.*;

public class PauseButton {
    Container c;
    JButton pauseButton;
    JButton resumeButton;
    Timer timer;
    IMusicStrategy musicStrategy;
    public PauseButton(Container c, JButton pauseButton, JButton resumeButton, Timer timer, IMusicStrategy musicStrategy){
        this.c = c;
        this.pauseButton = pauseButton;
        this.resumeButton = resumeButton;
        this.timer = timer;
        this.musicStrategy = musicStrategy;
    }
    public void pressButton(){
        try {
            Board.stopMusic();
            if(musicStrategy!= null){
                musicStrategy.closeMusic();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.add(resumeButton, 0, 0);
        c.remove(pauseButton);
        c.revalidate();
        c.repaint();
        timer.stop();
    }
}
