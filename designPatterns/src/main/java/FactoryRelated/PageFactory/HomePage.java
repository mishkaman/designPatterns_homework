package FactoryRelated.PageFactory;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage {
    private WebDriver driver;
    public static String PAGE_URL = "https://www.swoop.ge/";

    @FindBy(how = How.LINK_TEXT, using = "კინო")
    public SelenideElement kinoButton;


    public void clickOnKinoButton() {
        kinoButton.click();
    }
}
