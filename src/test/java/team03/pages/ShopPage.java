package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

import java.util.List;

public class ShopPage {
    public ShopPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/wishlist/'])[1]")
    public WebElement linkWishlist;

    @FindBy(xpath = "//a[contains(@href,'?add_to_wishlist')]")
    public List<WebElement> listOfAddToWishListIcons;


}
