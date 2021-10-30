package responses;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse implements Response {

    private final Map<String, Object> data;

    public BaseResponse() {
        this.data = new HashMap<>();
    }

    public Map<String, Object> data() {
        return data;
    }

    @Override
    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    @Override
    public void show() {
        for (Map.Entry<String, Object> entry : this.data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
