package team03.tests.rahime.us15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team03.pages.RahimesPages.AttributesPage_r;
import team03.pages.RahimesPages.HomePage_r;
import team03.pages.RahimesPages.MyAccountPage_r;
import team03.pages.RahimesPages.ProductPage_r;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class VendorMenusTest4 {


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

    public void VendorMenusTest4() {

        HomePage_r homePage = new HomePage_r();
        MyAccountPage_r myAccountPage = new MyAccountPage_r();
        AttributesPage_r attributesPage =new AttributesPage_r();
        ProductPage_r productPage = new ProductPage_r();

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

        //4)Vendor should be able to do Attributes processes. (Color, Size)
        //  Click on "attributes"

        JSUtils.clickElementByJS(productPage.attributeHead);

//    click to open color menu
        JSUtils.clickElementByJS(productPage.colorsCheckbox);

//    select color
        productPage.colorInput.sendKeys("green" + Keys.ENTER);

        JSUtils.clickElementByJS(productPage.selectAllColor);
        JSUtils.clickElementByJS(productPage.selectNoneColor);
        JSUtils.clickElementByJS(productPage.addNewColor);
        ReusableMethods.waitFor(2);

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.sendKeys("Bart");
            alert.accept();
        } catch (Exception e) {
        }

//    click to Visible on the product page
        JSUtils.clickElementByJS(productPage.visibleOnPageColor);

//    test to Visible on the product page is unclicked
        assertFalse(productPage.visibleOnPageColor.isSelected());

//  -----------  click to open size menu    -----------
        JSUtils.clickElementByJS(productPage.sizeCheckbox);

//    select XXL
        productPage.sizeInput.sendKeys("XXL" + Keys.ENTER);
        JSUtils.clickElementByJS(productPage.selectAllSize);
        JSUtils.clickElementByJS(productPage.selectNoneSize);
        JSUtils.clickElementByJS(productPage.addNewSize);

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.sendKeys("Bart");
            alert.accept();
        } catch (Exception e) {
        }

//    click to Visible on the product page
        JSUtils.clickElementByJS(productPage.visibleOnPageSize);

//    test to Visible on the product page is clicked
        assertFalse(productPage.visibleOnPageSize.isSelected());

//      click to add attribute button
        JSUtils.clickElementByJS(productPage.addAttributeButton);

//      test to new attribute name visibility
        assertTrue(productPage.newAttributeName.isDisplayed());

    }
}
