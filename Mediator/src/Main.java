import components.*;
import mediator.Editor;
import mediator.Mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new NameTextField());
        mediator.registerComponent(new MobileTextField());
        mediator.registerComponent(new MaleRadioButton());
        mediator.registerComponent(new FemaleRadioButton());
        mediator.registerComponent(new ComboBox("DayComboBox", Config.DAYS));
        mediator.registerComponent(new ComboBox("MonthComboBox", Config.MONTHS));
        mediator.registerComponent(new ComboBox("YearComboBox", Config.YEARS));
        mediator.registerComponent(new AddressTextBox());
        mediator.registerComponent(new SubmitButton());
        mediator.registerComponent(new ResetButton());
        mediator.registerComponent(new RegistrationTextArea());

        mediator.createGUI();
    }
}
