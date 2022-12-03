package com.zetcode.DifficultyMode;

import javax.swing.*;
import java.awt.*;

public class HardMode extends DifficultyMode{


    public HardMode(ModeHandler md) {
        super(md);
    }

    @Override
    public void ChangeMode() {


        mode.setState();

    }
}
