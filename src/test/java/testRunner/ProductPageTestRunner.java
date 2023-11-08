package testRunner;

import org.testng.annotations.Test;
import pages.LoginUserPage;
import pages.ProductDetailPage;
import pages.SignUpPage;
import setup.BaseSetup;

import java.time.Duration;

public class ProductPageTestRunner extends BaseSetup {
    ProductDetailPage productPage ;
    SignUpPage singUp;

    LoginUserPage loginPage;

    @Test(priority = 1, description = "Test Case 8: Verify All Products and product detail page")
    public void verifyAllProductAndProductDetails(){
        productPage=new ProductDetailPage(driver);
        productPage.productDetailsPageConfirmation();
    }

    @Test(priority = 2, description = "Test Case 9: Search Product")
    public void verifyProductSearch(){
        productPage=new ProductDetailPage(driver);
        productPage.productSearch();
    }
    @Test(priority = 3, description = "Test Case 12: Add Products in Cart")
    public void productAddToCart(){
        productPage = new ProductDetailPage(driver);
        productPage.productAddToCart();
    }

    @Test(priority = 4, description = "Test Case 13: Verify Product quantity in Cart")
    public void verifyProductQuantity(){
        productPage = new ProductDetailPage(driver);
        productPage.productQuantityInCart();
    }

    @Test(priority = 5, description = "Test Case 14: Place Order: Register while Checkout")
    public void placeOrderRegisterWhileCheckout(){
        singUp = new SignUpPage(driver);
        productPage = new ProductDetailPage(driver);
        productPage.productCheckout();
        singUp.userRegistration(userRegisterJson);
        productPage.productCheckoutAfterLogin(userRegisterJson);
        singUp.userDeletion();

    }
    @Test(priority = 6, description = "Test Case 15: Place Order: Register before Checkout")
    public void placeOrderRegisterBeforeCheckout(){
        singUp = new SignUpPage(driver);
        productPage = new ProductDetailPage(driver);
        singUp.userRegistration(userRegisterJson);
        productPage.productCheckout();
        productPage.productCheckoutAfterLogin(userRegisterJson);
        singUp.userDeletion();
    }
    @Test(priority = 7, description = "Test Case 16: Place Order: Login before Checkout")
    public void loginBeforeCheckout(){
        loginPage = new LoginUserPage(driver);
        loginPage.loginUsingValidCredential(userLoginJson);
        productPage = new ProductDetailPage(driver);
        productPage.productCheckout();
        productPage.productCheckoutAfterLogin(userLoginJson);
    }
    @Test(priority = 8, description = "Test Case 17: Remove Products From Cart")
    public void removeProductFromCart(){
        productPage = new ProductDetailPage(driver);
        productPage.productCheckout();
        productPage.removeProductFromCart();
    }

    @Test(priority = 9, description = "Test Case 18: View Category Products")
    public void viewCategoryProduct(){
        productPage = new ProductDetailPage(driver);
        productPage.viewWomenCategoryProduct();
        productPage = new ProductDetailPage(driver);
        productPage.viewMenCategoryProduct();
    }

    @Test(priority = 10, description = "Test Case 19: View & Cart Brand Products")
    public void viewBrandProduct(){
        productPage = new ProductDetailPage(driver);
        productPage.viewPoloBrandProduct();
        productPage = new ProductDetailPage(driver);
        productPage.viewMadamBrandProduct();
    }
    @Test(priority = 11, description = "Test Case 20: Search Products and Verify Cart After Login")
    public void searchProductsAndVerifyCartAfterLogin() {
        productPage = new ProductDetailPage(driver);
        productPage.searchProductsAndVerifyCartAfterLogin();
        productPage.verifyProductNames();
        loginPage = new LoginUserPage(driver);
        loginPage.loginUsingValidCredential(userLoginJson);
        productPage.verifyProductNames();

    }

    @Test(priority = 12, description = "Test Case 21: Add review on product")
    public void writeProductReview() {
        productPage = new ProductDetailPage(driver);
        productPage.writeProductReview();

    }
    @Test(priority = 13, description = "Test Case 22: Add to cart from Recommended items")
    public void addRecommendedItemsToCart(){
        productPage = new ProductDetailPage(driver);
        productPage.addRecommendedItemsToCart();
    }
    @Test(priority = 14, description = "Test Case 23: Verify address details in checkout page")
    public void VerifyAddressDetailsInCheckoutPage(){
        singUp = new SignUpPage(driver);
        singUp.userRegistration(userRegisterJson);
        productPage = new ProductDetailPage(driver);
        productPage.productCheckout();
        productPage.productCheckoutAfterLogin(userRegisterJson);
        singUp.userDeletion();
    }
    @Test(priority = 15, description = "Test Case 24: Download Invoice after purchase order")
    public void DownloadInvoiceAfterPurchaseOrder() throws InterruptedException{
        productPage = new ProductDetailPage(driver);
        singUp = new SignUpPage(driver);
        productPage.deleteIfFilePresent();
        productPage.productCheckout();
        singUp.userRegistration(userRegisterJson);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        productPage.productCheckoutAfterLogin(userRegisterJson);
        productPage.downloadInvoiceAfterPurchaseOrder();
        singUp.userDeletion();
    }


}