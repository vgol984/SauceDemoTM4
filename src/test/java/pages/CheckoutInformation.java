package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformation extends BasePage {
    private final By TITLE = By.className("title");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By ERROR_MESSAGE = By.className("error-message-container error");
    private final By CANCEL_BUTTON = By.id("cancel");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By SHOPPING_CART_BUTTON = By.id("shopping_cart_container");
    public CheckoutInformation(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы проверки данных")
    public void open(){
        driver.get(BASE_URL + "/checkout-step-one.html");
        driver.findElement(TITLE).isDisplayed();
    }
    /*public boolean isPageOpened(){
        return driver.findElement(TITLE).isDisplayed();
    }*/

    @Step("Отправка пользовательских данных: имя: {firstName}, фамилия: {lastName}, почтовый индекс: {postalCode}")
    public void checkoutInformation(String firstName, String lastName, String postalCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Покинуть страницу")
    public void cancelPage(){
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Продолжить оформление заказа")
    public void continueCheckout(){
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Перейти обратно в корзину")
    public void goToCart(){
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }
}
