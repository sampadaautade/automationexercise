package testRunner;

import org.testng.annotations.Test;
import pages.SignUpPage;
import setup.BaseSetup;

public class UserRegistrationTestRunner extends BaseSetup {

    SignUpPage signUp;
    @Test(priority = 1, description = "Test Case 1: Register User")
    public void userRegistration() {
        signUp = new SignUpPage(driver);
        signUp.userRegistration(userRegisterJson);
       // signUp.userDeletion();
    }

    @Test(priority = 2, description = "Test Case 5: Register User with existing email")
    public void registerWithExistingEmail(){
        signUp = new SignUpPage(driver);
        signUp.registerWithExistingEmail(userLoginJson);
    }

}