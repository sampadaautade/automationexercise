package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import java.time.Duration;

public class BaseSetup {
    public static WebDriver driver;
    public static SoftAssert softAssert;
    public static JSONObject userRegisterJson = Utils.loadJsonFile("./src/test/resources/userRegistration.json");
    public static JSONObject userLoginJson = Utils.loadJsonFile("./src/test/resources/userLogin.json");
    public static JSONObject paymentDetailsJson = Utils.loadJsonFile("./src/test/resources/paymentDetails.json");
    public static JSONObject poloBrandProductsJson = Utils.loadJsonFile("./src/test/resources/poloBrandProducts.json");
    public static JSONObject madameBrandProductsJson = Utils.loadJsonFile("./src/test/resources/madameBrandProducts.json");
    public static JSONObject invalidUserJson = Utils.loadJsonFile("./src/test/resources/invalidUserLogin.json");
    public static JSONObject contactUsJson = Utils.loadJsonFile("./src/test/resources/contactUs.json");

    public static final String expectedFileName = "invoice.txt";
    public static final String downloadPath="C:/Users/ashis/Downloads";
    public static JSONObject applicationInputJson = Utils.loadJsonFile("./src/test/resources/applicationInput.json");

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("load-extension=" + "C:\\Users\\ashis\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.52.2_0");
        chromeOptions.addArguments("download.default_directory",downloadPath);
        WebDriverManager.chromedriver().capabilities(chromeOptions).setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");
    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    public static JavascriptExecutor getJavascriptExecutor(){
        return (JavascriptExecutor) driver;
    }
}