package team03.pages.RahimesPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class WholesaleProductPage_r {

    public WholesaleProductPage_r(){

        PageFactory.initElements(Driver.getDriver(),this); }

    //WholesaleProduct

    @FindBy(xpath="(//div[@class='page_collapsible_content_holder'])[9]")
    public WebElement wholesaleProduct;

    @FindBy(id="piecetype")
    public WebElement priceType;

    @FindBy(id="unitpercart")
    public WebElement unitsPerPiece;

    @FindBy(id="minorderqtytr")
    public WebElement minOrderQuantity;

}

