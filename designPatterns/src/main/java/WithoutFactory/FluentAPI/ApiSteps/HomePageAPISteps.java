package WithoutFactory.FluentAPI.ApiSteps;
import WithoutFactory.FluentAPI.HomePageAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static FactoryRelated.PageFactory.HomePage.PAGE_URL;

public class HomePageAPISteps {
    HomePageAPI homePageAPI = new HomePageAPI();
    private WebDriver driver;
    public HomePageAPISteps(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
    }
    @Step("Click on the button named '{buttonName}'")
    public HomePageAPISteps clickOnButtonByName(String buttonName) {
        driver.findElement(homePageAPI.getButtonLocatorByName(buttonName)).click();
        return this;
    }


}
