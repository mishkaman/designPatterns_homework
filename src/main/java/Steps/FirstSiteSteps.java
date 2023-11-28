package Steps;

import Pages.SiteFirstPage;
import Pages.SiteThirdPage;
import io.qameta.allure.Step;

public class FirstSiteSteps {
    SiteFirstPage siteFirstPage = new SiteFirstPage();

    @Step
    public FirstSiteSteps clickForms() {

        siteFirstPage.formsElement.scrollTo().click();
        return this;
    }
}
