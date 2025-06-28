import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocatorTest {

    @Test
    public void checkLocators() {

        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Переходим на основную страницу, чтобы после логина сразу ввести все нужные локаторы
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Список локаторов
        driver.findElement(By.id("react-burger-menu-btn"));
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.className("primary_header"));
        driver.findElement(By.tagName("span"));
        driver.findElement(By.linkText("LinkedIn"));
        driver.findElement(By.partialLinkText("Link"));
        driver.findElement(By.xpath("//div[@class='app_logo']"));
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("//div[contains(@data-test, 'inventory')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Swag')]"));
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']/ancestor::*"));
        driver.findElement(By.xpath("//ul[@class='social']/following::*"));
        driver.findElement(By.xpath("//*[text()='Products']/parent::div"));
        driver.findElement(By.xpath("//div[@id='inventory_container']/preceding::*"));
        driver.findElement(By.xpath("//button[@type='button' and @id='react-burger-menu-btn']"));
        driver.findElement(By.cssSelector(".inventory_item"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector(".inventory_item .inventory_item_name"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        driver.findElements(By.cssSelector("a"));
        driver.findElements(By.cssSelector("div.inventory_item"));
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.cssSelector("header_label"));
        driver.findElement(By.cssSelector("button[class~='btn']"));
        driver.findElement(By.cssSelector("html[lang|='en']"));
        driver.findElement(By.cssSelector("div[class^='app']"));
        driver.findElement(By.cssSelector("div[class$='logo']"));
        driver.findElement(By.cssSelector("div[class*='item']"));
    }

}
