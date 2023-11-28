package Data;

import Steps.ThirdPageSteps;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.devtools.v113.audits.model.FederatedAuthRequestIssueDetails;

import java.util.Collections;

public class LoginData {
    ThirdPageSteps thirdPageSteps = new ThirdPageSteps();

    public String header = "Thanks for submitting the form";

    public static String getSelectedGender(ElementsCollection genderElements) {
        for (SelenideElement genderOption : genderElements) {
            if (genderOption.isSelected()) {
                return genderOption.getValue();
            }
        }
        return null;
    }
}