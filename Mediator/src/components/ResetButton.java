package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetButton extends JButton implements Component {

    private Mediator mediator;

    public ResetButton() {
        super("Reset");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.reset();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String name() {
        return "ResetButton";
    }
}
