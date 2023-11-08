package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import setup.BaseSetup;

import static setup.BaseSetup.applicationInputJson;

public class SignUpPage {

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li/a/i[contains(@class,'home')]")
    WebElement homePageConfirmation;

    @FindBy(xpath = "//div[contains(@class,'signup-form')]/h2")
    WebElement signupConfirmation;

    @FindBy(xpath = "//p[.='Email Address already exist!']")
    WebElement errorMsgAlreadyExist;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement signUpLink;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailAddress;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;

    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
    WebElement signupPageConfirmation;

    @FindBy(id = "id_gender2")
    WebElement title;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement daysDropdown;

    @FindBy(id = "months")
    WebElement monthsDropdown;

    @FindBy(id = "years")
    WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    WebElement newsLetterBox;

    @FindBy(id = "optin")
    WebElement specialOffersBox;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement companyName;

    @FindBy(id = "address1")
    WebElement addressDetails;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement stateName;

    @FindBy(id = "city")
    WebElement cityName;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    WebElement accountCreationConfirmation;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement userName;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(linkText = "Continue")
    WebElement permanentlyDeletedButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement accountDeleteComfirmation;

    public void userRegistration(JSONObject userRegistration) {
        signUpLink.click();
        name.sendKeys((String) userRegistration.get("name"));
        emailAddress.sendKeys((String) userRegistration.get("emailAddress"));
        signUpButton.click();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", signupPageConfirmation.getText().toUpperCase());
        //signupPageConfirmation.isDisplayed();
        title.click();
        password.sendKeys((String) userRegistration.get("password"));
        Select days = new Select(daysDropdown);
        days.selectByValue((String) userRegistration.get("day"));
        Select months = new Select(monthsDropdown);
        months.selectByVisibleText((String) userRegistration.get("month"));
        Select years = new Select(yearsDropdown);
        years.selectByVisibleText((String) userRegistration.get("year"));
        newsLetterBox.click();
        specialOffersBox.click();
        firstName.sendKeys((String) userRegistration.get("firstName"));
        lastName.sendKeys((String) userRegistration.get("lastName"));
        companyName.sendKeys((String) userRegistration.get("company"));
        addressDetails.sendKeys((String) userRegistration.get("address"));
        address2.sendKeys((String) userRegistration.get("address2"));
        Select countryName = new Select(country);
        countryName.selectByValue((String) userRegistration.get("country"));
        stateName.sendKeys((String) userRegistration.get("state"));
        cityName.sendKeys((String) userRegistration.get("city"));
        zipcode.sendKeys((String) userRegistration.get("zipcode"));
        mobileNumber.sendKeys((String) userRegistration.get("mobileNumber"));
        createButton.click();
        Assert.assertEquals("ACCOUNT CREATED!", accountCreationConfirmation.getText());
        continueButton.click();
        Assert.assertEquals((String) userRegistration.get("name"), userName.getText());

    }

    public void userDeletion(){
        deleteAccountButton.click();
        Assert.assertEquals("ACCOUNT DELETED!",accountDeleteComfirmation.getText().toUpperCase());
        permanentlyDeletedButton.click();
    }

    public void registerWithExistingEmail(JSONObject userLogin){
        Assert.assertTrue(homePageConfirmation.isEnabled());
        signUpLink.click();
        Assert.assertEquals((String) applicationInputJson.get("signUpMessage"),signupConfirmation.getText());
        name.sendKeys((String) userLogin.get("name"));
        emailAddress.sendKeys((String) userLogin.get("email"));
        signUpButton.click();
        Assert.assertEquals((String) applicationInputJson.get("emailExistMessage"),errorMsgAlreadyExist.getText());
    }
}