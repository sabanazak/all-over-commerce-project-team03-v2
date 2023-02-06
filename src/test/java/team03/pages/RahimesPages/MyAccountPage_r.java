package team03.pages.RahimesPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

import java.util.List;

public class MyAccountPage_r {

    public MyAccountPage_r(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement linkAddresses;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/billing/']")
    public WebElement linkAddBillingAddresses;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement linkAddShippingAddresses;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-account/']")
    public WebElement linkAccountDetails;



    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement product;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNewProduct;

    @FindBy(xpath = "//div[@class='page_collapsible_content_holder']")
    public List<WebElement> inventoryList;

    @FindBy(xpath="//input[@name='submit-data']")
    public WebElement submitButton;

    @FindBy(xpath="(//input[@type='submit'])[2]")
    public WebElement draftButton;


    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//button[@name='login']")
    public WebElement signIn;

    @FindBy(xpath="//button[@name='login']")
    public WebElement signOut;


}

