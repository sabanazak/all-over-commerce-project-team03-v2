package team03.tests.saban;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import team03.pages.HomePage;
import team03.pages.LoginPage;
import team03.pages.UserRegisterPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

import java.util.Map;

public class US_02 {
    HomePage homePage;
    LoginPage loginPage;
    UserRegisterPage userRegisterPage;

    private void processTestScenario(String testCaseKeyword){

        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        homePage=new HomePage();
        userRegisterPage=new UserRegisterPage();
        homePage.linkRegister.click();
        ReusableMethods.waitForVisibility(userRegisterPage.inputRegisterUsername,10);
        Map<String,String> testData=TestData.US02(testCaseKeyword);
        userRegisterPage.inputRegisterUsername.sendKeys(testData.get("username"));
        userRegisterPage.inputRegisterEmail.sendKeys(testData.get("email"));
        userRegisterPage.inputRegisterPassword.sendKeys(testData.get("password"));
        userRegisterPage.chkRegisterPolicy.click();
        userRegisterPage.btnRegisterSignUp.click();
    }


    @Test
    public void test_US02_TC01(){
        processTestScenario("TC01");
        Assert.assertTrue(userRegisterPage.msgRegisteredError.isDisplayed());
    }
    @Test
    public void test_US02_TC02(){
        processTestScenario("TC02");
        Assert.assertTrue(userRegisterPage.msgRegisteredError.isDisplayed());
    }
    @Test
    public void test_US02_TC03(){
        processTestScenario("TC03");
        Assert.assertTrue(userRegisterPage.msgRegisteredError.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        ReusableMethods.waitFor(4);
        Driver.closeDriver();
    }
}
