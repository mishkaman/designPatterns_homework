package FactoryRelated.PageFactory.FactorySteps;

import FactoryRelated.PageFactory.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static FactoryRelated.PageFactory.HomePage.PAGE_URL;

public class HomePageSteps {
    public HomePageSteps (WebDriver driver) {
        this.driver =driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
    HomePage homePage = new HomePage();

    @Step
    public HomePageSteps clickOnKinoButton() {
        homePage.kinoButton.click();
        return this;
    }
}
