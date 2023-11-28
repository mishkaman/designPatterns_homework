package FactoryRelated.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PopupSeat {


    //ACTUAL MOVIE INFO

    @FindBy(xpath = "//div[@class = 'content-header']")
    public WebElement contentHeader;

    @FindBy(xpath = ".//p[@class = 'movie-title']")
    public WebElement movieTitleElement;

    @FindBy(xpath = ".//p[@class = 'movie-cinema']")
    public List<WebElement> cinemaElements;

    //EXPECTED MOVIE INFO

    @FindBy(xpath = "//p[@class = 'name']")
    public WebElement movieTitleEx;

    @FindBy(xpath = "//a[@id = 'ui-id-6']")
    public WebElement cinemaNameEx;

    @FindBys(@FindBy(xpath = "//div[@aria-expanded='true'][@aria-hidden='false'][@style='display: flex;'][last()]"))
    public WebElement ourDateOfChoice;

    @FindBy(xpath = "//div[contains(@class, 'seat free')]")
    public List<WebElement> vacantPlaces;

}
