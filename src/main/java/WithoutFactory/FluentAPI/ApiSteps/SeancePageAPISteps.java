package WithoutFactory.FluentAPI.ApiSteps;


import WithoutFactory.FluentAPI.SeancePageAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class    SeancePageAPISteps {
    SeancePageAPI seancePageAPI = new SeancePageAPI();
    private WebDriver driver;
    private JavascriptExecutor js;

    public WebElement ourDateOfChoice;
    SoftAssert softAssert = new SoftAssert();
    public SeancePageAPISteps(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    @Step("Scrolls to the button 'კავეა'")
    public SeancePageAPISteps scrollToKavea() {
        WebElement kaveIstPointButton = driver.findElement(seancePageAPI.KaveIstPointButton);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", kaveIstPointButton);
        return this;
    }
    @Step("Clicks on the button 'კავეა'")
    public SeancePageAPISteps clickOnKavea() {
        driver.findElement(seancePageAPI.KaveIstPointButton).click();
        return this;
    }
    @Step("Finds and Clicks the latest available date")
    public SeancePageAPISteps clickLastDateOfTheWeek() {
        WebElement motherSource = driver.findElement(By.xpath("//div[@class = 'ui-tabs-panel ui-widget-content ui-corner-bottom'][@aria-expanded = 'true'][@style = 'display: block;']"));
        WebElement source1 = motherSource.findElement(By.xpath(".//div[@class = 'calendar-tabs ui-tabs ui-widget ui-widget-content ui-corner-all']"));
        WebElement source2 = source1.findElement(By.xpath(".//ul[@class = 'tabs ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all'][@role = 'tablist']"));
        List<WebElement> dateListOfTheWeak = source2.findElements(By.xpath(".//li[@class = 'ui-state-default ui-corner-top'][@aria-selected = 'false']"));
        ourDateOfChoice = dateListOfTheWeak.get(dateListOfTheWeak.size()-1);//Last one
        ourDateOfChoice.click();
        return this;
    }
    @Step("Validated and Chooses the latest Seance")
    public SeancePageAPISteps checkingAllOptions(){
        List<WebElement> listOfSeances = driver.findElements(seancePageAPI.listOfSeances);
        System.out.println(listOfSeances.size());
        WebElement chosenSeance = null;
        if (!listOfSeances.isEmpty()) {
            chosenSeance = listOfSeances.get(listOfSeances.size()-1);
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", chosenSeance);
            for (WebElement seanse: listOfSeances) {
                WebElement cinemaName = seanse.findElement(seancePageAPI.cinemaName);
                String tabName = cinemaName.getText();
                String expectedName = "კავეა ისთ ფოინთი";
                softAssert.assertEquals(tabName, expectedName, "Tab name doesn't match the expected name.");
                System.out.println("seanses are from Kavea east point");
            }
            chosenSeance.click();
        } else {
            System.out.println("No seanses available on this date.");
        }
        return this;
    }
}
