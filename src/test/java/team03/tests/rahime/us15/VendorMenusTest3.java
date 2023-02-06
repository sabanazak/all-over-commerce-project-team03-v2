package team03.tests.rahime.us15;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import team03.pages.RahimesPages.*;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class VendorMenusTest3 {


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

    public void VendorMenusTest3() {

        //3)Vendor should be able to do Shipping processes (Weight, Dimensions, Shipping class, Processing Time)

        HomePage_r homePage = new HomePage_r();
        MyAccountPage_r myAccountPage = new MyAccountPage_r();
        InventoryPage_r inventoryPage = new InventoryPage_r();
        ShippingPage_r shippingPage =new ShippingPage_r();
        ProductPage_r productPage = new ProductPage_r();

        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        homePage.linkSignIn.click();
        homePage.inputSigninUsername.sendKeys(ConfigReader.getProperty("vendor_email"));
        ReusableMethods.waitFor(2);
        homePage.inputSiginPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        homePage.btnSignIn.click();

        //go to my account page-go to sign-out

        homePage.btnSignOut.click();


        //  click on "Store Manager"
        JSUtils.clickElementByJS(myAccountPage.storeManager);
        ReusableMethods.waitFor(2);

        //  click on "Product"
        JSUtils.clickElementByJS(myAccountPage.product);

        //  click on "Add New"
        JSUtils.clickElementByJS(myAccountPage.addNewProduct);


        //  Click on "shipping" on menu
        JSUtils.clickElementByJS(shippingPage.shipping);
        ReusableMethods.waitFor(3);

        //	fill weight(kg) in "Weight" field
        shippingPage.shippingWeight.sendKeys("5");
        ReusableMethods.waitFor(3);

        //	fill dimensions in "length", "width"and "height" field
        shippingPage.shippingLength.sendKeys("50");
        shippingPage.shippingWidth.sendKeys("75");
        shippingPage.shippingHeight.sendKeys("100");

        //	select class from "shipping class"
        JSUtils.setValueByJS(shippingPage.shippingClass,"No shipping class");
        ReusableMethods.waitFor(3);

        //	Vendor selects processing time from "processing time"
        new Select(shippingPage.processingTime).selectByVisibleText("1 business day");
        ReusableMethods.waitFor(3);

        //click submit button
        // JSUtils.clickElementByJS(productPage.submit);

    }
}
