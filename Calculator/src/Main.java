import handlers.*;
import requests.BaseRequest;
import responses.Response;

public class Main {

    public static void main(String[] args) {
        info();

        Handler read = new ReadHandler();
        Handler parse = new ParseHandler();
        Handler calculate = new CalculateHandler();

        read.setNext(parse);
        parse.setNext(calculate);


        do {
            Response answer = read.process(new BaseRequest());

            if (answer == null) {
                break;
            }
            answer.show();
        } while (true);

        ((ReadHandler)read).close();
    }

    public static void info() {
        System.out.println("There are 4 operation available:");
        System.out.println("[+ - * /]");
        System.out.println("When you put two number to calculate, do it in the following way:");
        System.out.println("a+b");
    }
}
