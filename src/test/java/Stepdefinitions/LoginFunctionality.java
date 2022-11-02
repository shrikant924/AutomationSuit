package Stepdefinitions;

import Core.BaseTest;
import Pages.TataplayBinge.Homepage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class LoginFunctionality extends BaseTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws InterruptedException {


        {
            try {
                if (Homepage.notNow() != null) {
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.notNow()));
                    jse.executeScript("arguments[0].click();", Homepage.notNow());
                    System.out.println("CLicked on not now CTA");
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.doItLater()));
                    Homepage.doItLater().click();
                }
            } catch (Exception e) {

            }

            try {

                if (Homepage.myPlanText()==null) {
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.profileIcon()));
                    jse.executeScript("arguments[0].click();", Homepage.profileIcon());
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.loginCTA()));
                    jse.executeScript("arguments[0].click();", Homepage.loginCTA());
                }
            } catch (Exception e) {
            }

        }


    }

    @Then("enter <{string}> and <{string}>")
    public void enter_and(String str1, String str2) throws InterruptedException {
        {
            try {

                if (Homepage.myPlanText().equals(null)) {
                    wait.until(ExpectedConditions.visibilityOf(Homepage.rmnInputField()));
                    Homepage.rmnInputField().sendKeys(str1);
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.getOtpCta()));
                    Homepage.getOtpCta().click();
                    wait.until(ExpectedConditions.visibilityOf(Homepage.otpInputField()));
                    Homepage.otpInputField().sendKeys(str2);
                }
            } catch (Exception e) {

            }

        }


    }

    @And("verify user is logged in successfully <{string}>")
    public void verify_user_is_logged_in_successfully(String str1) throws InterruptedException {
        {
            try {

                if (Homepage.myPlanText().equals(null)) {
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.profileIcon()));
                    jse.executeScript("arguments[0].click();", Homepage.profileIcon());
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.loggedInRmnInfo()));
                    Assert.assertEquals(Homepage.loggedInRmnInfo().getText(), "+91 " + str1);
                }
            } catch (Exception e) {

            }
        }

    }

    @After
    public void closure() throws Throwable {
        super.tearDown();
    }
}
