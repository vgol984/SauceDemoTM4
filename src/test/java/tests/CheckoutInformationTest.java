package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckoutInformationTest extends BaseTest{
   /* @BeforeTest
    public void goToCheckoutPage(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
    }*/
    @Test(description = "Чекаут без данных пользователя", priority = 2, groups = {"regression"})
    public void continueWithoutCreds(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.continueCheckout();
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: First Name is required");
    }
    @Test(description = "Чекаут без имени пользователя", priority = 3, groups = {"regression"})
    public void continueWithoutFirstName(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("","qwerty","123456");
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: First Name is required");
    }
    @Test(description = "Чекаут без фамилии пользователя", priority = 4, groups = {"regression"})
    public void continueWithoutLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("qwerty", "", "123456");
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: Last Name is required");
    }
    @Test(description = "Чекаут без почтового кода пользователя", priority = 5, groups = {"regression"})
    public void continueWithoutPostalCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("qwerty", "qwerty", "");
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: Postal Code is required");
    }
    @Test(description = "Успешный чекаут", priority = 1, groups = {"smoke"})
    public void continueIsSuccessful() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("qwerty", "qwerty", "123456");
        checkoutInformation.continueCheckout();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Checkout: Overview");
    }
    @Test(description = "Выход со страницы чекаута", priority = 6, groups = {"regression"})
    public void cancelPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.open();
        checkoutInformation.cancelPage();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }
    @Test(description = "Возврат в корзину", priority = 7, groups = {"regression"})
    public void goToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.open();
        checkoutInformation.goToCart();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }
}
