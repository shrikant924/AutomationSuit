package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("user-data-dir=C:\\Users\\shrikantl\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
            opt.addArguments("disable-infobars");
            opt.addArguments("--start-maximized");
            opt.addArguments("executable_path=C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            ThreadLocalDriver.driver.set(new ChromeDriver(opt));
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
