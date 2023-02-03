package team03.tests.saban;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import team03.pages.*;
import team03.pages.ShopPage;
import team03.tests.AllOverCommerceUtils;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;
import team03.utilities.ReusableMethods;

public class US_08 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    WishlistPage wishlistPage;
    ShopPage shopPage;
    AccountDetailsPage accountDetailsPage;
    SideShoppingCardPage shoppingCardPage;
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

        PrivateUtilies.loginTestUser1();

        Driver.getDriver().navigate().refresh();
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
        System.out.println(Driver.getDriver().getPageSource());
        By buttonLocator = By.tagName("//a[.='Add to cart']");
        int buttonCount = Driver.getDriver().findElements(buttonLocator).size();
        for (int i = 0; i < buttonCount; i++) {
            WebElement addCartButton = Driver.getDriver().findElements(buttonLocator).get(i);
            JSUtils.clickElementByJS(addCartButton);
            // at this point buttonLink is gone stale!
            System.out.println(addCartButton.getText());
            // do some stuff
            Driver.wait(1);
            //Driver.getDriver().navigate().back();
        }

//        homePage.linkCart.click();
//        Assert.assertTrue(shoppingCardPage.btnCheckoutSide.isDisplayed());
//        shoppingCardPage.btnCheckoutSide.click();
    }














    @AfterTest
    public void tearDown() {
        ReusableMethods.waitFor(4);
        //Driver.closeDriver();
    }

}
