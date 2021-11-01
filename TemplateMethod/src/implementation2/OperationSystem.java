package implementation2;

import java.util.List;
import java.util.stream.Collectors;

public abstract class OperationSystem {

    private final List<String> installedApps;
    private final String login;
    private String password;
    private boolean loggedIn;

    public OperationSystem(String login, String password, List<String> installedApps) {
        this.login = login;
        this.password = password;
        this.installedApps = installedApps;
        this.loggedIn = false;
    }

    public boolean logIn(String login, String password) {
        // default implementation, should be overridden
        return this.login.equals(login) && this.password.equals(password);
    }

    public List<String> search(String searchString) {
        if (!loggedIn) {
            System.out.println("You are not logged in!");
            return null;
        }

        return installedApps
                .stream()
                .filter(app -> app.toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }


    public abstract void logOut();
    public abstract void showReport();


    // GETTERS
    public String login() {
        return login;
    }

    public String password() {
        return password;
    }

    public boolean loggedIn() {
        return loggedIn;
    }

    public abstract String name();


    // SETTERS
    public void password(String password) {
        this.password = password;
    }

    public void loggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
