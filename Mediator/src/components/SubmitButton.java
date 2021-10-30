package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SubmitButton extends JButton implements Component {

    private Mediator mediator;

    public SubmitButton() {
        super("Submit");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.submit();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String name() {
        return "SubmitButton";
    }
}
