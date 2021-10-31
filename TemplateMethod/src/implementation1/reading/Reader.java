package implementation1.reading;

import java.io.IOException;

public abstract class Reader {

    public abstract void open();

    public abstract Integer readInt();

    public abstract String readLine();

    public abstract void close() throws IOException;
}
