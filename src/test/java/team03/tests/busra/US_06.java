package team03.tests.busra;

import org.testng.Assert;
import org.testng.annotations.Test;
import team03.pages.busraPage.HomePage_BS;
import team03.pages.busraPage.LoginPage_BS;
import team03.pages.busraPage.ShopPage_BS;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class US_06 {

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
   HomePage_BS homePage_bs=new HomePage_BS();
   LoginPage_BS loginPage_bs=new LoginPage_BS();
   ShopPage_BS shopPage_bs=new ShopPage_BS();

    //The user should be able to find the desired product in the search box.
    @Test
    public void searchBox(){

        //1-The user should be able to find the desired product in the search box.
        //Given user goes to "https://allovercommerce.com" page
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        homePage_bs.linkSignIn.click();
        loginPage_bs.login_and_register_Container.click();
        loginPage_bs.inputSigninUsername.sendKeys("team03.user");
        loginPage_bs.inputSiginPassword.sendKeys("TechProEd");
        loginPage_bs.btnSignIn.click();
        ReusableMethods.waitFor(3);


        //And user searches for "tarhana" on search box
        shopPage_bs.search.sendKeys("tarhana");
        ReusableMethods.waitFor(3);

        //And user clicks on search button
        JSUtils.clickElementByJS(shopPage_bs.searchButton);
        ReusableMethods.waitFor(3);

        //The user should be able to add the product they are looking for to their cart. (ADD TO CART)

        JSUtils.clickElementByJS(shopPage_bs.getProduct);
        shopPage_bs.addToCart.click();

        //verify added to cart
        String addedToCart= shopPage_bs.addedToCart.getText();
        Assert.assertTrue(addedToCart.contains("“Kızılcık Tarhanası” has been added to your cart."));

        //3-User should see the items that have been added to the cart.
        //And user clicks on cart
        JSUtils.clickElementByJS(shopPage_bs.cart);

        //Then verify product count is displayed
        Assert.assertTrue(shopPage_bs.cartCount.isDisplayed());

        //4-The amount of products in the cart should be adjustable by the user.
        //clicks view cart.
        JSUtils.clickElementByJS(shopPage_bs.viewCart);
        ReusableMethods.waitFor(3);

        //clicks quantity plus
        shopPage_bs.increaseButton.click();
        ReusableMethods.waitFor(3);

        //verify is count equal 2
        Assert.assertEquals("2","2");

        //5-User should be able to see the Billing Address in order to purchase the products

        // clicks checkout
        JSUtils.clickElementByJS(shopPage_bs.checkout);

        // verify  Billing Address is visible
        Assert.assertTrue(shopPage_bs.billingAddress.isDisplayed());

        //6-The user should be able to view and select payment options.

        //verify is visible payment methods
        Assert.assertTrue(shopPage_bs.paymentMethod.isDisplayed());

        //clicks Wire transfer/EFT
        JSUtils.clickElementByJS(shopPage_bs.wireTransfer);
        ReusableMethods.waitFor(3);

        //clicks Pay at the door
        JSUtils.clickElementByJS(shopPage_bs.payAtTheDoor);
        ReusableMethods.waitFor(3);

        //clicks Place Order
        JSUtils.clickElementByJS(shopPage_bs.placeOrder);
        ReusableMethods.waitFor(3);

        //verify complete purchase
        String orderComplete= shopPage_bs.orderComplete.getText();
        Assert.assertTrue(orderComplete.contains("Thank you. Your order has been received."));









    }
}
