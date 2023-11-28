package WithoutFactory.FluentAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageAPI {
    private static String PAGE_URL = "https://www.swoop.ge/";

    public By getButtonLocatorByName(String buttonName) {
        return By.linkText(buttonName);
    }

}
