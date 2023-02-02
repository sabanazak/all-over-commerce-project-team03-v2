package team03.tests;

import team03.pages.HomePage;
import team03.pages.LoginPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;

public class AllOverCommerceUtils {

    public static void login(String userName,String password) {
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        HomePage homePage=new HomePage();
        homePage.linkSignIn.click();
        LoginPage loginPage=new LoginPage();
        loginPage.inputSigninUsername.sendKeys(userName);
        loginPage.inputSiginPassword.sendKeys(password);
        loginPage.chkRememberMe.click();
        loginPage.btnSignIn.click();
    }

    public static void loginAsUser() {
        login("team03.user","TechProEd");
    }
    public static void loginAsVendor() {
        login("team03.vendor1","TechProEd");
    }

}
