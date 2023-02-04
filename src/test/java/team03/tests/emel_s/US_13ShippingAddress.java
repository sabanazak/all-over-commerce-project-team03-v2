package team03.tests.emel_s;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import team03.pages.HomePage;
import team03.pages.MyAccountPage;
import team03.pages.ShippingAddressPage;
import team03.pages.emelPages.ConfigReader_E;
import team03.pages.emelPages.HomePage_E;
import team03.pages.emelPages.ShippingAddressPage_E;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class US_13ShippingAddress extends JSUtils {
HomePage_E homePage_e=new HomePage_E();
ShippingAddressPage_E shippingAddressPage_e=new ShippingAddressPage_E();
    WebDriver driver;


    MyAccountPage myAccountPage= new MyAccountPage();
    // Actions actions = new Actions(driver);
    @Test
    public void shippingAddress(){

        //1-Navigate to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader_E.getProperty("all_over_commerce_url"));



        //sign-in as a vendor
        Driver.getDriver().get(ConfigReader_E.getProperty("all_over_commerce_url"));
        homePage_e.linkSignIn.click();
        homePage_e.inputSigninUsername.sendKeys(ConfigReader_E.getProperty("vendor_email2"));
        ReusableMethods.waitFor(2);
        homePage_e.inputSiginPassword.sendKeys(ConfigReader_E.getProperty("vendor_password2"));
        homePage_e.btnSignIn.click();

       ////go to my account page-go to sign-out

        homePage_e.btnSignOut.click();
        shippingAddressPage_e.linkAddresses.click();


        //3-Click "Address" button
      // shippingAddressPage.inputShippingAddress1.click();
        JSUtils.clickElementByJS(shippingAddressPage_e.addShippingAddress);


        //4.Click "ADD" button under shipping address
      clickElementByJS(shippingAddressPage_e.inputShippingFirstName);
      ReusableMethods.waitFor(2);

        //5.Send "firstname" , "lastname" ,"Country/Region,
        shippingAddressPage_e.inputShippingFirstName.sendKeys("Emel");
       shippingAddressPage_e.inputShippingLastName.sendKeys("Sahin");
        shippingAddressPage_e.inputShippingCompany.sendKeys("TechPro");
       // clickElementByJS(shippingAddressPage.selectShippingCountry);
        //clickElementByJS(shippingAddressPage.countrySelect1);
       //shippingAddressPage.countrySelect.sendKeys("Albania");
       //shippingAddressPage.countrySelect.sendKeys(Keys.ENTER);

        Driver.selectByVisibleText(shippingAddressPage_e.selectShippingCountry,"Canada");

     // ReusableMethods.waitFor(3);
       //clickElementByJS(shippingAddressPage.inputShippingAddress1);

     shippingAddressPage_e.inputShippingAddress1.sendKeys("1189 Drainer Avenue");

    //  ReusableMethods.waitFor(3);
     clickElementByJS( shippingAddressPage_e.inputShippingCity);
    shippingAddressPage_e.inputShippingCity.sendKeys("Panama City");


        //street address, "Town / City ", "State", "ZIP Code".
            Driver.selectByVisibleText(shippingAddressPage_e.selectShippingState,"Ontario");
      //  clickElementByJS(shippingAddressPage.shippingState);
      //  ReusableMethods.waitFor(3);


     shippingAddressPage_e.inputShippingZipCode.sendKeys("H1G 2Z5");
     shippingAddressPage_e.inputShippingZipCode.sendKeys(Keys.ENTER);
        //6.Click "SAVE ADDRESS" button

clickElementByJS(shippingAddressPage_e.btnShippingSaveAddress);

    }
}
