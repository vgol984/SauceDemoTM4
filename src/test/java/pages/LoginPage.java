package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[.error-button]");

    public void open(){
        driver.get("https://www.saucedemo.com/");
    }

    public void login(){
        driver.findElement(LOGIN_FIELD).sendKeys("standard_user");
        driver.findElement(PASSWORD_FIELD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }
}

