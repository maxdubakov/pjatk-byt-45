package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddressTextBox extends JTextArea implements Component {

    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        mediator.updateAddress();
    }

    @Override
    public String name() {
        return "AddressTextBox";
    }
}
