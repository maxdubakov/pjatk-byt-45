package implementation2;

import java.util.List;

public class Windows extends OperationSystem {

    private final String name;


    public Windows(String login, String password, List<String> installedApps) {
        super(login, password, installedApps);
        name = "Windows for user " + login;
    }

    @Override
    public boolean logIn(String login, String password) {
        if (super.logIn(login, password)) {
            System.out.println("Welcome to the Windows, " + this.login() + "!");
            this.loggedIn(true);
            return true;
        }

        System.out.println("User credentials incorrect");
        return false;
    }

    @Override
    public void logOut() {
        if (!loggedIn()) {
            System.out.println("You cannot log out since you are not logged into the Windows!");
            return;
        }

        this.loggedIn(false);
        System.out.println("You are successfully logged out!");
    }

    @Override
    public void showReport() {
        if (!loggedIn()) {
            System.out.println("You are not logged into the Windows!");
            return;
        }

        double cpu = Math.random() * 50;
        double gpu = Math.random() * 50;
        double memory = Math.random() * 50;
        double nds = 10 + Math.random() * 180;
        double nus = 5  + Math.random() * 170;

        OSStats stats = new OSStats(cpu, gpu, memory, nds, nus);
        stats.show();
    }

    @Override
    public String name() {
        return name;
    }
}
