package team03.pages.RahimesPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class AttributesPage_r {


    public void AttributesPage_r(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Attributes

    @FindBy(xpath= "//div[@id='wcfm_products_manage_form_attribute_head']/div")
    public static WebElement attributes;


    @FindBy(id="attributes_is_active_1")
    public WebElement active;

    @FindBy(xpath="(//ul[@class='select2-selection__rendered'])[2]")
    public WebElement color;

    @FindBy(xpath="(//button[@class='button wcfm_add_attribute_term wcfm_select_all_attributes'])[1]")
    public WebElement selectAllColor;

    @FindBy(xpath="(//button[@class='button wcfm_add_attribute_term wcfm_select_all_attributes'])[2]")
    public WebElement selectAllSize;

    @FindBy(id="attributes_is_visible_1")
    public WebElement visibleOnProduct;

    @FindBy(id="attributes_is_active_2")
    public WebElement size;

    @FindBy(xpath="//select[@name='wcfm_attribute_taxonomy']")
    public WebElement addAttribute;

    @FindBy(xpath="//button[@class='button wcfm_add_attribute']")
    public WebElement addAttributeButton;

    @FindBy(xpath="(//span[@title='Toggle Block'])[2]")
    public WebElement colorDown;

    @FindBy(id="attributes_is_active_1")
    public WebElement colorActive;

    @FindBy(id="attributes_is_active_2")
    public WebElement sizeActive;

    @FindBy(xpath="(//span[@title='Toggle Block'])[3]")
    public WebElement sizeDown;


    @FindBy(xpath = "//p[@class='attributes_name_0 wcfm_title wcfm_ele simple variable external grouped booking']")
    public WebElement newAttributeName;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_inventory_head']/div")
    public WebElement inventoryHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_shipping_head']/div")
    public WebElement shippingHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_attribute_head']/div")
    public WebElement attributeHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_linked_head']/div")
    public WebElement linkedHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_yoast_head']/div")
    public WebElement seoHead;

    @FindBy(xpath = "//div[@class='page_collapsible wcfm_acf_products_manage_3116_collapsible simple variable external grouped booking collapse-close']/div")
    public WebElement wholesaleHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_advanced_head']/div")
    public WebElement advanceHead;




}




