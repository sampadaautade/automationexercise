package pages;

import org.checkerframework.checker.units.qual.A;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSetup;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static setup.BaseSetup.*;



public class ProductDetailPage {
    WebDriverWait wait;
    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
    }
    List<String> productNames = new ArrayList<>();

    @FindBy(linkText = "Home")
    WebElement homePage;
    @FindBy(xpath = "(//h2[contains(text(),'Full-Fledged practice website for Automation Engin')])[1]")
    WebElement homePageTextConfirmation;

    @FindBy(css = "a[href='/products']")
    WebElement productPage;
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement titleTextCenter;
    @FindBy(xpath = "(//h2[normalize-space()='All Products'])[1]")
    WebElement allProductTextConfirmation;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstProductButton;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement productName;
    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    WebElement categoryName;
    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement price;
    @FindBy(xpath = "//div[@class='product-information']/p[2]")
    WebElement availability;
    @FindBy(xpath = "//div[@class='product-information']/p[3]")
    WebElement condition;
    @FindBy(xpath = "//div[@class='product-information']/p[4]")
    WebElement brand;

    @FindBy(id = "search_product")
    WebElement searchProductInput;
    @FindBy(id = "submit_search")
    WebElement searchProductButton;
    @FindBy(xpath = "(//h2[normalize-space()='Searched Products'])[1]")
    WebElement searchProductsTextConfirmation;



    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    List<WebElement> productNameList;
    @FindBy(xpath = "//div[@class='product-overlay']/div[1]/a[@data-product-id='1']")
    WebElement mouseHoveringAddToCartButton;
    @FindBy(xpath = "(//img[@alt='ecommerce website products'])[1]")
    WebElement firstProductForMouseHovering;
    @FindBy(xpath = "(//img[@alt='ecommerce website products'])[2]")
    WebElement secondProductForMouseHovering;
    @FindBy(xpath = "//div[@class='product-overlay']/div[1]/a[@data-product-id='2']")
    WebElement secondProductAddToCartButton;
    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueShoppingButton;
    //@FindBy(xpath = "//a[.='View Cart']")
    //@FindBy(partialLinkText = "View Cart")
    @FindBy(css = "a[href='/view_cart']")
    WebElement viewCartButton;
    @FindBy(css = "li[class='active']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//table[@class='table table-condensed']/tbody")
    WebElement table;
    @FindBy(id = "quantity")
    private WebElement quantityInput;
    @FindBy(css = "button[class='btn btn-default cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//td[contains(@class, 'cart_quantity')]/button")
    private List<WebElement> quantityList;

    @FindBy(css = "a[data-product-id='1']")
    private WebElement addToCartButton1;

    @FindBy(css = "a[class='btn btn-default check_out']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//ul[contains(@id, 'address_delivery')]//li")
    private List<WebElement> addressDelivery;

    @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
    private List<WebElement> addressInvoice;

    @FindBy(xpath = "//h2[.='Review Your Order']")
    WebElement reviewYourOrderConfirmation;
    @FindBy(name = "message")
    WebElement commentBox;
    @FindBy(css = "a[href='/payment']")
    WebElement placeOrderButton;
    @FindBy(name = "name_on_card")
    WebElement nameOnCard;
    @FindBy(name = "card_number")
    WebElement cardNo;
    @FindBy(name = "cvc")
    WebElement cvc;
    @FindBy(name = "expiry_month")
    WebElement expiryMonth;
    @FindBy(name = "expiry_year")
    WebElement expiryYear;
    @FindBy(id = "submit")
    WebElement payAndConfirmButton;
    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p")
    WebElement successMessage;
    @FindBy(id="dismiss-button")
    WebElement adDismissButton;
    @FindBy(xpath = "//td[@class='cart_delete']/a")
    List<WebElement> deleteItemsFromCart;
    @FindBy(xpath = "//span/p[@class='text-center']/b")
    WebElement emptyCartMsg;
    @FindBy(id = "accordian")
    WebElement category;

    @FindBy(xpath = "//div[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;

    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dressCategory;

    @FindBy(css = "a[href='#Men']")
    private WebElement menCategory;

    @FindBy(css = "a[href='/category_products/3']")
    private WebElement tShirtsCategory;

    @FindBy(xpath = "//h2[.='Category']")
    WebElement categoryTitle;
    @FindBy(xpath = "(//h4[@class='panel-title'])[1]")
    WebElement categoryField;
    @FindBy(xpath = "//div[@id='Women']//a")
    List<WebElement> subCategoryFields;
//[contains(text(),'Dress')]
    @FindBy(css = ".title.text-center")
    WebElement confirmatinOfCategoryPage;
    @FindBy(xpath = "(//h4[@class='panel-title'])[2]")
    WebElement categoryField2;
    @FindBy(xpath = "//div[@id='Men']//a")
    List<WebElement> subCategoryFieldsOf2;
    @FindBy(xpath = "//h2[.='Men - Tshirts Products']")
    WebElement confirmatinOfCategoryPage2;

    @FindBy(css = "div[class='brands-name']")
    private WebElement brands;

    @FindBy(css = "a[href='/brand_products/Polo']")
    private WebElement poloBrand;

    @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
     private List<WebElement> ProductNameList;

    @FindBy(css = "a[href='/brand_products/Madame']")
    private WebElement madameBrand;

    @FindBy(css = "a[class='btn btn-default add-to-cart']")
    List<WebElement> addButtons;

    @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
    private List<WebElement> productNamesOnCart;



    @FindBy(css = "a[href='#reviews']")
    private WebElement writeReviewText;

    @FindBy(id = "name")
    private WebElement yourNameInput;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "review")
    private WebElement addReviewHere;

    @FindBy(id = "button-review")
    private WebElement reviewButton;

    @FindBy(xpath = "//div[@class='alert-success alert']/span")
    private WebElement reviewSuccessMessage;

    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    private WebElement recommendedItemsText;

   // @FindBy(xpath = "//h2[text()='recommended items']//following::a[text()='Add to cart']")
    @FindBy(xpath = "//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")
   // @FindBy(css = "div[id='recommended-item-carousel'] a[class='btn btn-default add-to-cart']")
    //h2[text()='recommended items']//following::a[text()='Add to cart'][1]
     WebElement blueTopAddToCartButton;
    @FindBy(css = "a[class='btn btn-default check_out']")
    WebElement downloadInvoiceButton;
    @FindBy(css = "a[href='/']")
    WebElement continueToHome;
    WebElement f;

    public void productDetailsPageConfirmation(){
        Assert.assertTrue(homePageTextConfirmation.isDisplayed());
        productPage.click();
        Assert.assertTrue(titleTextCenter.getText().contains("ALL PRODUCTS"));
        viewProductOfFirstProductButton.click();
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(categoryName.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(availability.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());
    }

    public void productSearch(){
        Assert.assertTrue(homePageTextConfirmation.isDisplayed());
        productPage.click();
        Assert.assertTrue(titleTextCenter.getText().contains("ALL PRODUCTS"));
        searchProductInput.sendKeys("Sleeves");
        searchProductButton.click();
        Assert.assertTrue(titleTextCenter.getText().contains("SEARCHED PRODUCTS"));
        for(WebElement productName : productNameList){
            Assert.assertTrue(productName.isDisplayed());
            Assert.assertTrue(productName.getText().contains("Sleeves"));
        }
    }
    public void productAddToCart(){
        Assert.assertTrue(homePageTextConfirmation.isDisplayed());
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(productPage)));
        productPage.click();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(productPage)));
        Actions act=new Actions(driver);
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(firstProductForMouseHovering)));
        act.moveToElement(firstProductForMouseHovering).perform();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(mouseHoveringAddToCartButton)));
        mouseHoveringAddToCartButton.click();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(continueShoppingButton)));
        continueShoppingButton.click();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(secondProductForMouseHovering)));
        act.moveToElement(secondProductForMouseHovering).perform();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(secondProductAddToCartButton)));
        secondProductAddToCartButton.click();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(viewCartButton)));
        viewCartButton.click();
        Assert.assertEquals(shoppingCart.getText(), "Shopping Cart");
        List <WebElement> rowsList = table.findElements(By.tagName("tr"));
        System.out.println("Rows " + rowsList.size());
        Assert.assertEquals(2,rowsList.size());
        for(WebElement row : rowsList){
            List<WebElement> columnList = row.findElements(By.tagName("td"));
            Assert.assertEquals(columnList.get(2).getText(),columnList.get(4).getText());
            Assert.assertEquals("1",columnList.get(3).getText());
        }

    }

    public void productQuantityInCart(){
        Assert.assertTrue(homePageTextConfirmation.isDisplayed());
        viewProductOfFirstProductButton.click();
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise - Product Details"));
        quantityInput.clear();
        quantityInput.sendKeys("4");
        addToCartButton.click();
        viewCartButton.click();
        Assert.assertEquals(shoppingCart.getText(), "Shopping Cart");
        for(WebElement quantity : quantityList){
            Assert.assertEquals("4",quantity.getText());
        }
    }

    public void productCheckout(){
        System.out.println("Verifying Home Page");
        Assert.assertTrue(homePageTextConfirmation.isDisplayed());
        Actions act=new Actions(driver);
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(firstProductForMouseHovering)));
        act.moveToElement(firstProductForMouseHovering).perform();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(mouseHoveringAddToCartButton)));
        mouseHoveringAddToCartButton.click();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(continueShoppingButton)));
        continueShoppingButton.click();
        viewCartButton.click();
        Assert.assertEquals(shoppingCart.getText(), "Shopping Cart");
    }
    public void productCheckoutAfterLogin(JSONObject addressJson){
        viewCartButton.click();
        Assert.assertEquals(shoppingCart.getText(), "Shopping Cart");
        proceedToCheckoutButton.click();
        // Verifying Delivery Address
        for(WebElement addressLine : addressDelivery){
            System.out.println(addressLine.getText());
        }
        Assert.assertEquals("YOUR DELIVERY ADDRESS", addressDelivery.get(0).getText());
        Assert.assertEquals("Mrs. " + (String) addressJson.get("firstName") + " " + (String) addressJson.get("lastName"),addressDelivery.get(1).getText());
        Assert.assertEquals((String) addressJson.get("company"),addressDelivery.get(2).getText() );
        Assert.assertEquals((String) addressJson.get("address"),addressDelivery.get(3).getText());
        Assert.assertEquals((String) addressJson.get("address2"),addressDelivery.get(4).getText());
        Assert.assertEquals((String)addressJson.get("city")+" "+(String) addressJson.get("state")+" "+(String) addressJson.get("zipcode"),addressDelivery.get(5).getText());
        Assert.assertEquals((String) addressJson.get("country"),addressDelivery.get(6).getText());
        Assert.assertEquals((String) addressJson.get("mobileNumber"),addressDelivery.get(7).getText());

        // Verifying Billing Address
        for(WebElement addressLine : addressInvoice){
            System.out.println(addressLine.getText());
            //address.add(addressLine.getText());
        }
        Assert.assertEquals("YOUR BILLING ADDRESS", addressInvoice.get(0).getText());
        Assert.assertEquals("Mrs. " + (String) addressJson.get("firstName") + " " + (String) addressJson.get("lastName"),addressInvoice.get(1).getText());
        Assert.assertEquals((String) addressJson.get("company"),addressInvoice.get(2).getText() );
        Assert.assertEquals((String) addressJson.get("address"),addressInvoice.get(3).getText());
        Assert.assertEquals((String) addressJson.get("address2"),addressInvoice.get(4).getText());
        Assert.assertEquals((String) addressJson.get("city")+" "+(String) addressJson.get("state")+" "+(String) addressJson.get("zipcode"),addressInvoice.get(5).getText());
        Assert.assertEquals((String) addressJson.get("country"),addressInvoice.get(6).getText());
        Assert.assertEquals((String) addressJson.get("mobileNumber"),addressInvoice.get(7).getText());
        Assert.assertEquals("Review Your Order",reviewYourOrderConfirmation.getText());
        commentBox.sendKeys("gift wrap it");
        placeOrderButton.click();
        nameOnCard.sendKeys((String) paymentDetailsJson.get("nameOnCard"));
        cardNo.sendKeys((String) paymentDetailsJson.get("cardNumber"));
        cvc.sendKeys((String) paymentDetailsJson.get("cvc"));
        expiryMonth.sendKeys((String) paymentDetailsJson.get("expiryMonth"));
        expiryYear.sendKeys((String) paymentDetailsJson.get("expiryYear"));
        payAndConfirmButton.click();
        Assert.assertEquals(successMessage.getText(), "Congratulations! Your order has been confirmed!");

    }

    public void removeProductFromCart(){
      for(WebElement deleteItemFromCart : deleteItemsFromCart )  {
          deleteItemFromCart.click();
          wait.until(ExpectedConditions.refreshed(visibilityOf(emptyCartMsg)));
          Assert.assertEquals("Cart is empty!",emptyCartMsg.getText());
      }
    }
    public void viewWomenCategoryProduct(){
        Assert.assertTrue(category.isDisplayed());
        wait.until(ExpectedConditions.refreshed(visibilityOf(womenCategory)));
        womenCategory.click();
        wait.until(ExpectedConditions.refreshed(visibilityOf(dressCategory)));
        dressCategory.click();
        Assert.assertEquals("WOMEN - DRESS PRODUCTS",confirmatinOfCategoryPage.getText().toUpperCase());
     }

    public void viewMenCategoryProduct(){
        wait.until(ExpectedConditions.refreshed(visibilityOf(menCategory)));
        menCategory.click();
        wait.until(ExpectedConditions.refreshed(visibilityOf(tShirtsCategory)));
        tShirtsCategory.click();
        wait.until(ExpectedConditions.refreshed(visibilityOf(confirmatinOfCategoryPage)));
        Assert.assertEquals("MEN - TSHIRTS PRODUCTS",confirmatinOfCategoryPage.getText().toUpperCase());
    }

    public void viewPoloBrandProduct(){
        productPage.click();
        Assert.assertTrue(brands.isDisplayed());
        poloBrand.click();
        Assert.assertEquals("BRAND - POLO PRODUCTS",confirmatinOfCategoryPage.getText().toUpperCase());
        for (int i = 0; i < ProductNameList.size(); i++) {
            System.out.println(ProductNameList.get(i).getText());
            Assert.assertEquals(ProductNameList.get(i).getText(), (String) poloBrandProductsJson.get(String.valueOf(i)));
        }
    }

    public void viewMadamBrandProduct(){
        madameBrand.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/brand_products/Madame"));
        Assert.assertEquals("BRAND - MADAME PRODUCTS",confirmatinOfCategoryPage.getText().toUpperCase());
        for (int i = 0; i < ProductNameList.size(); i++) {
            Assert.assertEquals(ProductNameList.get(i).getText(), (String) madameBrandProductsJson.get(String.valueOf(i)));
        }
    }


    public  void searchProductsAndVerifyCartAfterLogin(){
        Assert.assertTrue(homePage.isDisplayed());
        productPage.click();
       // Assert.assertTrue(driver.getCurrentUrl().contains("/products"));
        searchProductInput.sendKeys("blue");
        searchProductButton.click();
        Assert.assertEquals("SEARCHED PRODUCTS",searchProductsTextConfirmation.getText().toUpperCase());

        for (int i = 0; i < ProductNameList.size(); i++) {
            System.out.println(ProductNameList.get(i).getText());
            productNames.add(ProductNameList.get(i).getText());
            Assert.assertTrue(ProductNameList.get(i).getText().toLowerCase().contains("blue"));
        }

        for (int i = 0; i < addButtons.size(); i = i + 2) {
            wait.until(ExpectedConditions.refreshed(elementToBeClickable(addButtons.get(i))));
            addButtons.get(i).click();
            wait.until(ExpectedConditions.refreshed(elementToBeClickable(continueShoppingButton)));
            continueShoppingButton.click();
        }


    }
    public void verifyProductNames(){
        viewCartButton.click();
        for (int i = 0; i < productNamesOnCart.size(); i++) {
            Assert.assertEquals(productNames.get(i),productNamesOnCart.get(i).getText());
        }
    }

    public void writeProductReview(){
        productPage.click();
        Assert.assertEquals(allProductTextConfirmation.getText(),"ALL PRODUCTS");
        viewProductOfFirstProductButton.click();
        Assert.assertTrue(writeReviewText.isDisplayed());
        yourNameInput.sendKeys("ExcelR");
        emailAddress.sendKeys("hyderabadts123@gmail.com");
        addReviewHere.sendKeys("Nice Product :) !!!");
        reviewButton.click();
        Assert.assertEquals(reviewSuccessMessage.getText(),"Thank you for your review.");
    }

    public void addRecommendedItemsToCart(){
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        JavascriptExecutor js = (JavascriptExecutor) BaseSetup.driver;
//Scroll down till the bottom of the page
        js.executeScript("arguments[0].scrollIntoView();", recommendedItemsText);


        Assert.assertEquals(recommendedItemsText.getText().toUpperCase(),"RECOMMENDED ITEMS");
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(blueTopAddToCartButton)));
        blueTopAddToCartButton.click();
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(continueShoppingButton)));
        continueShoppingButton.click();
        viewCartButton.click();
        Assert.assertEquals(productNamesOnCart.get(0).getText(),"Stylish Dress");

    }
    public void downloadInvoiceAfterPurchaseOrder()  throws InterruptedException{
        downloadInvoiceButton.click();
        Thread.sleep(10000);
        Assert.assertTrue(isFileAvailable());
        continueToHome.click();
    }
    public boolean isFileAvailable() throws InterruptedException{
        System.out.println("Check if file available after download ");
        boolean isFileAvailable = false;
        File folder = new File(downloadPath);
        File[] listOfFiles =folder.listFiles();
        for(File listOfFile : listOfFiles) {
            if(listOfFile.isFile()){
                String fileName=listOfFile.getName();
                System.out.println("File : " + fileName);
                if(fileName.contains(expectedFileName)){
                    isFileAvailable=true;
                    break;
                }
            }
        }
        return isFileAvailable;
    }

    public boolean deleteIfFilePresent(){
        System.out.println("delete file from download if present ");
        boolean isFileAvailable = false;
        File folder = new File(downloadPath);
        File[] listOfFiles =folder.listFiles();
        for(File listOfFile : listOfFiles) {
            if(listOfFile.isFile()){
                String fileName=listOfFile.getName();
                System.out.println("File " + fileName);
                if(fileName.contains(expectedFileName)){
                    isFileAvailable = listOfFile.delete();
                }
            }
        }
        return isFileAvailable;
    }
}