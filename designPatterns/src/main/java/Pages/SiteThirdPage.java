package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SiteThirdPage {
    public SelenideElement nameElement = $("#firstName");

    public SelenideElement lastNameElement = $("#lastName");

    public ElementsCollection genderElement = $$("input[name='gender']");

    public SelenideElement numberElement = $("#userNumber");

    public SelenideElement submitButton = $("#submit");

}
