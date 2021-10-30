package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MaleRadioButton extends JRadioButton implements Component {

    private Mediator mediator;

    public MaleRadioButton() {
        super("Male");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.updateGender();
    }

    @Override
    public String name() {
        return "MaleRadioButton";
    }
}
