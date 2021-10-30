package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class NameTextField extends JTextField implements Component {

    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.updateName();
    }

    @Override
    public String name() {
        return "NameTextField";
    }
}
