package mediator;

import components.*;
import components.Component;

import javax.swing.*;
import java.awt.*;

public class Editor implements Mediator {
    static class RegistrationData {
        private String name;
        private String mobile;
        private String gender;
        private String date;
        private String address;
        private boolean success;
        private final String def;

        public RegistrationData(String def) {
            this.def = def;
            name = def;
            mobile = def;
            gender = def;
            date = def;
            address = def;
        }

        public String defaultRegistrationPreview() {
            return
                    "Name: " + name + "\n" +
                            "Mobile: " + mobile + "\n" +
                            "Gender: " + gender + "\n" +
                            "Date of Birth: " + date + "\n" +
                            "Address: " + address + "\n" +
                            (success ? "Registration was successful" : "");
        }
    }


    private NameTextField nameTextField;
    private MobileTextField mobileTextField;
    private MaleRadioButton maleRadioButton;
    private FemaleRadioButton femaleRadioButton;
    private ComboBox dayComboBox;
    private ComboBox monthComboBox;
    private ComboBox yearComboBox;
    private AddressTextBox addressTextBox;
    private SubmitButton submitButton;
    private ResetButton resetButton;
    private RegistrationTextArea registrationTextField;

    private final JLabel title;
    private final JLabel nameLabel;
    private final JLabel mobileLabel;
    private final JLabel genderLabel;
    private final JLabel dobLabel;
    private final JLabel addressLabel;

    private static final String STR_DEFAULT = "";
    private static final int INT_DEFAULT = 0;
    private final RegistrationData data;

    public Editor() {
        title = new JLabel("Registration Form");
        nameLabel = new JLabel("Name");
        mobileLabel = new JLabel("Mobile");
        genderLabel = new JLabel("Gender");
        dobLabel = new JLabel("DOB");
        addressLabel = new JLabel("Address");
        data = new RegistrationData(STR_DEFAULT);
    }

    @Override
    public void submit() {
        data.success = true;
        registrationTextField.setText(data.defaultRegistrationPreview());
        registrationTextField.setEditable(false);
    }

    @Override
    public void reset() {
        nameTextField.setText(STR_DEFAULT);
        mobileTextField.setText(STR_DEFAULT);
        maleRadioButton.setSelected(true);
        femaleRadioButton.setSelected(false);
        addressTextBox.setText(STR_DEFAULT);
        dayComboBox.setSelectedIndex(INT_DEFAULT);
        monthComboBox.setSelectedIndex(INT_DEFAULT);
        yearComboBox.setSelectedIndex(INT_DEFAULT);
        updateName();
        updateMobile();
        updateGender();
        updateDob();
        updateAddress();
        data.success = false;
        registrationTextField.setEditable(true);
        registrationTextField.setText(data.defaultRegistrationPreview());
    }

    @Override
    public void updateName() {
        data.name = nameTextField.getText();
        this.registrationTextField.setText(data.defaultRegistrationPreview());
    }

    @Override
    public void updateMobile() {
        data.mobile = mobileTextField.getText();
        this.registrationTextField.setText(data.defaultRegistrationPreview());
    }

    @Override
    public void updateGender() {
        if (maleRadioButton.isSelected()) {
            data.gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            data.gender = "Female";
        }
        this.registrationTextField.setText(data.defaultRegistrationPreview());
    }

    @Override
    public void updateDob() {
        data.date =
                dayComboBox.getSelectedItem()
                + "/" + monthComboBox.getSelectedItem()
                + "/" + yearComboBox.getSelectedItem();
        this.registrationTextField.setText(data.defaultRegistrationPreview());
    }

