package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutStepOneTest extends BaseTest{

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
        checkoutStepOnePage.continueCheckout();
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void continueWithoutFirstName(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.checkoutInformation("","qwerty","123456");
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void continueWithoutLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.checkoutInformation("qwerty", "", "123456");
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void continueWithoutPostalCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.checkoutInformation("qwerty", "qwerty", "");
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: Postal Code is required");
    }

    @Test
    public void continueIsSuccessful() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.checkoutInformation("qwerty", "qwerty", "123456");
        checkoutStepOnePage.continueCheckout();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Checkout: Overview");
    }

    @Test
    public void cancelPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.open();
        checkoutStepOnePage.cancelPage();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }

    @Test
    public void goToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector("data-test=shopping-cart-link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.open();
        checkoutStepOnePage.goToCart();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }
}
