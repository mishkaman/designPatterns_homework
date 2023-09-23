package NoFactoryTest;

import FactoryRelated.PageFactory.FactorySteps.HomePageSteps;
import FactoryRelated.PageFactory.FactorySteps.PopupSteps;
import FactoryRelated.PageFactory.FactorySteps.SeancePageSteps;
import FactoryRelated.PageFactory.FactorySteps.SelectFirstMovieSteps;
import WithoutFactory.FluentAPI.ApiSteps.HomePageAPISteps;
import WithoutFactory.FluentAPI.ApiSteps.PopupSeatAPISteps;
import WithoutFactory.FluentAPI.ApiSteps.SeancePageAPISteps;
import WithoutFactory.FluentAPI.ApiSteps.SelectFirstMovieAPISteps;
import WithoutFactory.FluentAPI.HomePageAPI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ConfigTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.module.Configuration;
import java.util.concurrent.TimeUnit;

public class TestClass extends ConfigTests {
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
        HomePageAPISteps homePageAPISteps = new HomePageAPISteps(driver);
        homePageAPISteps.clickOnKinoButton();

        SelectFirstMovieAPISteps selectFirstMovieAPISteps = new SelectFirstMovieAPISteps(driver);
        selectFirstMovieAPISteps.scrollToFirstMovie().hoverOverHomie().clickBuyButton();

        SeancePageAPISteps seancePageAPISteps =  new SeancePageAPISteps(driver);
        seancePageAPISteps.scrollToKavea().clickOnKavea().checkingAllOptions().clickLastDateOfTheWeek();

        PopupSeatAPISteps popupSeatAPISteps =  new PopupSeatAPISteps(driver);
        popupSeatAPISteps.checkingMovieNameCinemaDatetime().chooseAFreeSeat();




        }
    @AfterClass
    public void breakdown(){
        driver.close();
    }
}
