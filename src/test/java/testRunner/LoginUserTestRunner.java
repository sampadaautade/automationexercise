package testRunner;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.LoginUserPage;
import setup.BaseSetup;

public class LoginUserTestRunner extends BaseSetup {
LoginUserPage loginPage;


    @Test(priority = 1, description = "Test Case 2: Login User with correct email and password")
    public void loginUsingValidCredential(){
        loginPage=new LoginUserPage(driver);
        loginPage.loginUsingValidCredential(userLoginJson);
    }
    @Test(priority = 2, description = "Test Case 3: Login User with incorrect email and password")
    public void loginUserWithInvalidCredential(){
        loginPage=new LoginUserPage(driver);
        loginPage.loginUserWithInvalidCredential(invalidUserJson);
    }
    @Test(priority = 3, description = "Test Case 4: Logout User")
    public void logout(){
        loginPage=new LoginUserPage(driver);
        loginPage.loginUsingValidCredential(userLoginJson);
        loginPage.logoutUser();
    }

}
