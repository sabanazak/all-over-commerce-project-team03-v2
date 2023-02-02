package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class ShippingAddressPage {

    public ShippingAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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
    public WebElement inputShippingZipCode;

    @FindBy(xpath = "//button[.='Save address']")
    public WebElement btnShippingSaveAddress;

}
