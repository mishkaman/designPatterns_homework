import Pages.Popup;
import Pages.SiteFirstPage;
import Pages.SiteSecondPage;
import Pages.SiteThirdPage;
import Steps.FirstSiteSteps;
import Steps.PopupSteps;
import Steps.SecondPageSteps;
import Steps.ThirdPageSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.example.ConfigTests;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public class TestClass extends ConfigTests {

    @BeforeClass
    public void config() {
        mainConfig();
        Configuration.browser = "chrome";
        timeout = 25000;
        browserSize = "1920x1080";
    }

    @BeforeMethod
    public void setUp() {

        WebDriverRunner.clearBrowserCache();

    }

    SoftAssert softAssert = new SoftAssert();

    @Test()
    public void Task1(){
        open("https://demoqa.com/");
        FirstSiteSteps firstSiteSteps = new FirstSiteSteps();
        SecondPageSteps secondPageSteps = new SecondPageSteps();
        ThirdPageSteps thirdPageSteps = new ThirdPageSteps();
        PopupSteps popupSteps = new PopupSteps();

        firstSiteSteps.clickForms();


        secondPageSteps.scrollToPracticeForm().clickForms().clickPracticeForms();


        thirdPageSteps.setFirstName("Mike").setLastName("Mania").selectGender("Male").setMobileNumber("579457463").clickSubmit();


        popupSteps.assertheader().assertNameAndLastName().checkGender().assertNumber();
    }
}