    @Override
    public void updateAddress() {
        data.address = addressTextBox.getText();
        this.registrationTextField.setText(data.defaultRegistrationPreview());
    }

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.name()) {
            case "NameTextField":
                this.nameTextField = (NameTextField) component;
                break;
            case "MobileTextField":
                this.mobileTextField = (MobileTextField) component;
                break;
            case "MaleRadioButton":
                this.maleRadioButton = (MaleRadioButton) component;
                break;
            case "FemaleRadioButton":
                this.femaleRadioButton = (FemaleRadioButton) component;
                break;
            case "DayComboBox":
                this.dayComboBox = (ComboBox) component;
                break;
            case "MonthComboBox":
                this.monthComboBox = (ComboBox) component;
                break;
            case "YearComboBox":
                this.yearComboBox = (ComboBox) component;
                break;
            case "AddressTextBox":
                this.addressTextBox = (AddressTextBox) component;
                break;
            case "SubmitButton":
                this.submitButton = (SubmitButton) component;
                break;
            case "ResetButton":
                this.resetButton = (ResetButton) component;
                break;
            case "RegistrationTextField":
                this.registrationTextField = (RegistrationTextArea) component;
        }
    }

    @Override
    public void createGUI() {
        JFrame root = new JFrame("Sign Up Page");
        root.setTitle(title.getText());
        root.setBounds(300, 90, 900, 600);
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setResizable(false);

        Container c = root.getContentPane();
        c.setLayout(null);

        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);


        // NAME
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setSize(100, 20);
        nameLabel.setLocation(100, 100);
        c.add(nameLabel);

        nameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTextField.setSize(190, 20);
        nameTextField.setLocation(200, 100);
        c.add(nameTextField);


        // MOBILE
        mobileLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mobileLabel.setSize(100, 20);
        mobileLabel.setLocation(100, 150);
        c.add(mobileLabel);

        mobileTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        mobileTextField.setSize(150, 20);
        mobileTextField.setLocation(200, 150);
        c.add(mobileTextField);


        // GENDER
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        genderLabel.setSize(100, 20);
        genderLabel.setLocation(100, 200);
        c.add(genderLabel);

        // GENDER MALE
        maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        maleRadioButton.setSelected(true);
        maleRadioButton.setSize(75, 20);
        maleRadioButton.setLocation(200, 200);
        c.add(maleRadioButton);

        // GENDER FEMALE
        femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        femaleRadioButton.setSelected(false);
        femaleRadioButton.setSize(80, 20);
        femaleRadioButton.setLocation(275, 200);
        c.add(femaleRadioButton);

        // GENDER GROUP
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);


        // DATE
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dobLabel.setSize(100, 20);
        dobLabel.setLocation(100, 250);
        c.add(dobLabel);

        // DATE DAY
        dayComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        dayComboBox.setSize(50, 20);
        dayComboBox.setLocation(200, 250);
        dayComboBox.setSelectedIndex(INT_DEFAULT);
        c.add(dayComboBox);

        // DATE MONTH
        monthComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        monthComboBox.setSize(60, 20);
        monthComboBox.setLocation(250, 250);
        monthComboBox.setSelectedIndex(INT_DEFAULT);
        c.add(monthComboBox);

        // DATE YEAR
        yearComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        yearComboBox.setSize(60, 20);
        yearComboBox.setLocation(320, 250);
        yearComboBox.setSelectedIndex(INT_DEFAULT);
        c.add(yearComboBox);


        // ADDRESS
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        addressLabel.setSize(100, 20);
        addressLabel.setLocation(100, 300);
        c.add(addressLabel);

        addressTextBox.setFont(new Font("Arial", Font.PLAIN, 15));
        addressTextBox.setSize(200, 75);
        addressTextBox.setLocation(200, 300);
        addressTextBox.setLineWrap(true);
        c.add(addressTextBox);


        // SUBMIT BUTTON
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(150, 450);
        c.add(submitButton);


        // RESET BUTTON
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(270, 450);
        c.add(resetButton);


        // REGISTRATION AREA
        registrationTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        registrationTextField.setText(data.defaultRegistrationPreview());
        registrationTextField.setSize(300, 400);
        registrationTextField.setLocation(500, 100);
        registrationTextField.setLineWrap(true);
        registrationTextField.setEditable(false);
        c.add(registrationTextField);

        updateGender();
        updateDob();

        root.setVisible(true);
    }
}