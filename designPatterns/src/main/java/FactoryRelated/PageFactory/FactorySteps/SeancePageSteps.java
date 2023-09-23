package FactoryRelated.PageFactory.FactorySteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import FactoryRelated.PageFactory.SeancePage;

import java.util.List;

public class SeancePageSteps {
    SeancePage seancePage =  new SeancePage();
    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public SeancePageSteps (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @Step
    public SeancePageSteps scrollToKavea(){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", seancePage.KaveIstPointButton);
        return this;
    }
    @Step
    public SeancePageSteps clickOnKavea(){
        seancePage.KaveIstPointButton.click();
        return this;
    }
    @Step
    public SeancePageSteps clickLastDateOfTheWeek() {
        seancePage.dateListOfTheWeak.get(seancePage.dateListOfTheWeak.size()-1).click();
        return this;
    }
    @Step
    public SeancePageSteps checkingAllOptions(){
        WebElement motherSource = driver.findElement(By.xpath("//div[@class = 'ui-tabs-panel ui-widget-content ui-corner-bottom'][@aria-expanded = 'true'][@style = 'display: block;']"));
        WebElement source1 = motherSource.findElement(By.xpath(".//div[@class = 'calendar-tabs ui-tabs ui-widget ui-widget-content ui-corner-all']"));
        WebElement source2 = source1.findElement(By.xpath(".//ul[@class = 'tabs ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all'][@role = 'tablist']"));
        List<WebElement> dateListOfTheWeak = source2.findElements(By.xpath(".//li[@class = 'ui-state-default ui-corner-top'][@aria-selected = 'false']"));
        WebElement ourDateOfChoice = dateListOfTheWeak.get(dateListOfTheWeak.size()-1);//Last one
        ourDateOfChoice.click();

        WebElement chosenSeanse = null;
        if (!seancePage.listOfSeances.isEmpty()) {
            chosenSeanse = seancePage.listOfSeances.get(seancePage.listOfSeances.size()-1);
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", chosenSeanse);
            for (WebElement seanse: seancePage.listOfSeances) {
                String tabName = seancePage.cinemaName.getText();
                String expectedName = "კავეა ისთ ფოინთი";
                Assert.assertEquals(tabName, expectedName, "Tab name doesn't match the expected name.");
                System.out.println("seanses are from kavea east point");
            }
            chosenSeanse.click();
        } else {
            System.out.println("No seanses available on this date.");
        }
        return this;
    }

}
