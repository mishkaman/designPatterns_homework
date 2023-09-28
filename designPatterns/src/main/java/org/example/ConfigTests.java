package org.example;

import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.downloadsFolder;

public class ConfigTests {
  //  private static WebDriver driver;

  //  static {
  //      WebDriverManager.chromedriver().setup();
  //      driver = new ChromeDriver();
  //  }



    public void mainConfig() {
        Configuration.browserSize = null;
        holdBrowserOpen = false;
        screenshots = true;
        reopenBrowserOnFail = true;
        fastSetValue = true;
        assertionMode = AssertionMode.SOFT;
        fileDownload = FileDownloadMode.HTTPGET;
        reportsFolder = "src/main/resources/failedScreens";
        downloadsFolder = "src/main/resources/images";


    }

}