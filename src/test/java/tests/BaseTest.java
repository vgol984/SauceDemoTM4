package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.CheckoutInformation;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.HashMap;

import static tests.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutInformation checkoutInformation;
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Настройка драйвера")
    public void setup(@Optional ("chrome") String browser, ITestContext iTestContext) {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")){

            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        iTestContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }
    @AfterMethod(alwaysRun = true, description = "Закрытие драйвера")
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(driver);
        }
        driver.quit();
    }
}
