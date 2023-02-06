package team03.tests.rahime.us15;

import org.testng.annotations.Test;
import team03.pages.RahimesPages.HomePage_r;
import team03.pages.RahimesPages.MyAccountPage_r;
import team03.pages.RahimesPages.SeoPage_r;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class VendorMenusTest6 {


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

    public void VendorMenusTest6() {

        //6)Vendor should be able to do Seo processes. (Enter a focus keyword, Meta description)

        HomePage_r homePage = new HomePage_r();
        MyAccountPage_r myAccountPage = new MyAccountPage_r();
        SeoPage_r seoPage = new SeoPage_r();

        //  click on "my Account"
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        homePage.linkSignIn.click();
        homePage.inputSigninUsername.sendKeys(ConfigReader.getProperty("vendor_email"));
        ReusableMethods.waitFor(2);
        homePage.inputSiginPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        homePage.btnSignIn.click();

        //  click on "sign in button"
        homePage.btnSignOut.click();

        //  click on "Store Manager"
        JSUtils.clickElementByJS(myAccountPage.storeManager);
        ReusableMethods.waitFor(2);

        //  click on "Product"
        JSUtils.clickElementByJS(myAccountPage.product);

        //  click on "Add New"
        JSUtils.clickElementByJS(myAccountPage.addNewProduct);


        //  Click on "seo"
        JSUtils.clickElementByJS(seoPage.seo);

        //	Vendor enters "Enter Focus Keyword" on seo processes.
        seoPage.enterFocusKeyWord.sendKeys("children");
        ReusableMethods.waitFor(2);

        //Vendor enters "meta Description" on seo processes.
        seoPage.metaDescription.sendKeys("perfect");
        ReusableMethods.waitFor(2);



    }}
