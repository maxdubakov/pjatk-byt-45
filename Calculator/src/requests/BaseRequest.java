package requests;

import java.util.HashMap;
import java.util.Map;

public class BaseRequest implements Request {

    private final Map<String, Object> data;

    public BaseRequest() {
        this.data = new HashMap<>();
    }

    @Override
    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    @Override
    public Map<String, Object> data() {
        return data;
    }
}
