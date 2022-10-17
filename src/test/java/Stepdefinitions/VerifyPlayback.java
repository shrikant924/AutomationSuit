package Stepdefinitions;

import Core.BaseTest;
import Pages.TataplayBinge.AssetPIPage;
import Pages.TataplayBinge.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyPlayback extends BaseTest {
    @And("click on homepage")
    public void clickOnHomepage() throws InterruptedException {

        jse.executeScript("arguments[0].click();",Homepage.asset());

    }

    @Then("Click on play CTA")
    public void clickOnPlayCTA() throws Throwable{

        AssetPIPage.playCTA().click();
        Thread.sleep(20000);
    }
}
