package WithoutFactory.FluentAPI.ApiSteps;

import WithoutFactory.FluentAPI.HomePageAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static FactoryRelated.PageFactory.HomePage.PAGE_URL;

public class HomePageAPISteps {
    HomePageAPI homePageAPI = new HomePageAPI();
    private WebDriver driver;
    public HomePageAPISteps(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
    }
    @Step
    public HomePageAPISteps clickOnKinoButton() {
        driver.findElement(homePageAPI.kinoButtonLocator).click();
        return this;
    }


}
