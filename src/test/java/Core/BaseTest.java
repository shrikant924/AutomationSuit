package Core;

import Pages.TataplayBinge.TataplayBinge;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static JavascriptExecutor jse;
    public static Wait wait;
    public static Actions actions;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static LocalDateTime now = LocalDateTime.now();


    public void setup() throws IOException {

        ThreadLocalDriver.setThreadLocalDriver(driver);
        driver = ThreadLocalDriver.getThreadLocalDriver();
        driver.get(("https://staging-web-frm.videoready.tv/"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        TataplayBinge tataplayBinge = new TataplayBinge(driver);
        jse = (JavascriptExecutor) driver;
        System.out.println(now);
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }


    public void tearDown() throws Throwable {
        Thread.sleep(10000);
        ThreadLocalDriver.closeBrowser();
    }
}
