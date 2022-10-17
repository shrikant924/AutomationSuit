package Pages.TataplayBinge;

import org.bouncycastle.util.test.TestRandomBigInteger;
import org.openqa.selenium.WebDriver;

public class TataplayBinge  {

    Homepage homepage;
    AssetPIPage assetPIPage;

    public TataplayBinge(WebDriver driver) {
        homepage=new Homepage(driver);
        assetPIPage=new AssetPIPage(driver);
    }
}
