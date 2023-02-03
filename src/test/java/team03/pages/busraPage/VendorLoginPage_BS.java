package team03.pages.busraPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class VendorLoginPage_BS {
    public VendorLoginPage_BS(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_email")
    public WebElement inputVendorRegisterEmail;

    @FindBy(name = "wcfm_email_verified_input")
    public WebElement inputVendorRegisterVerificationCode;

    @FindBy(name = "wcfm_email_verified_button")
    public WebElement btnVendorRegisterResendCode;

    @FindBy(id = "password")
    public WebElement inputVendorRegisterPassword;

}
