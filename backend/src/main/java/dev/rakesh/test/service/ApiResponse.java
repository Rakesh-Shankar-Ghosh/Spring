package dev.rakesh.test.service;


import java.util.HashMap;

public class ApiResponse extends HashMap<String, Object> {

    public ApiResponse() {
        super();
    }

    public ApiResponse(String key, Object value) {
        super();
        this.put(key, value);
    }

    public ApiResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
