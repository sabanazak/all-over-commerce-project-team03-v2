package team03.tests.saban;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import team03.pages.sabanpages.*;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

import java.time.Duration;

public class US_08 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    WishlistPage wishlistPage;
    ShopPage shopPage;
    AccountDetailsPage accountDetailsPage;
    SideShoppingCardPage shoppingCardPage;
    ShoppingCardPage cardPage;
    CheckoutPage checkoutPage;
    OrderComplatePage orderComplatePage;
    Faker faker;
    private void clearWishlist() {
        try{
            for(WebElement removeButton:wishlistPage.removeFromWishlistButtons){
                JSUtils.clickElementByJS(removeButton);
            }
        }
        catch (Exception e) { }
    }

    //TC01 : The user should be able to add her/his favorite items to her/his Wishlist.
    @Test
    public void test_US08_TC01(){

        PrivateUtilies.loginTestUser1();
        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        wishlistPage=new WishlistPage();
        shopPage=new ShopPage();


        Driver.getDriver().navigate().refresh();  //to overcome Stale Element Reference Exception

        homePage.linkWishlist.click();

        try{
            JSUtils.clickElementByJS(wishlistPage.btnGoShop);
        }catch(Exception e) {
            clearWishlist();
            Driver.waitForVisibility(wishlistPage.btnGoShop,5);
            JSUtils.clickElementByJS(wishlistPage.btnGoShop);
        }

        Driver.waitForPageToLoad(10);
        WebElement firstProduct=shopPage.listOfAddToWishListIcons.get(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(firstProduct);
        JSUtils.clickElementByJS(firstProduct);

        Driver.wait(4);
        WebElement secondProduct=shopPage.listOfAddToWishListIcons.get(3);
        actions.moveToElement(secondProduct);
        JSUtils.clickElementByJS(secondProduct);

        homePage.linkWishlist.click();

        Assert.assertEquals(2,wishlistPage.addedItemsTableRows.size());

    }

    //TC02 : The user should be able to view the items added to the Wishlist.
    @Test
    public void test_US08_TC02(){

        PrivateUtilies.loginTestUser1();

        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        wishlistPage=new WishlistPage();
        shopPage=new ShopPage();

        Driver.getDriver().navigate().refresh();  //to overcome Stale Element Reference Exception
        homePage.linkWishlist.click();
        Assert.assertTrue(wishlistPage.addedItemsTableRows.size()>0);

    }

    //TC03 : The user should be able to view  the attributes of the items on their Wishlist.(QUICK VIEW)
    @Test
    public void test_US08_TC03() {

        PrivateUtilies.loginTestUser1();

        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        wishlistPage = new WishlistPage();
        shopPage = new ShopPage();

        Driver.getDriver().navigate().refresh();  //to overcome Stale Element Reference Exception
        homePage.linkWishlist.click();
        Assert.assertTrue(wishlistPage.addedItemsTableRows.size() > 0);


        for (WebElement quickViewButton : wishlistPage.quickViewButtons) {
            JSUtils.clickElementByJS(quickViewButton);
            Driver.wait(3); // increase second if fails
            Assert.assertTrue(wishlistPage.categoryName.isDisplayed());
            JSUtils.clickElementByJS(wishlistPage.productAttributesContainerCloseButton);
            Driver.wait(2);
        }
    }


    //TC04 : The user should be able to add the items on their Wishlist to their cart and purchase.
    @Test
    public void test_US08_TC04(){
        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        wishlistPage=new WishlistPage();
        shopPage=new ShopPage();
        shoppingCardPage=new SideShoppingCardPage();
        cardPage=new ShoppingCardPage();
        checkoutPage=new CheckoutPage();
        orderComplatePage=new OrderComplatePage();

        PrivateUtilies.loginTestUser1();

        Driver.wait(3);
        homePage.linkWishlist.click();
        wishlistPage=new WishlistPage();
        Assert.assertTrue(wishlistPage.addedItemsTableRows.size()>0);


       //Because when click first addCartButton, page refreshes and wishlistPage.addToCartButtons is gone stale
       // So below is not working
       /*for(WebElement addCartButton:wishlistPage.addToCartButtons) {
            JSUtils.clickElementByJS(addCartButton);
            Driver.wait(2);
            Driver.getDriver().navigate().back();
        }*/
        Driver.getDriver().navigate().refresh();
        Driver.wait(4);
        //Dummy
        By locatorAddToCardButton1 = By.xpath("(//td[@class='product-add-to-cart']/div/a)[1]");
        By locatorAddToCardButton2 = By.xpath("(//td[@class='product-add-to-cart']/div/a)[1]");
        JSUtils.clickElementByJS(wishlistPage.addToCardButton1);
        Driver.wait(4);
        Driver.waitForPageToLoad(10);
        wishlistPage.addToCardButton2=Driver.getDriver().findElement(locatorAddToCardButton2);
        JSUtils.clickElementByJS(wishlistPage.addToCardButton2);

        Driver.wait(3);
        homePage.linkCart.click();
        Driver.wait(2);
        shoppingCardPage.btnCheckoutSide.click();
        Driver.wait(2);
        clearAddressForm();

        faker=new Faker();

        Driver.wait(1);
        checkoutPage.inputBillingFirstName.sendKeys("Saban");
        Driver.wait(1);
        checkoutPage.inputBillingLastName.sendKeys("AZAK");
        Driver.wait(1);
        checkoutPage.inputBillingCompany.sendKeys("Company Name");
        Driver.wait(1);
        Driver.selectByVisibleText(checkoutPage.selectBillingCountry,"Canada");
        checkoutPage.inputBillingAddress1.sendKeys(faker.address().streetAddress());
        checkoutPage.inputBillingCity.sendKeys(faker.address().city());
        Driver.selectByVisibleText(checkoutPage.selectBillingState,"Ontario");
        checkoutPage.inputBillingPostcode.sendKeys("N2T2N2");
        checkoutPage.inputBillingPhone.sendKeys(faker.phoneNumber().cellPhone());

        //JSUtils.clickElementByJS(checkoutPage.chkShipToDifferentAddress);

        checkoutPage.inputShippingFirstName.sendKeys("Saban");
        Driver.wait(1);
        checkoutPage.inputShippingLastName.sendKeys("AZAK");
        Driver.wait(1);
        checkoutPage.inputShippingCompany.sendKeys("Company Name");
        Driver.wait(1);
        Driver.selectByVisibleText(checkoutPage.selectShippingCountry,"Canada");
        checkoutPage.inputShippingAddress1.sendKeys(faker.address().streetAddress());
        checkoutPage.inputShippingCity.sendKeys(faker.address().city());
        Driver.selectByVisibleText(checkoutPage.selectShippingState,"Ontario");
        checkoutPage.inputShippingPostcode.sendKeys("N2T2N2");
        checkoutPage.inputOrderComments.sendKeys("Please make it gift package");
        JSUtils.clickElementByJS(checkoutPage.radioPayAtDoor);
        Driver.wait(2);
        checkoutPage.btnPlaceOrder.click();

        Driver.waitForVisibility(orderComplatePage.orderComplateMessage,10);
        Assert.assertTrue(orderComplatePage.orderComplateMessage.isDisplayed());

    }

    private void clearAddressForm() {
        //------CLEAR--------------
        checkoutPage.inputBillingFirstName.clear();
        checkoutPage.inputBillingLastName.clear();
        checkoutPage.inputBillingCompany.clear();
        Driver.selectByIndex(checkoutPage.selectBillingCountry,1);
        checkoutPage.inputBillingAddress1.clear();
        checkoutPage.inputBillingAddress2.clear();
        checkoutPage.inputBillingCity.clear();
        checkoutPage.inputBillingPostcode.clear();
        checkoutPage.inputBillingPhone.clear();
        JSUtils.clickElementByJS(checkoutPage.chkShipToDifferentAddress);
        checkoutPage.inputShippingFirstName.clear();
        checkoutPage.inputShippingLastName.clear();
        checkoutPage.inputShippingCompany.clear();
        Driver.selectByIndex(checkoutPage.selectShippingCountry,1);
        checkoutPage.inputShippingAddress1.clear();
        checkoutPage.inputShippingAddress2.clear();
        checkoutPage.inputShippingCity.clear();
        checkoutPage.inputShippingPostcode.clear();
        checkoutPage.inputOrderComments.clear();
        //-------------------------
    }



    @AfterTest
    public void tearDown() {
        ReusableMethods.waitFor(4);
        Driver.closeDriver();
    }

}
