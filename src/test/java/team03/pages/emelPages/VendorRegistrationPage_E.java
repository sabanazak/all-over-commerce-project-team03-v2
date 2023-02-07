package team03.pages.emelPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class VendorRegistrationPage_E {
    public VendorRegistrationPage_E(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user_email")
    public WebElement vendorEmail;

    @FindBy(name = "wcfm_email_verified_button")
    public WebElement reSendCodeButton;

    @FindBy(name = "wcfm_email_verified_input")
    public WebElement verificationCode;

    @FindBy(id = "passoword")
    public WebElement vendorPassword;

    @FindBy(id = "confirm_pwd")
    public WebElement confirmPassword;

    @FindBy(id = "wcfm_membership_register_button")
    public WebElement vendorRegisterButton;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement alresdyExistiText;

    @FindBy(xpath = "//div[@class='short']")
    public WebElement shortpassword;

    @FindBy(xpath = "//div[@class='weak']")
    public WebElement weakpassword;

    @FindBy(xpath = "//div[@class='good']")
    public WebElement goodpassword;
    @FindBy(xpath = "//div[@class='strong']")
    public WebElement strongpassword;



}