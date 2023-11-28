package FactoryRelated.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SelectFirstMovie {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='movies-deal'][2]")
    public WebElement firstMovie;

    @FindBy(linkText = "ყიდვა")
    public WebElement buyButton;





}
