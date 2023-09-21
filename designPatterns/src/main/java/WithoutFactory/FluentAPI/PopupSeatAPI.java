package WithoutFactory.FluentAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PopupSeatAPI {
    private WebDriver driver;

    public By contentHeaderLocator = By.xpath("//div[@class = 'content-header']");
    public By movieTitleElementLocator = By.xpath(".//p[@class = 'movie-title']");
    public By cinemaElementsLocator = By.xpath(".//p[@class = 'movie-cinema']");
    public By movieTitleExLocator = By.xpath("//p[@class = 'name']");
    public By cinemaNameExLocator = By.xpath("//a[@id = 'ui-id-6']");
    public By ourDateOfChoiceLocator = By.xpath("//div[@aria-expanded='true'][@aria-hidden='false'][@style='display: flex;'][last()]");
    public By vacantPlacesLocator = By.xpath("//div[contains(@class, 'seat free')]");



}
