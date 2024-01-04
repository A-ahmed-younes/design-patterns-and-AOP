package ma.enset.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer<T> {
    public String toJson(T dataObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObject);
            return json;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
