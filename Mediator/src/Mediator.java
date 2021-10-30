import components.Component;

public interface Mediator {

    void notify(Component component, Event event);
}
