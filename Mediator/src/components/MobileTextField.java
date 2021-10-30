package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MobileTextField extends JTextField implements Component {

    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.updateMobile();
    }

    @Override
    public String name() {
        return "MobileTextField";
    }
}
