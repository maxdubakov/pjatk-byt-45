package mediator;

import components.Component;

public interface Mediator {

    void submit();
    void reset();
    void updateName();
    void updateMobile();
    void updateGender();
    void updateDob();
    void updateAddress();
    void registerComponent(Component component);
    void createGUI();
}
