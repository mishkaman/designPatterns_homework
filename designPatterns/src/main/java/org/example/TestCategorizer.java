package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCategorizer {
    private List<Map<String, Object>> categories;

    public TestCategorizer(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            categories = objectMapper.readValue(new File(filePath),
                    new TypeReference<List<Map<String, Object>>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String categorizeTestResult(String message, boolean testResultFailed) {
        for (Map<String, Object> category : categories) {
            String categoryName = (String) category.get("name");
            List<String> matchedStatuses = (List<String>) category.get("matchedStatuses");
            String messageRegex = (String) category.get("messageRegex");

            if (matchedStatuses.contains("failed") && testResultFailed && message.matches(messageRegex)) {
                return categoryName;
            }
        }
        return "Uncategorized";
    }
}
