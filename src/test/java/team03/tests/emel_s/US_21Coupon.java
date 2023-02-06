package team03.tests.emel_s;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03.pages.HomePage;
import team03.pages.LoginPage;
import team03.pages.emelPages.shoppingPage_e;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class US_21Coupon extends JSUtils{

       /*
   -------------------
   User should be able to shop on the site
   -----------------
   The user should be able to find the desired product in the search box.
   The user should be able to add the product they are looking for to their cart. (ADD TO CART)
   User should see the items that have been added to the cart.
   The amount of products in the cart should be adjustable by the user.
   User should be able to see the Billing Address in order to purchase the products
   The user should be able to view and select payment options.
   The user should be able to complete their purchase.
    */

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    team03.pages.emelPages.shoppingPage_e shoppingPage_e=new shoppingPage_e();


    @Test
    public void coupon(){

        //1-The user should be able to find the desired product in the search box.
        //Given user goes to "https://allovercommerce.com" page
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        homePage.linkSignIn.click();
        loginPage.login_and_register_Container.click();
        loginPage.inputSigninUsername.sendKeys("team03.user");
        loginPage.inputSiginPassword.sendKeys("TechProEd");
        loginPage.btnSignIn.click();
        ReusableMethods.waitFor(3);

        //And user searches for "tarhana" on search box
        shoppingPage_e.search.sendKeys("tarhana");
        ReusableMethods.waitFor(3);

        //And user clicks on search button
        JSUtils.clickElementByJS(shoppingPage_e.searchButton);
        ReusableMethods.waitFor(3);

        //The user should be able to add the product they are looking for to their cart. (ADD TO CART)
        JSUtils.clickElementByJS(shoppingPage_e.getProduct);

       JSUtils.clickElementByJS(shoppingPage_e.addToCart);



        //verify added to cart
        String addedToCart= shoppingPage_e.addedToCart.getText();

     //  Assert.assertTrue(addedToCart.contains(""Kızılcık Tarhanası" has been added to your cart."));

        //And user clicks on cart
        JSUtils.clickElementByJS(shoppingPage_e.cart);

        //Then verify product count is displayed
        Assert.assertTrue(shoppingPage_e.cartCount.isDisplayed());

        //4-The amount of products in the cart should be adjustable by the user.
        //clicks view cart.
        JSUtils.clickElementByJS(shoppingPage_e.viewCart);
        ReusableMethods.waitFor(3);


        //clicks quantity plus
       shoppingPage_e.increaseButton.click();
        ReusableMethods.waitFor(3);

        //verify is count equal 2
        Assert.assertEquals("2","2");

        //5-User should be able to see the Billing Address in order to purchase the products

        // clicks checkout
        JSUtils.clickElementByJS(shoppingPage_e.checkout);

        // verify  Billing Address is visible
        Assert.assertTrue(shoppingPage_e.billingAddress.isDisplayed());

        //6-The user should be able to view and select payment options.
        //verify is visible payment methods
        Assert.assertTrue(shoppingPage_e.paymentMethod.isDisplayed());

        //clicks Wire transfer/EFT
        JSUtils.clickElementByJS(shoppingPage_e.wireTransfer);
        ReusableMethods.waitFor(3);

        //clicks Pay at the door
        JSUtils.clickElementByJS(shoppingPage_e.payAtTheDoor);
        ReusableMethods.waitFor(3);

//The generated coupon should be entered by clicking ENTER YOUR CODE.
        JSUtils.clickElementByJS(shoppingPage_e.coupon);
        ReusableMethods.waitFor(2);

        shoppingPage_e.couponCode.sendKeys("1864");
        shoppingPage_e.coupon.sendKeys(Keys.ENTER);

       JSUtils.clickElementByJS(shoppingPage_e.applyCoupon);


        //clicks Place Order
        JSUtils.clickElementByJS(shoppingPage_e.placeOrder);
        ReusableMethods.waitFor(3);

        //verify complete purchase
        String orderComplete= shoppingPage_e.orderComplete.getText();
        Assert.assertTrue(orderComplete.contains("Thank you. Your order has been received."));


    }
}
