package team03.pages.amine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class HomePageAmine {
    public HomePageAmine(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement linkRegister;

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement linkSignIn;
    //---------------- REGISTER ----------------
    @FindBy(id = "reg_username")
    public WebElement inputRegisterUsername;

    @FindBy(id = "reg_email")
    public WebElement inputRegisterEmail;

    @FindBy(id = "reg_password")
    public WebElement inputRegisterPassword;

    @FindBy(id = "register-policy")
    public WebElement chkRegisterPolicy;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement btnRegisterSignUp;

    @FindBy(linkText = "Become a Vendor")
    public WebElement becomeVendorButton;

    //---------------- SIGN IN ----------------
    @FindBy(id = "username")
    public WebElement inputSigninUsername;

    @FindBy(id = "password")
    public WebElement inputSiginPassword;

    @FindBy(id = "rememberme")
    public WebElement chkRememberMe;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement btnSignIn;
    //-----------------------------------------
    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement btnSignOut;

}


