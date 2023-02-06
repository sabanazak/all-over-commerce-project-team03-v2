package team03.pages.RahimesPages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class HomePage_r {


    public HomePage_r(){
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
    //---------------- SIGN IN ----------------
    @FindBy(id = "username")
    public WebElement inputSigningUsername;

    @FindBy(id = "reg_password")
    public WebElement inputSignPassword;

    @FindBy(id = "rememberme")
    public WebElement chkRememberMe;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement btnSignIn;
    //-----------------------------------------
    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement btnSignOut;


    @FindBy(xpath = "//a[@title='Compare']")
    public WebElement compareBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/section[3]/div/div/div/div[2]/div/div/div[1]/div/ul/li[5]/div/figure/div/a[2]")
    public WebElement compareBtn1;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/section[3]/div/div/div/div[2]/div/div/div[1]/div/ul/li[4]/div/figure/div/a[2]")
    public WebElement compareBtn2;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div/div/div/div/div/div/ul/li[4]/div/figure/div[2]/a[2]")
    public WebElement compareBtn3;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/a[2]")
    public WebElement strtCompareBtn;

    @FindBy(xpath ="//i[@class='w-icon-times-solid']")
    public WebElement removeCompareBtn;

    @FindBy(xpath ="//i[@class='w-icon-times-solid']")
    public WebElement removeCompareBtn1;

    @FindBy(xpath ="//i[@class='w-icon-times-solid']")
    public WebElement removeCompareBtn2;

    @FindBy(xpath ="//i[@class='w-icon-times-solid']")
    public WebElement removeCompareBtn3;

    @FindBy(id = "username")
    public WebElement inputSigninUsername;

    @FindBy(id = "password")
    public WebElement inputSiginPassword;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(xpath = "//i[@class='w-icon-search']")
    public WebElement searchButton;


}

