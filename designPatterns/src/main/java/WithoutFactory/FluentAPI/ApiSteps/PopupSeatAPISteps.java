package WithoutFactory.FluentAPI.ApiSteps;

import WithoutFactory.FluentAPI.PopupSeatAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PopupSeatAPISteps {
    PopupSeatAPI popupSeatAPI = new PopupSeatAPI();
    private WebDriver driver;
    public PopupSeatAPISteps(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    public PopupSeatAPISteps checkingMovieNameCinemaDatetime() {
        WebElement movieTitleElement = driver.findElement(popupSeatAPI.movieTitleElementLocator);
        List<WebElement> cinemaElements = driver.findElements(popupSeatAPI.cinemaElementsLocator);
        WebElement movieTitleEx = driver.findElement(popupSeatAPI.movieTitleExLocator);
        WebElement cinemaNameEx = driver.findElement(popupSeatAPI.cinemaNameExLocator);
        WebElement ourDateOfChoice = driver.findElement(popupSeatAPI.ourDateOfChoiceLocator);
        List<WebElement> vacantPlaces = driver.findElements(popupSeatAPI.vacantPlacesLocator);

        String movieTitle = movieTitleElement.getText();
        String cinemaName = cinemaElements.get(0).getText();
        String movieDate = cinemaElements.get(1).getText();

        String expectedMovieTitle = movieTitleEx.getText();
        String expectedCinemaName = cinemaNameEx.getText();

        String Date = ourDateOfChoice.getText();
        String firstTwoOfDate = Date.substring(0, 2);
        String chosenSeanceTime = "chosensenaccetime= 18:00"; // Replace this with the actual string
        String timeOnly = chosenSeanceTime.split("=")[1].trim();

        String expectedMovieDate = firstTwoOfDate + " აგვისტო " + timeOnly;

        Assert.assertEquals(movieTitle, expectedMovieTitle, "Movie name doesn't match");
        Assert.assertEquals(cinemaName, expectedCinemaName, "Cinema doesn't match");
        Assert.assertEquals(movieDate, expectedMovieDate, "Datetime doesn't match");
        System.out.println("movie name, cinema, and datetime are valid!");
        return this;
    }
    @Step
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
