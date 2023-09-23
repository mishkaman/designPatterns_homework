package PageFactoryTest;

import FactoryRelated.PageFactory.FactorySteps.HomePageSteps;
import FactoryRelated.PageFactory.FactorySteps.PopupSteps;
import FactoryRelated.PageFactory.FactorySteps.SeancePageSteps;
import FactoryRelated.PageFactory.FactorySteps.SelectFirstMovieSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ConfigTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class FinalProjTestClass extends ConfigTests {
    private SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void Task1() {
        HomePageSteps homePageSteps = new HomePageSteps(driver);
        homePageSteps.clickOnKinoButton();

        SelectFirstMovieSteps selectFirstMovieSteps = new SelectFirstMovieSteps(driver);
        selectFirstMovieSteps.scrollToFirstMovie().hoverOverHomie().clickBuyButton();

        SeancePageSteps seancePageSteps = new SeancePageSteps(driver);
        seancePageSteps.scrollToKavea().clickOnKavea().checkingAllOptions().clickLastDateOfTheWeek();

        PopupSteps popupSteps = new PopupSteps(driver);
        popupSteps.checkingMovieNameCinemaDatetime().chooseAFreeSeat();




    }
    @AfterClass
    public void breakdown(){
        driver.close();
    }
}
