package team03.pages.amine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class VendorRegistrationPageAmine {
    public VendorRegistrationPageAmine(){
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
}
