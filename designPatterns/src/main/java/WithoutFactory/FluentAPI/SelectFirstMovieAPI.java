package WithoutFactory.FluentAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectFirstMovieAPI {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public By firstMovieLocator = By.xpath("//div[@class='movies-deal'][2]");
    public By buyButtonLocator = By.linkText("ყიდვა");


}
