package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class CheckoutPage {
    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "billing_first_name")
    public WebElement inputBillingFirstName;
    @FindBy(id = "billing_last_name")
    public WebElement inputBillingLastName;
    @FindBy(id = "billing_company")
    public WebElement inputBillingCompany;
    @FindBy(id = "billing_country")
    public WebElement selectBillingCountry;
    @FindBy(id = "billing_address_1")
    public WebElement inputBillingAddress1;
    @FindBy(id = "billing_address_2")
    public WebElement inputBillingAddress2;
    @FindBy(id = "billing_city")
    public WebElement inputBillingCity;
    @FindBy(id = "billing_state")
    public WebElement selectBillingState;
    @FindBy(id = "billing_postcode")
    public WebElement inputBillingPostcode;
    @FindBy(id = "billing_phone")
    public WebElement inputBillingPhone;
    @FindBy(id = "billing_email")
    public WebElement inputBillingEmail;
    @FindBy(id = "order_comments")
    public WebElement inputOrderComments;

    @FindBy(id = "ship-to-different-address-checkbox")
    public WebElement chkShipToDifferentAddress;

    @FindBy(id = "shipping_first_name")
    public WebElement inputShippingFirstName;
    @FindBy(id = "shipping_last_name")
    public WebElement inputShippingLastName;
    @FindBy(id = "shipping_company")
    public WebElement inputShippingCompany;
    @FindBy(id = "shipping_country")
    public WebElement selectShippingCountry;
    @FindBy(id = "shipping_address_1")
    public WebElement inputShippingAddress1;
    @FindBy(id = "shipping_address_2")
    public WebElement inputShippingAddress2;
    @FindBy(id = "shipping_city")
    public WebElement inputShippingCity;
    @FindBy(id = "shipping_state")
    public WebElement selectShippingState;
    @FindBy(id = "shipping_postcode")
    public WebElement inputShippingPostcode;

    @FindBy(id = "payment_method_bacs")
    public WebElement radioWireTransfer;

    @FindBy(id = "payment_method_cod")
    public WebElement radioPayAtDoor;

    @FindBy(id = "place_order")
    public WebElement btnPlaceOrder;

}
