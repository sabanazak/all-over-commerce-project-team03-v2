package team03.pages.sabanpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class OrderComplatePage {

    public OrderComplatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='Thank you. Your order has been received.']")
    public WebElement orderComplateMessage;

}
