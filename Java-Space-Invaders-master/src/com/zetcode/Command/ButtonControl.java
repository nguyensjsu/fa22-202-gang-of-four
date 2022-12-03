package com.zetcode.Command;

//Invoker
public class ButtonControl {
    private ICommand command;
    public void setCommand(ICommand command){
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }
}
