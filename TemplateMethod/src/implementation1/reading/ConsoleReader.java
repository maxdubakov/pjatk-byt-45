package implementation1.reading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader extends Reader {

    private BufferedReader scInt;
    private Scanner scStr;

    public ConsoleReader() {
        this.open();
    }

    @Override
    public void open() {
        scInt = new BufferedReader(new InputStreamReader(System.in));
        scStr = new Scanner(System.in);
    }

    @Override
    public Integer readInt() {
        try {
            return Integer.parseInt(scInt.readLine());
        } catch (Exception e) {
            return this.readInt();
        }
    }

    @Override
    public String readLine() {
        return scStr.nextLine();
    }

    @Override
    public void close() throws IOException {
        scInt.close();
        scStr.close();
    }
}
