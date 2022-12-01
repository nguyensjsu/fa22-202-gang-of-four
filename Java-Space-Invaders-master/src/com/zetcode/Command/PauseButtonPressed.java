package com.zetcode.Command;

public class PauseButtonPressed implements ICommand{
    PauseButton pauseButton;

    public PauseButtonPressed(PauseButton pauseButton) {
        this.pauseButton= pauseButton;
    }

    @Override
    public void execute() {
        pauseButton.pressButton();
    }
}
