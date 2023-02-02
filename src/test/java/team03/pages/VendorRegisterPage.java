package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class VendorRegisterPage {
    public VendorRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //---------------- VENDOR REGISTER ----------------
    @FindBy(id = "user_email")
    public WebElement inputVendorRegisterEmail;

    @FindBy(name = "wcfm_email_verified_input")
    public WebElement inputVendorRegisterVerificationCode;

    @FindBy(name = "wcfm_email_verified_button")
    public WebElement btnVendorRegisterResendCode;

    @FindBy(id = "password")
    public WebElement inputVendorRegisterPassword;

    @FindBy(id = "confirm-pwd")
    public WebElement inputVendorRegisterConfirmPassword;

    @FindBy(id = "password_strength-pwd")
    public WebElement msgVendorRegisterPasswordStrength;


    @FindBy(xpath = "//div[.='Password and Confirm-password are not same.']")
    public WebElement msgVendorRegisterConfirmPassword;

    @FindBy(xpath = "//button[@id='wcfm_membership_register_button']")
    public WebElement btnVendorRegisterRegister;
}
