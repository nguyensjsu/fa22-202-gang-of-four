package com.zetcode.DifficultyMode;

import java.awt.*;

public class DifficultyMode implements IDifficultyMode{

    ModeHandler mode;

    public DifficultyMode(ModeHandler md)
    {
        this.mode= md;
    }


    @Override
    public void ChangeMode() {

    }
}
