package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @Test
    public void addToCartTest() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        softAssert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Bolt T-Shirt");
        softAssert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$15.99");
        softAssert.assertAll();
    }
}