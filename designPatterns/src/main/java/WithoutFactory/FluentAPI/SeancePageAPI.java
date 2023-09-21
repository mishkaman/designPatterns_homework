package WithoutFactory.FluentAPI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SeancePageAPI {

    public By KaveIstPointButton = By.xpath("//a[text() = 'კავეა ისთ ფოინთი']");
    public By listOfSeances = By.xpath("//div[@aria-expanded='true'][@aria-hidden='false'][@style='display: flex;']");
    public By cinemaName = By.className("cinema-title");




}
