package Steps;

import Pages.SiteThirdPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ThirdPageSteps {
    SiteThirdPage siteThirdPage = new SiteThirdPage();
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
    SoftAssert softAssert = new SoftAssert();
    @Step
    public ThirdPageSteps setFirstName(String firstName) {
        siteThirdPage.nameElement.setValue(firstName);
        return this;
    }
    @Step
    public ThirdPageSteps setLastName(String lastName) {
        siteThirdPage.lastNameElement.setValue(lastName);
        return this;
    }
    @Step
    public ThirdPageSteps selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            js.executeScript("arguments[0].scrollIntoView(true);", siteThirdPage.genderElement.get(0));
            js.executeScript("arguments[0].click();", siteThirdPage.genderElement.get(0));
        } else if (gender.equalsIgnoreCase("Female")) {
            js.executeScript("arguments[0].scrollIntoView(true);", siteThirdPage.genderElement.get(1));
            js.executeScript("arguments[0].click();", siteThirdPage.genderElement.get(1));
        } else {
            js.executeScript("arguments[0].scrollIntoView(true);", siteThirdPage.genderElement.get(2));
            js.executeScript("arguments[0].click();", siteThirdPage.genderElement.get(2));
        }
        return this;
    }
    @Step
    public ThirdPageSteps setMobileNumber(String mobileNumber) {
        siteThirdPage.numberElement.setValue(mobileNumber);
        return this;
    }
    @Step
    public ThirdPageSteps clickSubmit(){
        js.executeScript("arguments[0].scrollIntoView(true);", siteThirdPage.submitButton);
        js.executeScript("arguments[0].click();", siteThirdPage.submitButton);
        return this;
    }

}
