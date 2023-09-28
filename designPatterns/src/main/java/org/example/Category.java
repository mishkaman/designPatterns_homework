package org.example;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Category {
    private String name;
    private String[] matchedStatuses;
    private String messageRegex;
    private String traceRegex;

    public String getName() {
        return name;
    }

    public boolean matches(String message) {
        if (messageRegex != null && message.matches(messageRegex)) {
            return true;
        }
        return false;
    }

    public static List<Category> fromJsonArray(String json) {
        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(json, Category[].class));
    }
}
