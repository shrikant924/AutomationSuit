package Core;

import Pages.TataplayBinge.TataplayBinge;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        ThreadLocalDriver.setThreadLocalDriver(driver);
        driver = ThreadLocalDriver.getThreadLocalDriver();
        driver.get(("https://staging-web-frm.videoready.tv/"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        TataplayBinge tataplayBinge = new TataplayBinge(driver);
    }

    @AfterClass
    public void tearDown() {
        ThreadLocalDriver.closeBrowser();
    }
}
