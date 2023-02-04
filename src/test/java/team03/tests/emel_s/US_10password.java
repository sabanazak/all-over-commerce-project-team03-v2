package team03.tests.emel_s;

import org.testng.annotations.Test;
import team03.pages.emelPages.HomePage_E;
import team03.pages.emelPages.VendorRegistrationPage_E;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

public class US_10password {

HomePage_E homePage_e=new HomePage_E();
VendorRegistrationPage_E vendorRegistrationPage_e=new VendorRegistrationPage_E();

    @Test
    public void password(){
        //1-Navigate to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));



        //2- Click "Register" button
        homePage_e.linkRegister.click();

        //3-Click “Become a Vendor” link
        homePage_e.becomeVendorButton.click();

        //4-Send valid e-mail
        vendorRegistrationPage_e.vendorEmail.sendKeys(ConfigReader.getProperty("vendor_email"));


        //5-Click “RE-SEND CODE” BUTTON

        //6- Send valid verification code
        vendorRegistrationPage_e.verificationCode.sendKeys("1111");
        //7-Send "short" password
        vendorRegistrationPage_e.vendorPassword.sendKeys("1");
        ReusableMethods.verifyElementDisplayed(vendorRegistrationPage_e.shortpassword);


        ReusableMethods.waitFor(3);
        //8-Send "weak" password
        vendorRegistrationPage_e.vendorPassword.sendKeys("123456");
        ReusableMethods.verifyElementDisplayed(vendorRegistrationPage_e.weakpassword);

        ReusableMethods.waitFor(3);

        //9-Send "good" password
        vendorRegistrationPage_e.vendorPassword.sendKeys("1234567A");
        ReusableMethods.verifyElementDisplayed(vendorRegistrationPage_e.goodpassword);
        ReusableMethods.waitFor(3);
        //10-Send "strong" password
        vendorRegistrationPage_e.vendorPassword.sendKeys("1234567Ab");
        ReusableMethods.verifyElementDisplayed(vendorRegistrationPage_e.strongpassword);
        ReusableMethods.waitFor(3);
        //11-Send confirm Password
vendorRegistrationPage_e.confirmPassword.sendKeys("1234567Ab");
    }
}
