package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{
    @Test
    public void checkLoginWithoutPassword(){
        loginPage.open();
        loginPage.login("user-name", "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "сообщение об ошибке не соответствует ожидаемому");
    }
    @Test
    public void checkLogin(){
        loginPage.open();
        loginPage.login("user-name", "password");
        assertTrue(productsPage.isPageOpened());
    }
}
