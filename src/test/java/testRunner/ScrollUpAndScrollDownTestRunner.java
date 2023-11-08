package testRunner;

import org.testng.annotations.Test;
import pages.ScrollUpAndScrollDownHomePage;
import pages.Subscription;
import setup.BaseSetup;


public class ScrollUpAndScrollDownTestRunner extends BaseSetup {

    ScrollUpAndScrollDownHomePage homePageScrollFunctionality;

    @Test(priority = 1, description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void scrollUpWithArrowAndScrollDownFunctionality(){
        homePageScrollFunctionality =new ScrollUpAndScrollDownHomePage(driver);
        homePageScrollFunctionality.scrollUpWithArrowAndScrollDownFunctionality();
    }

    @Test(priority = 1, description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void scrollUpAndScrollDownFunctionality(){
        homePageScrollFunctionality =new ScrollUpAndScrollDownHomePage(driver);
        homePageScrollFunctionality.scrollUpWithoutArrowAndScrollDown();
    }

}