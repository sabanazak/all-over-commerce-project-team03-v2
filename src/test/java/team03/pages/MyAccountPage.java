package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class MyAccountPage {

    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement btnSignOut;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElement linkLogOut;

    //-----MENU-----
    @FindBy(xpath = "//a[.='Dashboard']")
    public WebElement menuDashboard;

    @FindBy(xpath = "//a[.='Downloads']")
    public WebElement menuDownloads;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement menuAddresses;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement menuAccountDetails;

    @FindBy(xpath = "//a[.='Wishlist']")
    public WebElement menuWishlist;

    @FindBy(xpath = "//a[.='Chat Box']")
    public WebElement menuChatBox;

    @FindBy(xpath = "//a[.='Support Tickets']")
    public WebElement menuSupportTickets;

    @FindBy(xpath = "//a[.='Followings']")
    public WebElement menuFollowings;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement menuLogout;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/billing/']")
    public WebElement linkAddBillingAddresses;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement linkAddShippingAddresses;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-account/']")
    public WebElement linkAccountDetails;


}
