package testRunner;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import setup.BaseSetup;

public class ContactUsTestRunner extends BaseSetup {
    ContactUsPage contactUs;

    @Test(priority = 1, description = "Test Case 6: Contact Us Form")
    public void ContactUsForm(){
        contactUs=new ContactUsPage(driver);
        contactUs.contactUsForm(contactUsJson);
    }

}