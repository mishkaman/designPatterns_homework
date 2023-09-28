    package NoFactoryTest;

    import com.codeborne.selenide.Configuration;
    import com.codeborne.selenide.logevents.SelenideLogger;
    import io.qameta.allure.Description;
    import io.qameta.allure.selenide.AllureSelenide;
    import jdk.jfr.Label;
    import org.example.TestCategorizer;
    import org.testng.ITestResult;
    import org.testng.annotations.*;

    import static com.codeborne.selenide.Configuration.*;
    import static com.codeborne.selenide.FileDownloadMode.HTTPGET;



    import WithoutFactory.FluentAPI.ApiSteps.HomePageAPISteps;
    import WithoutFactory.FluentAPI.ApiSteps.PopupSeatAPISteps;
    import WithoutFactory.FluentAPI.ApiSteps.SeancePageAPISteps;
    import WithoutFactory.FluentAPI.ApiSteps.SelectFirstMovieAPISteps;
    import com.google.common.collect.ImmutableMap;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import io.qameta.allure.*;
    import org.example.ConfigTests;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.asserts.SoftAssert;

    import java.util.concurrent.TimeUnit;

    import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

    @Epic("Choose a seat of our chosen Movie")
    @Feature("Seat Selection")
    public class TestClass extends ConfigTests {
        private SoftAssert softAssert = new SoftAssert();
        private TestCategorizer categorizer;
        public static WebDriver driver;
        public TestClass() {
            categorizer = new TestCategorizer("C:\\Users\\mishk\\Desktop\\1212\\designPatterns_homework\\designPatterns\\src\\main\\resources\\allure-results\\categories.json");
            holdBrowserOpen = false;
            reopenBrowserOnFail = true;
            screenshots = true;
            Configuration.fileDownload = HTTPGET;
            reportsFolder = "C:\\Users\\mishk\\Desktop\\1212\\designPatterns_homework\\designPatterns\\screenshots";
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        }
        @BeforeSuite
        void setAllureEnvironment() {
            allureEnvironmentWriter(
                    ImmutableMap.<String, String>builder()
                            .put("Browser", "Chrome")
                            .put("URL", "https://www.swoop.ge/")
                            .build(), System.getProperty("user.dir")
                            + "/allure-results/");
        }

        @BeforeClass
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Label("Category")
        @Description("The test navigates to the Movies section chooses a certain movie and click on the last date and last seance available, afterwards click s on the first free seat on a specific movie.")
        @Severity(SeverityLevel.TRIVIAL)
        @Story("Task1 performs all the required actions")
        @Test
        public void Task1() {
            HomePageAPISteps homePageAPISteps = new HomePageAPISteps(driver);
            homePageAPISteps.clickOnButtonByName("კინო");

            SelectFirstMovieAPISteps selectFirstMovieAPISteps = new SelectFirstMovieAPISteps(driver);
            selectFirstMovieAPISteps.scrollToFirstMovie()
                                    .hoverOverHomie()
                                    .clickBuyButton();

            SeancePageAPISteps seancePageAPISteps =  new SeancePageAPISteps(driver);
            seancePageAPISteps.scrollToKavea()
                              .clickOnKavea()
                              .checkingAllOptions()
                              .clickLastDateOfTheWeek();

            PopupSeatAPISteps popupSeatAPISteps =  new PopupSeatAPISteps(driver);
            popupSeatAPISteps.checkingMovieNameCinemaDatetime()
                             .chooseAFreeSeat();

            }
        @AfterMethod
        public void categorizeAndAddLabels(ITestResult result) {
            String message = result.getThrowable().getMessage();
            boolean testResultFailed = result.getStatus() == ITestResult.FAILURE;

            String category = categorizer.categorizeTestResult(message, testResultFailed);

        }
        @AfterClass
        public void breakdown(){
            driver.close();
        }
    }
