package team03.pages.busraPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class LoginPage_BS {
    public LoginPage_BS(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //---------------- SIGN IN ----------------
    @FindBy(id = "customer_login")
    public WebElement login_and_register_Container;

    @FindBy(id = "username")
    public WebElement inputSigninUsername;

    @FindBy(id = "password")
    public WebElement inputSiginPassword;

    @FindBy(id = "rememberme")
    public WebElement chkRememberMe;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement btnSignIn;
}
