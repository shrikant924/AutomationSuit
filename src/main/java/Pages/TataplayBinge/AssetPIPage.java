package Pages.TataplayBinge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetPIPage {

    private final WebDriver driver;

    public AssetPIPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindAll(@FindBy(xpath = "//*[@class='btn primary-btn play-btn']"))
    private static WebElement playCTA;

    public static WebElement playCTA(){
        return playCTA;
    }

    @FindAll(@FindBy(xpath = "(//button)[4]"))
    private static WebElement hotstarproceedCTA;

    public static WebElement hotstarproceedCTA(){
        return hotstarproceedCTA;
    }


}
