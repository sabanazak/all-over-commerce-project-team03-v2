package team03.pages.busraPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class ShopPage_BS {

    public ShopPage_BS(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@type='search'])[1]")
    public WebElement search;

    @FindBy(xpath = "(//i[@class='w-icon-search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//h1[@class='product_title entry-title']")
    public WebElement productTitle;

    @FindBy(linkText = "Kızılcık Tarhanası")
    public WebElement getProduct;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addedToCart;

    @FindBy(xpath = "//i[@class='w-icon-cart']")
    public WebElement cart;

    @FindBy(xpath = "//span[@class='cart-count']")
    public WebElement cartCount;

    @FindBy(xpath = "//a[.='View cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement increaseButton;

    @FindBy(xpath = "//a[.='Checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//h3[.='Billing details']")
    public WebElement billingAddress;
    @FindBy(xpath = "//h4[.='Payment Methods']")
    public WebElement paymentMethod;

    @FindBy(id = "payment_method_bacs")
    public WebElement wireTransfer;

    @FindBy(id = "payment_method_cod")
    public WebElement payAtTheDoor;

    @FindBy(id = "place_order")
    public WebElement placeOrder;

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement orderComplete;




}
