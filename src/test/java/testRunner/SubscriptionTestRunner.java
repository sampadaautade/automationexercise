package testRunner;

import org.testng.annotations.Test;
import pages.Subscription;
import setup.BaseSetup;

public class SubscriptionTestRunner extends BaseSetup {
    Subscription subscription;

    @Test(priority = 1, description = "Test Case 10: Verify Subscription in home page")
    public void verifySubscriptionInHomePage(){
        subscription =new Subscription(driver);
        subscription.verifySubscriptionHomePage();
    }

    @Test(priority = 1, description = "Test Case 11: Verify Subscription in Cart page")
    public void verifySubscriptionInCartPage(){
        subscription =new Subscription(driver);
        subscription.verifySubscriptionCartPage();
    }
}