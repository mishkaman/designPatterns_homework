package FactoryRelated.PageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SeancePage {

    @FindBy(xpath = "//a[text() = 'კავეა ისთ ფოინთი']")
    public WebElement KaveIstPointButton;

    @FindBys(@FindBy(xpath = "//div[@aria-expanded='true'][@aria-hidden='false'][@style='display: flex;']"))
    public List<WebElement> listOfSeances;

    @FindBy(xpath = ".//li[@class='ui-state-default ui-corner-top'][@aria-selected='false']")
    public List<WebElement> dateListOfTheWeak;
    @FindBy(className = "cinema-title")
    public WebElement cinemaName;





}
