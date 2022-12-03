package com.zetcode.Command;

//Concrete Command
public class RestartButtonPressed implements ICommand{
    RestartButton restartButton;

    public RestartButtonPressed(RestartButton restartButton) {
        this.restartButton= restartButton;
    }

    @Override
    public void execute() {
        restartButton.pressButton();
    }
}
