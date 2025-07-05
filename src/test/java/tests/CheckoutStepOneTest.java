package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckoutStepOneTest extends BaseTest{

    @Test
    public void continueWithoutCreds(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.continueCheckout();
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void continueWithoutFirstName(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.checkoutInformation("","qwerty","123456");
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void continueWithoutLastName() {
        checkoutStepOnePage.open();
        checkoutStepOnePage.checkoutInformation("qwerty", "", "123456");
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void continueWithoutPostalCode() {
        checkoutStepOnePage.open();
        checkoutStepOnePage.checkoutInformation("qwerty", "qwerty", "");
        softAssert.assertEquals(checkoutStepOnePage.getErrorMessage(), "Error: Postal Code is required");
    }

    @Test
    public void continueIsSuccessful() {
        checkoutStepOnePage.open();
        checkoutStepOnePage.checkoutInformation("qwerty", "qwerty", "123456");
        checkoutStepOnePage.continueCheckout();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Checkout: Overview");
    }

    @Test
    public void cancelPage() {
        checkoutStepOnePage.open();
        checkoutStepOnePage.cancelPage();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }

    @Test
    public void goToCart() {
        checkoutStepOnePage.open();
        checkoutStepOnePage.goToCart();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Your Cart");
    }
}
