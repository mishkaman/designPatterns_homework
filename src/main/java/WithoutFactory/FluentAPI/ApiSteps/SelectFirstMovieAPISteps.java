package WithoutFactory.FluentAPI.ApiSteps;

import WithoutFactory.FluentAPI.SelectFirstMovieAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectFirstMovieAPISteps{
    SelectFirstMovieAPI selectFirstMovieAPI =  new SelectFirstMovieAPI();
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    public SelectFirstMovieAPISteps(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Scrolls to the chosen movie")
    public SelectFirstMovieAPISteps scrollToFirstMovie() {
        WebElement firstMovieElement = driver.findElement(selectFirstMovieAPI.firstMovieLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstMovieElement);
        return this;
    }

    @Step("Hovers over the chosen movie")
    public SelectFirstMovieAPISteps hoverOverHomie() {
        WebElement firstMovie = driver.findElement(selectFirstMovieAPI.firstMovieLocator);
        actions.moveToElement(firstMovie).perform();
        return this;
    }
    @Step("Clicks the button named 'ყიდვა'")
    public SelectFirstMovieAPISteps clickBuyButton() {
        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(selectFirstMovieAPI.buyButtonLocator)));
        buyButton.click();
        return this;
    }
}
