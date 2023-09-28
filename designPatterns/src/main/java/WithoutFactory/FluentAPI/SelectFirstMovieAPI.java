package WithoutFactory.FluentAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectFirstMovieAPI {

    public By firstMovieLocator = By.xpath("//div[@class='movies-deal'][3]");
    public By buyButtonLocator = By.linkText("ყიდვა");


}
