package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductsPage extends BasePage{
    WebDriver driver = new ChromeDriver();
    private final By TITLE = By.className("title");
    private final By ADD_TO_CART_T_SHIRT = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By CART_BUTTON = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы товаров")
    public void open(){
        driver.get(BASE_URL + "/inventory.html");
    }
    public boolean isPageOpened(){
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Добавить в корзину товар: Sauce Labs Bolt T-Shirt")
    public void addToCartTShirt(){
        driver.findElement(ADD_TO_CART_T_SHIRT).click();
    }

    @Step("Перейти в корзину")
    public void goToCart(){
        driver.findElement(CART_BUTTON).click();
    }

}
