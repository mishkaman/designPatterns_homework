package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Popup {


    public SelenideElement header = $("#example-modal-sizes-title-lg");

    public SelenideElement studentName = $(By.xpath("//tbody/tr[1]/td[2]"));

    public SelenideElement studentGender = $(By.xpath("//tbody/tr[3]/td[2]"));

    public SelenideElement studentNumber = $(By.xpath("//tbody/tr[4]/td[2]"));





}
