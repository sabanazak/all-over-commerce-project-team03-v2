package team03.tests.saban;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03.pages.*;
import team03.tests.AllOverCommerceUtils;
import team03.utilities.Driver;
import team03.utilities.JSUtils;

public class US_08 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    WishlistPage wishlistPage;
    ShopPage shopPage;
    AccountDetailsPage accountDetailsPage;

    private void clearWishlist() {
        try{
            for(WebElement removeButton:wishlistPage.removeFromWishlistButtons){
                JSUtils.clickElementByJS(removeButton);
            }
        }
        catch (Exception e) { }
    }

    @Test
    public void test_US08_TC01(){

        AllOverCommerceUtils.loginAsUser();
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
        WebElement firstProduct=shopPage.listOfAddToWishListIcons.get(0);
        WebElement lastProduct=shopPage.listOfAddToWishListIcons.get(shopPage.listOfAddToWishListIcons.size()-1);

        JSUtils.clickElementByJS(firstProduct);
        JSUtils.clickElementByJS(lastProduct);

        homePage.linkWishlist.click();

        Assert.assertEquals(2,wishlistPage.addedItemsTableRows.size());

    }

    @Test
    public void test_US08_TC02(){

        AllOverCommerceUtils.loginAsUser();

        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        wishlistPage=new WishlistPage();
        shopPage=new ShopPage();

        Driver.getDriver().navigate().refresh();  //to overcome Stale Element Reference Exception
        homePage.linkWishlist.click();
        Assert.assertTrue(wishlistPage.addedItemsTableRows.size()>0);


       for(WebElement quickViewButton:wishlistPage.quickViewButtons){
           JSUtils.clickElementByJS(quickViewButton);
           Driver.wait(3); // increase second if fails
           Assert.assertTrue(wishlistPage.categoryName.isDisplayed());
           JSUtils.clickElementByJS(wishlistPage.productAttributesContainerCloseButton);
           Driver.wait(2);
        }
    }

    @Test
    public void test_US08_TC03(){

        AllOverCommerceUtils.login("sazak","TechProEd");

        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        wishlistPage=new WishlistPage();
        shopPage=new ShopPage();

        Driver.getDriver().navigate().refresh();  //to overcome Stale Element Reference Exception
        homePage.linkWishlist.click();
        Assert.assertTrue(wishlistPage.addedItemsTableRows.size()>0);


       //Because when click first addCartButton, page refreshes and wishlistPage.addToCartButtons is gone stale
       // So below is not workinf
       /*for(WebElement addCartButton:wishlistPage.addToCartButtons) {
            JSUtils.clickElementByJS(addCartButton);
            Driver.wait(2);
            Driver.getDriver().navigate().back();
        }*/

        By pageLocator = By.tagName("//a[.='Add to cart']");
        int pageCount = Driver.getDriver().findElements(pageLocator).size();
        for (int i = 0; i < pageCount; i++) {
            WebElement addCartButton = Driver.getDriver().findElements(pageLocator).get(i);
            JSUtils.clickElementByJS(addCartButton);
            // at this point pageLink is gone stale!

            // do some stuff
            Driver.wait(2);
            Driver.getDriver().navigate().back();
        }
    }














    @Test
    public void test_AccountDetail_Biography(){
        AllOverCommerceUtils.loginAsUser();

        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        wishlistPage=new WishlistPage();
        shopPage=new ShopPage();
        accountDetailsPage=new AccountDetailsPage();

        homePage.linkSignOut.click();

        JSUtils.clickElementByJS(myAccountPage.menuAccountDetails);

        Driver.getDriver().switchTo().frame("user_description_ifr");

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].textContent = arguments[1];", accountDetailsPage.inputBiography, "Biyografi alanini buradan doldurabilirsiniz");

        //OR
        //String biyografi="bla bla";
        //String command="arguments[0].textContent = '" + biyografi + "';";
        //JSUtils.executeJScommand(accountDetailsPage.inputBiography,command);

        Driver.getDriver().switchTo().defaultContent();

    }

}
