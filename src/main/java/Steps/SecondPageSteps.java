package Steps;

import Pages.SiteSecondPage;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


import Data.LoginData;

import io.qameta.allure.Step;

public class SecondPageSteps {
    SiteSecondPage siteSecondPage = new SiteSecondPage();
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();

    @Step
    public SecondPageSteps scrollToPracticeForm() {
        js.executeScript("arguments[0].scrollIntoView(true);", siteSecondPage.practiceFormElement);
        return this;
    }

    @Step
    public SecondPageSteps clickForms(){
        js.executeScript("arguments[0].click();", siteSecondPage.practiceFormElement);
        return this;
    }
    @Step
    public SecondPageSteps clickPracticeForms(){    js.executeScript("arguments[0].click();", siteSecondPage.practiceForm);
        return this;
    }
}
