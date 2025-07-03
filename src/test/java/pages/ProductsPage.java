package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    WebDriver driver;
    private final By TITLE = By.className("title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL + "/inventory.html");
    }

    public boolean isPageOpened(){
        return driver.findElement(TITLE).isDisplayed();
    }
}
