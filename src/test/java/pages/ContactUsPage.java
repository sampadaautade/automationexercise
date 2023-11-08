package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import setup.BaseSetup;

import java.io.File;

public class ContactUsPage {
    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li/a/i[contains(@class,'home')]")
    WebElement homePageConfirmation;
    @FindBy(xpath = "//li[8]/a")
    WebElement contactUsIcon;
    @FindBy(xpath = "//h2[.='Get In Touch']")
    WebElement getInTouchConfirmation;
    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "email")
    WebElement emailId;
    @FindBy(name = "subject")
    WebElement subjectBox;
    @FindBy(id = "message")
    WebElement messageBox;
    @FindBy(name = "upload_file")
    WebElement uploadFileInput;
    @FindBy(name = "submit")
    WebElement submitButton;
    @FindBy(css = ".status.alert.alert-success")
    private WebElement alertSuccess;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homePageButton;

    public void contactUsForm(JSONObject contactUsJson){
        Assert.assertTrue(homePageConfirmation.isEnabled());
        contactUsIcon.click();
        Assert.assertEquals("GET IN TOUCH",getInTouchConfirmation.getText().toUpperCase());
        name.sendKeys((String) contactUsJson.get("name"));
        emailId.sendKeys((String) contactUsJson.get("email"));
        subjectBox.sendKeys((String) contactUsJson.get("subject"));
        messageBox.sendKeys((String) contactUsJson.get("message"));
        File file = new File((String) contactUsJson.get("fileUploadPath"));
        uploadFileInput.sendKeys(file.getAbsolutePath());
        submitButton.click();
        BaseSetup.driver.switchTo().alert().accept();
        Assert.assertEquals(alertSuccess.getText(), "Success! Your details have been submitted successfully.");
        homePageButton.click();
        Assert.assertTrue(homePageConfirmation.isEnabled());
    }
}