package FactoryRelated.PageFactory.FactorySteps;

import FactoryRelated.PageFactory.PopupSeat;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PopupSteps {
    PopupSeat popupSeat = new PopupSeat();
    private WebDriver driver;
    public PopupSteps(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @Step
    public PopupSteps checkingMovieNameCinemaDatetime(){
        String movieTitle = popupSeat.movieTitleElement.getText();
        String cinemaName = popupSeat.cinemaElements.get(0).getText();
        String movieDate = popupSeat.cinemaElements.get(1).getText();

        String expectedMovieTitle = popupSeat.movieTitleEx.getText();
        String expectedCinemaName = popupSeat.cinemaNameEx.getText();

        String Date = popupSeat.ourDateOfChoice.getText();
        String firstTwoOfDate = Date.substring(0, 2);
        String chosenSeanceTime = "chosensenaccetime= 18:00"; // Replace this with the actual string
        String timeOnly = chosenSeanceTime.split("=")[1].trim();

        String expectedMovieDate = firstTwoOfDate + " აგვისტო " + timeOnly;

        Assert.assertEquals(movieTitle, expectedMovieTitle, "Movie name doesn't match");
        Assert.assertEquals(cinemaName, expectedCinemaName, "Cinema doesn't match");
        Assert.assertEquals(movieDate, expectedMovieDate, "Datetime doesn't match");
        System.out.println("movie name, cinema and datetime is valid!");

        return this;
    }
    @Step
    public PopupSteps chooseAFreeSeat(){
        if (!popupSeat.vacantPlaces.isEmpty()) {
            WebElement chosenSeat = popupSeat.vacantPlaces.get(0);
            chosenSeat.click();
        } else {
            System.out.println("No vacant seats available.");
        }
        return this;
    }

}
