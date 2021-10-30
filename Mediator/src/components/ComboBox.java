package components;

import mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ComboBox extends JComboBox<String> implements Component {

    private Mediator mediator;
    private final String name;

    public ComboBox(String name, String[] values) {
        super(values);
        this.name = name;
    }

    @Override
    protected void fireActionEvent() {
        mediator.updateDob();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String name() {
        return this.name;
    }
}
