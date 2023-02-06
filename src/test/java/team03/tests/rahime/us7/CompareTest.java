package team03.tests.rahime.us7;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import team03.pages.RahimesPages.HomePage_r;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.JSUtils;

import static team03.utilities.ReusableMethods.waitFor;

public class CompareTest extends JSUtils {

    //US_07	User should be able to compare selected items. (Compare)

    //User should be able to select up to 4 products to compare
    //The user should be able to remove products from comparison and add new products.
    //The user should be able to compare selected products
    //The user should be able to remove items from the comparison screen.

    WebDriver driver;
    @Test
    public void compareTest() {

        HomePage_r homePage = new HomePage_r();
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

        clickElementByJS(homePage.compareBtn);
        waitFor(2);

        clickElementByJS(homePage.compareBtn1);
        waitFor(2);

        clickElementByJS(homePage.compareBtn2);
        waitFor(2);

        clickElementByJS(homePage.compareBtn3);
        waitFor(2);

        clickElementByJS(homePage.strtCompareBtn);
        waitFor(2);

        clickElementByJS(homePage.removeCompareBtn);
        waitFor(2);

        clickElementByJS(homePage.removeCompareBtn1);
        waitFor(2);

        clickElementByJS(homePage.removeCompareBtn2);
        waitFor(2);

        clickElementByJS(homePage.removeCompareBtn3);
        waitFor(2);







    }




}