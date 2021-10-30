package requests;

import java.util.Map;

public interface Request {

    Map<String, Object> data();

    void addData(String key, Object value);
}
