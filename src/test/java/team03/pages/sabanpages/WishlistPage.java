package team03.pages.sabanpages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

import java.util.List;

public class WishlistPage {
    public WishlistPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//table/tbody[contains(@class,'wishlist-empty')]/tr") //-- empty
    public List<WebElement> emptyTableRows;

    @FindBy(xpath = "//table/tbody[@class='wishlist-items-wrapper']/tr") //-- has items
    public List<WebElement> addedItemsTableRows;

    //div[contains(@class,'wishlist-title')]/h2
    @FindBy(xpath = "//div[contains(@class,'wishlist-title')]/h2") //added Items Table Label  (<h2>Wishlist</h2>)
    public WebElement lblAddedItemsTableLabel;

    @FindBy(linkText = "GO SHOP")
    public WebElement btnGoShop;

    @FindBy(xpath = "//td[.='No products added to the wishlist']")
    public WebElement msgNoProduct;

    @FindBy(xpath = "//button[.='Quick View']")
    public List<WebElement> quickViewButtons;

    @FindBy(xpath = "//a[.='Add to cart']")
    public List<WebElement> addToCartButtons;

    //Dummy
    @FindBy(xpath = "(//td[@class=\"product-add-to-cart\"]/div/a)[1]")
    public WebElement addToCardButton1;
    @FindBy(xpath = "(//td[@class=\"product-add-to-cart\"]/div/a)[2]")
    public WebElement addToCardButton2;
    @FindBy(xpath = "//a[contains(@class,'remove_from_wishlist ')]")
    public List<WebElement> removeFromWishlistButtons;

    @FindBy(xpath = "//a[.='View cart']")
    public WebElement linkViewCart;

    @FindBy(xpath = "//a[.='Checkout']")
    public WebElement linkCheckuot;



    @FindBy(xpath = "//div[@class='mfp-figure']")
    public WebElement productAttributesContainer;

    @FindBy(xpath = "//span[@class='posted_in']")   //for verify
    public WebElement categoryName;

    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement productAttributesContainerCloseButton;

}
