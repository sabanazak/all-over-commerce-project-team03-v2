package team03.tests.aminetests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import team03.pages.amine.HomePageAmine;
import team03.pages.amine.VendorRegistrationPageAmine;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

import static team03.utilities.JSUtils.clickElementByJS;

public class US_9_Register_Vendor {
    HomePageAmine homePage=new HomePageAmine();
    VendorRegistrationPageAmine vendorRegistrationPage= new VendorRegistrationPageAmine();

    @Test
    public void test() throws InterruptedException {
        //1-Navigate to https://allovercommerce.com/

        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        Actions actions=new Actions(Driver.getDriver());

        //2-User Clicks "Register" button
        homePage.linkRegister.click();

        //3-User Clicks “Become a Vendor” link
        homePage.becomeVendorButton.click();

        //4-User types a e-mail
        vendorRegistrationPage.vendorEmail.sendKeys("team03.vendor1@gmail.com");

        //5-User Clicks “RE-SEND CODE” BUTTON
        // vendorRegistrationPage.reSendCodeButton.click();

        //6- Send verification code
        vendorRegistrationPage.verificationCode.sendKeys("1111");

        //7-Send password
        vendorRegistrationPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendor_password"));

        //8-Send confirm Password
        vendorRegistrationPage.confirmPassword.sendKeys(ConfigReader.getProperty("vendor_password"));

        ReusableMethods.waitFor(5);

        //9-Click "REGISTER" button

        //  vendorRegistrationPage.vendorRegisterButton.click();
        clickElementByJS(vendorRegistrationPage.vendorRegisterButton);

        ReusableMethods.waitFor(2);

        //18-"This Email already exists. Please login to the site and apply as vendor." text should be visible
        ReusableMethods.verifyElementDisplayed(vendorRegistrationPage.alresdyExistiText);



    }

}
