package team03.pages.sabanpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class SideShoppingCardPage {
    public SideShoppingCardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//ul[contains(@class,'mini-list')]")
    public WebElement productListSide;
    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']/a")
    public WebElement btnViewCartSide;

    @FindBy(xpath = "//a[contains(@class,'checkout')]")
    public WebElement btnCheckoutSide;
}
