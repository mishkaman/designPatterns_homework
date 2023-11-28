package FactoryRelated.PageFactory.FactorySteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import FactoryRelated.PageFactory.SelectFirstMovie;
import java.time.Duration;

public class SelectFirstMovieSteps{
    private WebDriver driver;
    public SelectFirstMovieSteps (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    SelectFirstMovie selectFirstMovie = new SelectFirstMovie();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    @Step
    public SelectFirstMovieSteps scrollToFirstMovie() {
        actions.moveToElement(selectFirstMovie.firstMovie).perform();
        return this;
    }

    @Step
    public SelectFirstMovieSteps hoverOverHomie(){
        actions.moveToElement(selectFirstMovie.firstMovie).perform();
        return this;
    }
    @Step
    public SelectFirstMovieSteps clickBuyButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selectFirstMovie.buyButton)).click();
        return this;
    }


}
