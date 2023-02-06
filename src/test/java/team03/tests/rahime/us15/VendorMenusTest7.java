package team03.tests.rahime.us15;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import team03.pages.RahimesPages.HomePage_r;
import team03.pages.RahimesPages.MyAccountPage_r;
import team03.pages.RahimesPages.WholesaleProductPage_r;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class VendorMenusTest7 {


     /*
    1)Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings, Advanced menus should be visible.
    2)Vendor should be able to do Inventory processes.  (SKU, Manage Stock, Stock status, Sold Individually)
    3)Vendor should be able to do Shipping processes (Weight, Dimensions, Shipping class, Processing Time)
    4)Vendor should be able to do Attributes processes. (Color, Size)
    5)Vendor should be able to do Linked processes. (Up-sells, Cross-sells)
    6)Vendor should be able to do Seo processes. (Enter a focus keyword, Meta description)
    7)Vendor should be able to do Wholesale Product display settings . (Piece Type, Units Per Piece, Min Order Quantity)
    8)Vendor should be able to do  Advanced processes. (Menu Order, Purchase Note)
     */

    @Test

    public void Vendor2_7() {

        HomePage_r homePage = new HomePage_r();
        MyAccountPage_r myAccountPage =new MyAccountPage_r();
        WholesaleProductPage_r wholesaleProductPage =new WholesaleProductPage_r();

        //1-Navigate to https://allovercommerce.com/
        //sign-in as a vendor
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        homePage.linkSignIn.click();
        homePage.inputSigninUsername.sendKeys(ConfigReader.getProperty("vendor_email"));
        ReusableMethods.waitFor(2);
        homePage.inputSiginPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        homePage.btnSignIn.click();

        //go to my account page-go to sign-out

        homePage.btnSignOut.click();


        //  click on "sign in button"


        //  click on "Store Manager"
        JSUtils.clickElementByJS(myAccountPage.storeManager);
        ReusableMethods.waitFor(2);




        //  click on "Product"
        JSUtils.clickElementByJS(myAccountPage.product);

        //  click on "Add New"
        JSUtils.clickElementByJS(myAccountPage.addNewProduct);

        //7)Vendor should be able to do Wholesale Product display settings . (Piece Type, Units Per Piece, Min Order Quantity)

        //  Click on "wholesaleProduct"
        JSUtils.clickElementByJS(wholesaleProductPage.wholesaleProduct);

        //	select "Price Type" on Dropdown menu
        new Select(wholesaleProductPage.priceType).selectByVisibleText("kg");

        //	enter "Units Per Piece"
        wholesaleProductPage.unitsPerPiece.sendKeys("5");

        //	enter "Min Order Quantity"
        wholesaleProductPage.minOrderQuantity.sendKeys("5");

        //close driver
        Driver.closeDriver();
    }
}
