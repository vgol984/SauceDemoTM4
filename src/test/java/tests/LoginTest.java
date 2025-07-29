package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test(description = "Проверка входа в систему без пароля")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Goulubnichiy V.V.")
    @Link("https://www.saucedemo.com/")
    @Description("Проверка, что пользователь не может войти без пароля")
    public void checkLoginWithoutPassword(){
        loginPage.open();
        loginPage.login("user-name", "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "сообщение об ошибке не соответствует ожидаемому");
    }

    @Test(description = "Успешная авторизация", priority = 1, groups = {"smoke"})
    public void checkLogin(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test (dataProvider = "LoginData", description = "Авторизация с неверными данными", priority = 2, groups = {"regression"})
    public void checkLoginWithNegativeValue1(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует ожидаемому");
    }

}
