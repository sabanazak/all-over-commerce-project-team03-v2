package team03.tests.busra;

import org.testng.Assert;
import org.testng.annotations.Test;
import team03.pages.busraPage.*;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class US_19 {


    /*
    User should be able to shop as a Vendor. (My Account > Orders > Browse Product)

    Users should be able to select Product / Products and add them to their cart.
    Products and items to be purchased should be visible during the Chart-Checkout process.
    User should be able to fill BILLING DETAILS.
    Total amount should be visible.
    Wire transfer/EFT veya Pay at the door options should be selectable.
    By clicking on Place Order, the user should be able to see that the shopping has been completed.
    User should be able to see the details of his/her purchase by clicking My Account -Orders.
     */

    HomePage_BS homePage_bs=new HomePage_BS();
    LoginPage_BS loginPage_bs=new LoginPage_BS();
    VendorLoginPage_BS vendorLoginPage_bs =new VendorLoginPage_BS();
    VendorShopPage_BS vendorShopPage_bs= new VendorShopPage_BS();
    BillingAddress_BS billingAddress_bs= new BillingAddress_BS();

    @Test
    public void shopVendor() {

        //Given user goes to "https://allovercommerce.com" page
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        homePage_bs.linkSignIn.click();
        loginPage_bs.login_and_register_Container.click();
        loginPage_bs.inputSigninUsername.sendKeys("team03.vendor1");
        loginPage_bs.inputSiginPassword.sendKeys("TechProEd");
        loginPage_bs.btnSignIn.click();
        ReusableMethods.waitFor(3);

       vendorShopPage_bs.search.sendKeys("Tshirt");
        ReusableMethods.waitFor(3);

        //And user clicks on search button
        JSUtils.clickElementByJS(vendorShopPage_bs.searchButton);
        ReusableMethods.waitFor(3);

        //The user should be able to add the product they are looking for to their cart. (ADD TO CART)
        vendorShopPage_bs.addToCart.click();

        //verify added to cart
        String addedToCart= vendorShopPage_bs.addedToCart.getText();
        Assert.assertTrue(addedToCart.contains("“Tshirt” has been added to your cart."));

        //3-User should see the items that have been added to the cart.
        //And user clicks on cart
        JSUtils.clickElementByJS(vendorShopPage_bs.cart);

        //clicks view cart.
        JSUtils.clickElementByJS(vendorShopPage_bs.viewCart);
        ReusableMethods.waitFor(3);

        // clicks checkout
        JSUtils.clickElementByJS(vendorShopPage_bs.checkout);

        // verify  Billing Address is visible
        Assert.assertTrue(vendorShopPage_bs.billingAddress.isDisplayed());

        //Billing adress
        billingAddress_bs.inputBillingFirstName.clear();
        billingAddress_bs.inputBillingFirstName.sendKeys("Busra");


        billingAddress_bs.inputBillingLastName.clear();
        billingAddress_bs.inputBillingLastName.sendKeys("Sentuna");

        billingAddress_bs.inputBillingCompany.clear();
        billingAddress_bs.inputBillingCompany.sendKeys("Dolek");

        Driver.selectAnItemFromDropdown(billingAddress_bs.selectBillingCountry,"United States(US)");

        billingAddress_bs.inputBillingAddress1.clear();
        billingAddress_bs.inputBillingAddress1.sendKeys("9");

        billingAddress_bs.inputBillingAddress2.clear();
        billingAddress_bs.inputBillingAddress2.sendKeys("Venture");

        billingAddress_bs.inputBillingCity.clear();
        billingAddress_bs.inputBillingCity.sendKeys("Miami");

        Driver.selectAnItemFromDropdown(billingAddress_bs.selectBillingState, "Florida");

        billingAddress_bs.inputBillingZipCode.clear();
        billingAddress_bs.inputBillingZipCode.sendKeys("90210");

        billingAddress_bs.inputBillingPhone.clear();
        billingAddress_bs.inputBillingPhone.sendKeys("4167889310");

        billingAddress_bs.inputBillingEmail.clear();
        billingAddress_bs.inputBillingEmail.sendKeys("bdolek17@gmail.com");

        //Total Amount
        Assert.assertEquals("$50.00","$50.00");

        //Select payment method
        JSUtils.clickElementByJS(vendorShopPage_bs.paymentMethod);
        JSUtils.clickElementByJS(vendorShopPage_bs.placeOrder);

        //order completed
       String text=vendorShopPage_bs.shopCompleted.getText();
        System.out.println(text);

        //Going my account
        JSUtils.clickElementByJS(vendorShopPage_bs.myAccount);

        //Going to orders page
        JSUtils.clickElementByJS(vendorShopPage_bs.orders);


        //Order summary
        String orderSummary = vendorShopPage_bs.orderSummary.getText();
        System.out.println(orderSummary);
        

    }
}
