package implementation2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        OperationSystem macOs = new MacOS("Max", "SuperSecretPassword", List.of("IntelliJ", "Telegram", "CS:GO"));
        System.out.println(macOs.name() + " has been created");
        macOs.logIn("Max", "SuperSecretPassword");
        System.out.println(macOs.search("inte"));
        macOs.showReport();

        OperationSystem windows = new Windows("Another Max", "AnotherSuperSecretPassword",  List.of("Valorant", "Teams", "Discord"));
        System.out.println(windows.name() + " has been created");
        windows.logIn("Another Max", "AnotherSuperSecretPassword");
        System.out.println(windows.search("val"));
        windows.showReport();
    }
}
