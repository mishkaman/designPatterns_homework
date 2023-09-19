package Steps;

import Data.LoginData;
import Pages.Popup;
import Pages.SiteThirdPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PopupSteps {
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
    SoftAssert softAssert = new SoftAssert();
    Popup popup = new Popup();
    SiteThirdPage siteThirdPage = new SiteThirdPage();
    LoginData loginData = new LoginData();

    @Step
    public PopupSteps assertheader(){
        softAssert.assertEquals(popup.header.getText(), loginData.header);
        softAssert.assertAll();
        return this;
    }

    @Step
    public PopupSteps assertNameAndLastName(){
        softAssert.assertEquals(popup.studentName.getText(), siteThirdPage.nameElement.getValue()+" "+siteThirdPage.lastNameElement.getValue());//name and last name
        softAssert.assertAll();
        return this;
    }

    @Step
    public PopupSteps checkGender(){
        softAssert.assertEquals(popup.studentGender.getText(), LoginData.getSelectedGender(siteThirdPage.genderElement));
        softAssert.assertAll();
        return this;
    }

    @Step
    public PopupSteps assertNumber(){
        softAssert.assertEquals(popup.studentNumber.getText(), siteThirdPage.numberElement.getValue());
        softAssert.assertAll();
        return this;
    }

}
