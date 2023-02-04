package team03.pages.busraPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class VendorShopPage_BS {
    public VendorShopPage_BS(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@type='search'])[1]")
    public WebElement search;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addToCart;

    @FindBy(xpath = "(//i[@class='w-icon-search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addedToCart;

    @FindBy(xpath = "//i[@class='w-icon-cart']")
    public WebElement cart;

    @FindBy(xpath = "//a[.='View cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//a[.='Checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//h3[.='Billing details']")
    public WebElement billingAddress;

    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[5]")
    public WebElement totalAmount;

    @FindBy(id="payment_method_cod")
    public  WebElement paymentMethod;

    @FindBy(id="place_order")
    public  WebElement placeOrder;

    @FindBy(xpath="//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public  WebElement shopCompleted;

    @FindBy(xpath = "//a[@href='/my-account-2/orders/']")
    public WebElement myAccount;

    @FindBy(linkText = "Orders")
    public WebElement orders;

    @FindBy(linkText = "#19987")
    public WebElement orderSummary;



}
