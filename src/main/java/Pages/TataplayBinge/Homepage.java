package Pages.TataplayBinge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {


    private static WebDriver driver;

    public Homepage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = "//*[contains(text(),'Do it Later')]"))
    private static WebElement doItLater;

    public static WebElement doItLater() {

        return doItLater;
    }

    @FindAll(@FindBy(xpath = "//*[contains(text(),'Not Now')]"))
    private static WebElement notNow;

    public static WebElement notNow() {
        return notNow;
    }

    @FindAll(@FindBy(xpath = "//*[@alt='unkown-user-avatar']"))
    private static WebElement profileIcon;

    public static WebElement profileIcon() {
        return profileIcon;
    }

    @FindAll(@FindBy(xpath = " (//*[contains(text(),'Log In')])[1]"))
    private static WebElement loginCTA;

    public static WebElement loginCTA() {
        return loginCTA;
    }

    @FindAll(@FindBy(xpath = "//*[@name='rmn']"))
    private static WebElement rmnInputField;

    public static WebElement rmnInputField() {
        return rmnInputField;
    }

    @FindAll(@FindBy(xpath = "//*[contains(text(),'Get OTP')]"))
    private static WebElement getOtpCta;

    public static WebElement getOtpCta() {
        return getOtpCta;
    }

    @FindAll(@FindBy(xpath = "(//*[@inputmode='decimal'])[1]"))
    private static WebElement otpInputField;

    public static WebElement otpInputField() {
        return otpInputField;
    }

    @FindAll(@FindBy(xpath = " (//*[@class='user-detail user-rmn-detail'])[1]"))
    private static WebElement loggedInRmnInfo;

    public static WebElement loggedInRmnInfo() {
        return loggedInRmnInfo;
    }



    @FindAll(@FindBy(xpath = "(//*[@class='slick-arrow slick-next'])[1]"))
    private static WebElement nextButton;

    public static WebElement nextButton()
    {
        return nextButton;
    }

    @FindAll(@FindBy(xpath = "(//div[@class='hero-banner']/img)[1]"))
    private static WebElement heroBannerImg;

    public static WebElement heroBannerImg()
    {
        return heroBannerImg;
    }

    @FindAll(@FindBy(xpath = "(//span/li/div/img)[1]"))
    private static WebElement asset;

    public static WebElement asset(){
        return asset;
    }

}
