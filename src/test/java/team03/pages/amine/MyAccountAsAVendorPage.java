package team03.pages.amine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class MyAccountAsAVendorPage {
    public MyAccountAsAVendorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Store Manager")
    public WebElement btnStoreManager;
}
