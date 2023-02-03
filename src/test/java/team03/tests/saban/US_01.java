package team03.tests.saban;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import team03.pages.sabanpages.HomePage;
import team03.pages.sabanpages.LoginPage;
import team03.pages.sabanpages.UserRegisterPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

import java.util.Map;

public class US_01 {
    HomePage homePage;
    LoginPage loginPage;
    UserRegisterPage userRegisterPage;




    //Process Negative Scenarios
    private void processTestScenario(String testCaseKeyword){
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        homePage=new HomePage();
        loginPage=new LoginPage();
        userRegisterPage=new UserRegisterPage();

        homePage.linkRegister.click();
        Driver.waitForVisibility(userRegisterPage.inputRegisterUsername,10);

        Map<String,String> testData=TestData.US01(testCaseKeyword);

        if(testData.containsKey("username")) {
            Driver.waitAndSendText(userRegisterPage.inputRegisterUsername,testData.get("username"),1);
        }

        if(testData.containsKey("email")) {
            Driver.waitAndSendText(userRegisterPage.inputRegisterEmail,testData.get("email"),1);
        }
        if(testData.containsKey("password")) {
            Driver.waitAndSendText(userRegisterPage.inputRegisterPassword,testData.get("password"),1);
        }

        if(testData.containsKey("agreement")) {
            if (testData.get("agreement").toString().startsWith("t")) Driver.waitAndClick(userRegisterPage.chkRegisterPolicy,1);
        }
        Driver.waitAndClick(userRegisterPage.btnRegisterSignUp,1);
    }

    @Test
    public void test_US01_TC01(){
        processTestScenario("TC01");
        Driver.wait(1);
        Assert.assertTrue(homePage.linkSignOut.isDisplayed());
    }
    @Test
    public void testByFaker_US01_TC01(){
        Faker faker=new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        homePage=new HomePage();
        loginPage=new LoginPage();
        userRegisterPage=new UserRegisterPage();

        homePage.linkRegister.click();
        Driver.waitForVisibility(userRegisterPage.inputRegisterUsername,10);
        Driver.waitAndSendText(userRegisterPage.inputRegisterUsername,faker.name().username(),1);
        Driver.waitAndSendText(userRegisterPage.inputRegisterEmail,faker.internet().emailAddress(),1);
        Driver.waitAndSendText(userRegisterPage.inputRegisterPassword,faker.internet().password(8,10),1);
        Driver.waitAndClick(userRegisterPage.chkRegisterPolicy, 1);
        Driver.waitAndClick(userRegisterPage.btnRegisterSignUp,1);
        Driver.waitForVisibility(homePage.linkSignOut,5);
        Assert.assertTrue(homePage.linkSignOut.isDisplayed());
    }
    @Test
    public void test_US01_TC02(){
        //username is missing
        processTestScenario("TC02");
        Driver.wait(1);
        Assert.assertTrue(loginPage.login_and_register_Container.isDisplayed());
    }
    @Test
    public void test_US01_TC03(){
        //email is missing
        processTestScenario("TC03");
        Driver.wait(1);
        Assert.assertTrue(loginPage.login_and_register_Container.isDisplayed());
    }
    @Test
    public void test_US01_TC04(){
        //password is missing
        processTestScenario("TC04");
        Driver.wait(1);
        Assert.assertTrue(loginPage.login_and_register_Container.isDisplayed());
    }
    @Test
    public void test_US01_TC05(){
        //agreement is missing
        processTestScenario("TC05");
        Driver.wait(1);
        Assert.assertTrue(loginPage.login_and_register_Container.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        ReusableMethods.waitFor(4);
        Driver.closeDriver();
    }

}
