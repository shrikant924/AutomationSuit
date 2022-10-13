package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ThreadLocalDriver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    static String broserName = "chrome";

    public ThreadLocalDriver() throws FileNotFoundException {
    }


    public static void setThreadLocalDriver(WebDriver driver) throws IOException {
        if (broserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ThreadLocalDriver.driver.set(new ChromeDriver());
        } else if (broserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            ThreadLocalDriver.driver.set(new FirefoxDriver());
        }
        if (broserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            ThreadLocalDriver.driver.set(new EdgeDriver());
        }

    }

    public static WebDriver getThreadLocalDriver() {
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().close();
        driver.remove();
    }

}
