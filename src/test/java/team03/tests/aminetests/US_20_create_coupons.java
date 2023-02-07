package team03.tests.aminetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import team03.pages.amine.HomePageAmine;
import team03.pages.amine.MyAccountAsAVendorPage;
import team03.pages.amine.MyAccountPageAmine;
import team03.pages.amine.StoreManagerPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

import static team03.utilities.JSUtils.clickElementByJS;

public class US_20_create_coupons {
    WebDriver driver;
    HomePageAmine homePage =new HomePageAmine();
    MyAccountAsAVendorPage myAccountAsAVendorPage=new MyAccountAsAVendorPage();
    StoreManagerPage storeManagerPage=new StoreManagerPage();
    MyAccountPageAmine myAccountPage= new MyAccountPageAmine();

    @Test
    public void test(){
        //sign-in as a vendor
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        homePage.linkSignIn.click();
        ReusableMethods.waitFor(2);
        homePage.inputSigninUsername.sendKeys("TechProEd");
        ReusableMethods.waitFor(2);
        homePage.inputSiginPassword.sendKeys("TechProEd");
        homePage.btnSignIn.click();

        ReusableMethods.waitFor(2);

        //go to my account page
        homePage.btnSignOut.click();
       // clickElementByJS( homePage.btnSignOut);

        //go to store manager page
        myAccountPage.btnStoreManager.click();

        ReusableMethods.waitFor(3);
        //got to coupons page
        clickElementByJS(storeManagerPage.btnCoupons);

        clickElementByJS(storeManagerPage.btnAddNew);

        //user types input boxes
        storeManagerPage.codeInput.sendKeys("");
        storeManagerPage.descriptionInput.sendKeys("new coupon 2");

        Select select=new Select(storeManagerPage.discount_typeInput);
        select.selectByIndex(0);

        storeManagerPage.coupon_amountInput.clear();
        storeManagerPage.coupon_amountInput.sendKeys("30");

        storeManagerPage.expiry_dateInput.sendKeys("2024-01-01");

        ReusableMethods.waitFor(2);
        clickElementByJS(storeManagerPage.free_shippingInput);

        ReusableMethods.waitFor(2);
        clickElementByJS(storeManagerPage.show_on_storeInput);

        clickElementByJS(storeManagerPage.btnSubmit);
        //----------------------------------------------------------------------------coupon created

        //go to coupons page
        ReusableMethods.waitFor(2);
        clickElementByJS( storeManagerPage.btnCoupons);

        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(storeManagerPage.couponVisible);
       //--------------------------------------------------------------------------------negative

    }
}
