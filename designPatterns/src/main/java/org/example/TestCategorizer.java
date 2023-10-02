package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TestCategorizer {
    private List<Category> categories;

    public TestCategorizer(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath));
            categories = Category.fromJsonArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String categorizeTestResult(String message, boolean testResultFailed) {
        if (testResultFailed) {
            for (Category category : categories) {
                if (category.matches(message)) {
                    return category.getName();
                }
            }
        }
        return "Other"; // Default category if no match
    }
}
