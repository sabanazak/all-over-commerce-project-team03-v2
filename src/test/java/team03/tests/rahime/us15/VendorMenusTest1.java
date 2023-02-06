package team03.tests.rahime.us15;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import team03.pages.RahimesPages.InventoryPage_r;
import team03.pages.RahimesPages.*;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

import java.awt.*;

import static org.testng.AssertJUnit.assertTrue;

public class VendorMenusTest1 {


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

    public void VendorMenusTest() throws AWTException {

        //1)  Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings, Advanced menus should be visible.

        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));


        HomePage_r homePage = new HomePage_r();
        MyAccountPage_r myAccountPage = new MyAccountPage_r();
        InventoryPage_r inventoryPage = new InventoryPage_r();
        AttributesPage_r attributesPage = new AttributesPage_r();
        ShippingPage_r shippingPage = new ShippingPage_r();
        LinkedPage_r linkedPage = new LinkedPage_r();
        WholesaleProductPage_r wholesaleProductPage = new WholesaleProductPage_r();
        AdvancedPage_r advancedPage = new AdvancedPage_r();
        SeoPage_r seoPage = new SeoPage_r();
        ProductPage_r productPage = new ProductPage_r();



        //  click on "my Account"
        //1-Navigate to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        //sign-in as a vendor
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        homePage.linkSignIn.click();
        homePage.inputSigninUsername.sendKeys(ConfigReader.getProperty("vendor_email"));
        ReusableMethods.waitFor(2);
        homePage.inputSiginPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        homePage.btnSignIn.click();

        //go to my account page-go to sign-out

        homePage.btnSignOut.click();


        //    click store manager
        JSUtils.clickElementByJS(myAccountPage.storeManager);

        //    clicks products
        ReusableMethods.waitFor(2);
        try {
            JSUtils.clickElementByJS(myAccountPage.product);
        } catch (Exception e) {
        }

        //      click add new
        myAccountPage.addNewProduct.click();
        JSUtils.scrollDownByJS();

        // test to Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings, Advanced menus visibility

        assertTrue(productPage.inventoryHead.isDisplayed());
        ReusableMethods.waitFor(2);
        assertTrue(productPage.shippingHead.isDisplayed());
        ReusableMethods.waitFor(2);
        assertTrue(productPage.attributeHead.isDisplayed());
        ReusableMethods.waitFor(2);
        assertTrue(productPage.linkedHead.isDisplayed());
        ReusableMethods.waitFor(2);
        assertTrue(productPage.seoHead.isDisplayed());
        ReusableMethods.waitFor(2);
        assertTrue(productPage.wholesaleHead.isDisplayed());
        ReusableMethods.waitFor(2);
        assertTrue(productPage.advanceHead.isDisplayed());
        ReusableMethods.waitFor(2);


        //    test to visibility of SKU
        assertTrue(productPage.sku.isDisplayed());
        productPage.sku.sendKeys("key123");

        //    click to Manage stock
        JSUtils.scrollIntoViewJS(productPage.manageStock);
        JSUtils.clickElementByJS(productPage.manageStock);

        //    test to click Manage Stock
        assertTrue(productPage.manageStock.isSelected());

        //    select out of stock in stock status
        JSUtils.clickElementByJS(productPage.stockStatus);

        Select select = new Select(productPage.stockStatus);
        select.selectByIndex(2);

        //    click to Sold Individually
        JSUtils.clickElementByJS(productPage.soldIndividually);

        //    test to click Sold Individually
        assertTrue(productPage.soldIndividually.isSelected());
    }


}
