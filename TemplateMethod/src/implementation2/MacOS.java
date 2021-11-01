package implementation2;

import java.util.List;
import java.util.Scanner;

public class MacOS extends OperationSystem {

    private final String name;


    public MacOS(String login, String password, List<String> installedApps) {
        super(login, password, installedApps);
        name = "MacOS for user " + login;
    }

    @Override
    public boolean logIn(String login, String password) {
        if (super.logIn(login, password)) {
            System.out.println("Welcome to the MacOS, " + this.login() + "!");
            this.loggedIn(true);
            return true;
        }

        System.out.println("User credentials incorrect");
        return false;
    }

    @Override
    public void logOut() {
        if (!loggedIn()) {
            System.out.println("You can't log out since you are not logged into the MacOs!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Are you sure? (y|n): ");
        String response = sc.nextLine();
        if (response.equalsIgnoreCase("y")) {
            this.loggedIn(false);
            System.out.println("You are successfully logged out!");
        }
    }

    @Override
    public void showReport() {
        if (!loggedIn()) {
            System.out.println("You are not logged into MacOS!");
            return;
        }

        double cpu = Math.random() * 100;
        double gpu = Math.random() * 100;
        double memory = Math.random() * 100;
        double nds = 10 + Math.random() * 290;
        double nus = 5  + Math.random() * 295;

        OSStats stats = new OSStats(cpu, gpu, memory, nds, nus);
        stats.show();
    }

    @Override
    public String name() {
        return name;
    }
}
