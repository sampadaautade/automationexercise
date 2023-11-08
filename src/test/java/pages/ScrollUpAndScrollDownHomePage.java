package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

import static setup.BaseSetup.*;
import static setup.BaseSetup.applicationInputJson;

public class ScrollUpAndScrollDownHomePage {

    public ScrollUpAndScrollDownHomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/']")
    private WebElement homePage;

    @FindBy(id = "scrollUp")
    WebElement scrollUpButton;

    @FindBy(xpath = "(//h2[contains(text(),'Full-Fledged practice website for Automation Engin')])[1]")
    WebElement homePageTextConfirmation;

    public  void scrollUpWithArrowAndScrollDownFunctionality()  {
        Assert.assertTrue(homePage.isDisplayed());
        getJavascriptExecutor().executeScript((String) applicationInputJson.get("scrolledDown"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        scrollUpButton.click();
        System.out.println("Home Page Confirmation : " + homePageTextConfirmation.getText());
        Assert.assertEquals((String) applicationInputJson.get("homePageMessageVerification"),homePageTextConfirmation.getText());

    }

    public void scrollUpWithoutArrowAndScrollDown(){
        Assert.assertTrue(homePage.isDisplayed());
        //Scroll down till the bottom of the page
        getJavascriptExecutor().executeScript((String) applicationInputJson.get("scrolledDown"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Scroll up till the top of the page
        getJavascriptExecutor().executeScript((String) applicationInputJson.get("scrolledUp"));
        Assert.assertEquals((String) applicationInputJson.get("homePageMessageVerification"),homePageTextConfirmation.getText());
    }

}