package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement linkRegister;

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement linkSignIn;

    //-----------------------------------------
    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement linkSignOut;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/wishlist/'])[1]")
    public WebElement linkWishlist;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/cart/'])[1]")
    public WebElement linkCart;

}
