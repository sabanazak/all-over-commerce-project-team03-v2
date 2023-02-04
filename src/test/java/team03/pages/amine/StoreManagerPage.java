package team03.pages.amine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class StoreManagerPage {
    public StoreManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Coupons")
    public WebElement btnCoupons;
    @FindBy(id = "add_new_coupon_dashboard")
    public WebElement btnAddNew;

    @FindBy(id = "title")
    public WebElement codeInput;

    @FindBy(id = "description")
    public WebElement descriptionInput;

    @FindBy(id = "discount_type")
    public WebElement discount_typeInput;

    @FindBy(id = "coupon_amount")
    public WebElement coupon_amountInput;

    @FindBy(id = "expiry_date")
    public WebElement expiry_dateInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement free_shippingInput;

    @FindBy(id = "show_on_store")
    public WebElement show_on_storeInput;

    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement btnSubmit;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnAddtocart;

    @FindBy(xpath = "//a[@class='cart-toggle']")
    public WebElement btnCart;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement btnCheckout;

    @FindBy(xpath = "//a[@class='showcoupon']" )
    public WebElement enterYourCode;

    @FindBy(id = "coupon_code")
    public WebElement coupon_codeInput;

    @FindBy(name = "apply_coupon")
    public WebElement btnApply_coupon;

    @FindBy(xpath = "//tr[@class='cart-discount coupon-55555']")
    public WebElement createdCoupon;

    @FindBy(xpath = "//a[@class='wcfm_dashboard_item_title']")
    public WebElement couponVisible;

}
