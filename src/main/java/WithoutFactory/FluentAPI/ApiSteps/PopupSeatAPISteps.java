package WithoutFactory.FluentAPI.ApiSteps;

import WithoutFactory.FluentAPI.PopupSeatAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class PopupSeatAPISteps {

    PopupSeatAPI popupSeatAPI = new PopupSeatAPI();

    SoftAssert softAssert = new SoftAssert();
    private WebDriver driver;
    private WebDriverWait wait;
    SeancePageAPISteps seancePageAPISteps = new SeancePageAPISteps(driver);
    public PopupSeatAPISteps(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Validating if the Movie details are correct")
    public PopupSeatAPISteps checkingMovieNameCinemaDatetime() {
        WebElement contentHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(popupSeatAPI.contentHeaderLocator));
        WebElement movieTitleElement = contentHeader.findElement(popupSeatAPI.movieTitleElementLocator);
        List<WebElement> cinemaElements = contentHeader.findElements(popupSeatAPI.cinemaElementsLocator);


        String movieTitle = movieTitleElement.getText();
        String cinemaName = cinemaElements.get(0).getText();
        String movieDate = cinemaElements.get(1).getText();



        String expectedMovieTitle = driver.findElement(popupSeatAPI.movieTitleExLocator).getText();
        String expectedCinemaName = driver.findElement(popupSeatAPI.cinemaNameExLocator).getText();


        String Date = seancePageAPISteps.ourDateOfChoice.getText();
        String firstTwoOfDate = Date.substring(0, 2);
        String chosenSeanceTime = "chosensenaccetime= 18:00"; // Replace this with the actual string
        String timeOnly = chosenSeanceTime.split("=")[1].trim();

        String expectedMovieDate = firstTwoOfDate + " აგვისტო " + timeOnly;

        softAssert.assertEquals(movieTitle, expectedMovieTitle, "Movie name doesn't match");
        softAssert.assertEquals(cinemaName, expectedCinemaName, "Cinema doesn't match");
        softAssert.assertEquals(movieDate, expectedMovieDate, "Datetime doesn't match");
        System.out.println("movie name, cinema, and datetime are valid!");
        return this;
    }
    @Step("Click on a free seat")
    public PopupSeatAPISteps chooseAFreeSeat() {
        List<WebElement> vacantPlaces = driver.findElements(popupSeatAPI.vacantPlacesLocator);

        if (!vacantPlaces.isEmpty()) {
            WebElement chosenSeat = vacantPlaces.get(0);
            chosenSeat.click();
        } else {
            System.out.println("No vacant seats available.");
        }
        return this;
    }

}
