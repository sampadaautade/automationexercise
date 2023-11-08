package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import setup.BaseSetup;

import static setup.BaseSetup.*;

public class Subscription {
    public Subscription(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/']")
    private WebElement homePage;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    private WebElement subscriptionTextConfirmation;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement subscribeTextConfirmation;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartPage;

    public void verifySubscriptionHomePage(){
        Assert.assertTrue(homePage.isDisplayed());
        //Scroll down till the bottom of the page
        BaseSetup.getJavascriptExecutor().executeScript((String) applicationInputJson.get("scrolledDown"));
        Assert.assertEquals("SUBSCRIPTION",subscriptionTextConfirmation.getText());
        subscribeEmailInput.sendKeys((String) applicationInputJson.get("subscriberEmail"));
        subscribeButton.click();
        Assert.assertTrue(subscribeTextConfirmation.isDisplayed());
        Assert.assertEquals("You have been successfully subscribed!",subscribeTextConfirmation.getText());
    }

    public void verifySubscriptionCartPage(){
        Assert.assertTrue(homePage.isDisplayed());
        cartPage.click();
        //Scroll down till the bottom of the page
        BaseSetup.getJavascriptExecutor().executeScript((String) applicationInputJson.get("scrolledDown"));
        Assert.assertEquals("SUBSCRIPTION",subscriptionTextConfirmation.getText());
        subscribeEmailInput.sendKeys((String) applicationInputJson.get("subscriberEmail"));
        subscribeButton.click();
        Assert.assertTrue(subscribeTextConfirmation.isDisplayed());
        Assert.assertEquals((String) applicationInputJson.get("successSubscriberMessage"),subscribeTextConfirmation.getText());
    }
}