package org.example;

import com.codeborne.selenide.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.downloadsFolder;

public class ConfigTests {


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