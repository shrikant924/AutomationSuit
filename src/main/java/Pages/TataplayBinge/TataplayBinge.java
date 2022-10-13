package Pages.TataplayBinge;

import org.openqa.selenium.WebDriver;

public class TataplayBinge {

    Homepage homepage;

    public TataplayBinge(WebDriver driver) {

        homepage=new Homepage(driver);
    }
}
