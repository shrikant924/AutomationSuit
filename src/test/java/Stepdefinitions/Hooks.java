package Stepdefinitions;

import Core.ThreadLocalDriver;
import Pages.TataplayBinge.TataplayBinge;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    public static JavascriptExecutor jse;

    public void setup() throws IOException {
        ThreadLocalDriver.setThreadLocalDriver(driver);
        driver = ThreadLocalDriver.getThreadLocalDriver();
        driver.get(("https://staging-web-frm.videoready.tv/"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        TataplayBinge tataplayBinge = new TataplayBinge(driver);
        jse = (JavascriptExecutor) driver;

    }


    public void tearDown() throws Throwable {
        Thread.sleep(5000);
        ThreadLocalDriver.closeBrowser();
    }

}
