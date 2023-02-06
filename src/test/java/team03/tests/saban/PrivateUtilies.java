package team03.tests.saban;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import team03.utilities.Driver;

import java.util.List;

import static team03.tests.AllOverCommerceUtils.login;

public class PrivateUtilies {

    public static void loginTestUser1() {
        login("sazak","TechProEd");
    }

    public static WebElement getWebElement(String xpath){
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public static List<WebElement> getWebElements(String xpath){
        return Driver.getDriver().findElements(By.xpath(xpath));
    }
}
