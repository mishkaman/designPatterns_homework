package WithoutFactory.FluentAPI.ApiSteps;

import WithoutFactory.FluentAPI.SeancePageAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SeancePageAPISteps {
    SeancePageAPI seancePageAPI = new SeancePageAPI();
    private WebDriver driver;
    private JavascriptExecutor js;

    public SeancePageAPISteps(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    @Step
    public SeancePageAPISteps scrollToKavea() {
        WebElement kaveIstPointButton = driver.findElement(seancePageAPI.KaveIstPointButton);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", kaveIstPointButton);
        return this;
    }
    @Step
    public SeancePageAPISteps clickOnKavea() {
        driver.findElement(seancePageAPI.KaveIstPointButton).click();
        return this;
    }
    @Step
    public SeancePageAPISteps clickLastDateOfTheWeek() {
        WebElement motherSource = driver.findElement(By.xpath("//div[@class = 'ui-tabs-panel ui-widget-content ui-corner-bottom'][@aria-expanded = 'true'][@style = 'display: block;']"));
        WebElement source1 = motherSource.findElement(By.xpath(".//div[@class = 'calendar-tabs ui-tabs ui-widget ui-widget-content ui-corner-all']"));
        WebElement source2 = source1.findElement(By.xpath(".//ul[@class = 'tabs ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all'][@role = 'tablist']"));
        List<WebElement> dateListOfTheWeak = source2.findElements(By.xpath(".//li[@class = 'ui-state-default ui-corner-top'][@aria-selected = 'false']"));
        WebElement ourDateOfChoice = dateListOfTheWeak.get(dateListOfTheWeak.size()-1);//Last one
        ourDateOfChoice.click();
        return this;
    }
    @Step
    public SeancePageAPISteps checkingAllOptions() {
        List<WebElement> seanceList = driver.findElements(seancePageAPI.listOfSeances);
        WebElement chosenSeance = null;

        if (!seanceList.isEmpty()) {
            chosenSeance = seanceList.get(seanceList.size() - 1);
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", chosenSeance);

            for (WebElement seance : seanceList) {
                String tabName = driver.findElement(seancePageAPI.cinemaName).getText();
                String expectedName = "კავეა ისთ ფოინთი";
                Assert.assertEquals(tabName, expectedName, "Tab name doesn't match the expected name.");
                System.out.println("Seances are from Kavea East Point.");
            }

            chosenSeance.click();
            System.out.println("dada");
        } else {
            System.out.println("No seances available on this date.");
        }
        return this;
    }
}
