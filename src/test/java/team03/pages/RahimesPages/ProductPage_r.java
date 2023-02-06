package team03.pages.RahimesPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class ProductPage_r {


    public ProductPage_r() {
            PageFactory.initElements(Driver.getDriver(), this);
        }


        @FindBy(id = "product_type")
        public WebElement simpleProduct;

        @FindBy(id = "is_virtual")
        public WebElement virtual;

        @FindBy(id = "pro_title")
        public WebElement productTitle;

        @FindBy(id = "insert-media-button")
        public WebElement addMedia;

        @FindBy(xpath = "(//button[@class='button insert-media add_media'])[2]")
        public WebElement addMedia2;

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

        @FindBy(id="sku")
        public WebElement sku;

        @FindBy(id="manage_stock")
        public WebElement manageStock;

        @FindBy(id="sold_individually")
        public WebElement soldIndividually;

        @FindBy(id="backorders")
        public WebElement stockStatus;

        @FindBy(id = "attributes_is_active_1")
        public WebElement colorsCheckbox;

        @FindBy(id = "attributes_is_active_1")
        public WebElement attributesActive;

        @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
        public WebElement colorInput;

        @FindBy(xpath = "select2-attributes_value_1-result-lv5i-40")
        public WebElement green;

        @FindBy(xpath = "//button[text()='Select all']")
        public WebElement selectAllColor;

        @FindBy(xpath = "//button[text()='Select none']")
        public WebElement selectNoneColor;

        @FindBy(xpath = "//button[text()='Add New']")
        public WebElement addNewColor;

        @FindBy(id = "attributes_is_visible_1")
        public WebElement visibleOnPageColor;

        @FindBy(id = "attributes_is_active_2")
        public WebElement sizeCheckbox;

        @FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
        public WebElement sizeInput;

        @FindBy(xpath = "(//button[text()='Select all'])[2]")
        public WebElement selectAllSize;

        @FindBy(xpath = "(//button[text()='Select none'])[2]")
        public WebElement selectNoneSize;

        @FindBy(xpath = "(//button[text()='Add New'])[2]")
        public WebElement addNewSize;

        @FindBy(id = "attributes_is_visible_2")
        public WebElement visibleOnPageSize;

        @FindBy(xpath = "//button[@class='button wcfm_add_attribute']")
        public WebElement addAttributeButton;

        @FindBy(xpath = "//p[@class='attributes_name_0 wcfm_title wcfm_ele simple variable external grouped booking']")
        public WebElement newAttributeName;

        @FindBy(xpath="//*[@id=wcfm_products_simple_submit_button]")
        public WebElement submit;

    }


