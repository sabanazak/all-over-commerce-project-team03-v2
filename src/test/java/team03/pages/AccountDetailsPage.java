package team03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class AccountDetailsPage {

    public AccountDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account_first_name")
    public WebElement inputAccountFirstName;

    @FindBy(id = "account_last_name")
    public WebElement inputAccountLastName;

    @FindBy(id = "account_display_name")
    public WebElement inputDisplayName;

    @FindBy(id = "account_email")
    public WebElement inputAccountEmail;

    @FindBy(tagName="iframe")
    public WebElement iframeBiography;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    public WebElement inputBiography;

    @FindBy(id = "password_current")
    public WebElement inputAccountCurrentPassword;

    @FindBy(id = "password_1")
    public WebElement inputAccountPassword1;

    @FindBy(id = "password_2")
    public WebElement inputAccountPassword2;

    @FindBy(name = "save_account_details")
    public WebElement btnSaveChanges;

}
