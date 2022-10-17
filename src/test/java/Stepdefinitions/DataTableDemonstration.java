package Stepdefinitions;

import Core.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataTableDemonstration extends BaseTest {


    @Given("User should be on Data Entry page")
    public void userShouldBeOnDataEntryPage() {
        driver.get("https://formfilling.co.in/");
        driver.findElement(By.xpath("(//li/a)[1]")).click();
    }

    @Then("Input the below data")
    public void inputTheBelowData(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps();
        System.out.println(data);
        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys(data.get(0).get("UserName"));
        driver.findElement(By.id("Password")).sendKeys(data.get(0).get("Password"));
        driver.findElement(By.id("Password")).sendKeys(data.get(0).get("ConfirmPassword"));
        driver.findElement(By.id("name")).sendKeys(data.get(0).get("Name"));
        driver.findElement(By.id("mobile")).sendKeys(data.get(0).get("Mobile"));
        driver.findElement(By.id("DateofBirth")).sendKeys(data.get(0).get("DOB"));
        driver.findElement(By.id("Address")).sendKeys(data.get(0).get("Address"));
        driver.findElement(By.id("pincode")).sendKeys(data.get(0).get("PinCode"));
    }

}