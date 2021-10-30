package components;

import mediator.Mediator;

import javax.swing.*;

public class RegistrationTextArea extends JTextArea implements Component {

    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String name() {
        return "RegistrationTextField";
    }
}
