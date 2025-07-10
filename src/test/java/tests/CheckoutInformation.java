package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckoutInformation extends BaseTest{
   /* @BeforeTest
    public void goToCheckoutPage(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
    }*/
    @Test
    public void continueWithoutCreds(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.continueCheckout();
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: First Name is required");
    }
    @Test
    public void continueWithoutFirstName(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("","qwerty","123456");
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: First Name is required");
    }
    @Test
    public void continueWithoutLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("qwerty", "", "123456");
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: Last Name is required");
    }
    @Test
    public void continueWithoutPostalCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("qwerty", "qwerty", "");
        softAssert.assertEquals(checkoutInformation.getErrorMessage(), "Error: Postal Code is required");
    }
    @Test
    public void continueIsSuccessful() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.checkoutInformation("qwerty", "qwerty", "123456");
        checkoutInformation.continueCheckout();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Checkout: Overview");
    }
    @Test
    public void cancelPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.open();
        checkoutInformation.cancelPage();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }
    @Test
    public void goToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutInformation.open();
        checkoutInformation.goToCart();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }
}
