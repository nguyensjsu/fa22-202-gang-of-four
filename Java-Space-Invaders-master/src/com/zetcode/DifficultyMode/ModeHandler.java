package com.zetcode.DifficultyMode;

import java.awt.*;

public class ModeHandler {

    DifficultyMode hardMode;

    DifficultyMode easyMode;

    DifficultyMode current;

    public ModeHandler()
    {
        hardMode = new HardMode(this);
        easyMode = new EasyMode(this);
        current = easyMode;
    }

    public int change()
    {
        current.ChangeMode();
        if (hardMode.equals(current)) {
            return 1;
        } else if (easyMode.equals(current)) {
            return 0;
        }
        return 0;
    }

    void setState() {
        if (hardMode.equals(current)) {
            current = easyMode;
        } else if (easyMode.equals(current)) {
            current = hardMode;
        }
    }
}
