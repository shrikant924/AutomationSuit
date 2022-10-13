package Stepdefinitions;

import Core.BaseTest;
import Pages.TataplayBinge.Homepage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginFunctionality extends BaseTest {

    Wait wait;
    JavascriptExecutor js;
    Actions actions;


    @Before
    public void setup() throws IOException {
        super.setup();
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

    }

    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws InterruptedException {


        {
            try {
                if (Homepage.notNow() != null) {
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.notNow()));
                    js.executeScript("arguments[0].click();", Homepage.notNow());
                    System.out.println("CLicked on not now CTA");
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(Homepage.doItLater()));
                    Homepage.doItLater().click();
                }
            } catch (Exception e) {

            }

        }
        wait.until(ExpectedConditions.elementToBeClickable(Homepage.profileIcon()));
        js.executeScript("arguments[0].click();", Homepage.profileIcon());


        wait.until(ExpectedConditions.elementToBeClickable(Homepage.loginCTA()));
        js.executeScript("arguments[0].click();", Homepage.loginCTA());


    }

    @Then("enter <{string}> and <{string}>")
    public void enter_and(String str1, String str2) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(Homepage.rmnInputField()));
        Homepage.rmnInputField().sendKeys(str1);
        wait.until(ExpectedConditions.elementToBeClickable(Homepage.getOtpCta()));
        Homepage.getOtpCta().click();
        wait.until(ExpectedConditions.visibilityOf(Homepage.otpInputField()));
        Homepage.otpInputField().sendKeys(str2);
    }

    @And("verify user is logged in successfully <{string}>")
    public void verify_user_is_logged_in_successfully(String str1) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(Homepage.profileIcon()));
        js.executeScript("arguments[0].click();", Homepage.profileIcon());
        wait.until(ExpectedConditions.elementToBeClickable(Homepage.loggedInRmnInfo()));
        Assert.assertEquals(Homepage.loggedInRmnInfo().getText(), "+91 " + str1);

    }

    @After
    public void closure() {
        super.tearDown();
    }
}