package com.zetcode.Command;


import com.zetcode.Board;

import javax.swing.*;
import java.awt.*;

public class PauseButton {
    Container c;
    JButton pauseButton;
    JButton resumeButton;
    Timer timer;
    public PauseButton(Container c, JButton pauseButton, JButton resumeButton,Timer timer){
        this.c = c;
        this.pauseButton = pauseButton;
        this.resumeButton = resumeButton;
        this.timer = timer;
    }
    public void pressButton(){
        try {
            Board.stopMusic();
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
