package com.zetcode.DifficultyMode;

import javax.swing.*;
import java.awt.*;

public class EasyMode extends DifficultyMode{

    public EasyMode(ModeHandler md) {
        super(md);
    }

    @Override
    public void ChangeMode() {


        mode.setState();

    }
}
