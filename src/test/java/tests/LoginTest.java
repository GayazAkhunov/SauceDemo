package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(
            testName = "Проверка входа с позитивными кредами",
            description = "Проверка входа с позитивными кредами")
    @Description("Проверка входа с позитивными кредами")
    @Epic("E2E")
    @Feature("Login into SauceDemo")
    @Severity(SeverityLevel.CRITICAL)
    public void checkLoginWithPositive() {
        loginPage.open();
        AllureUtils.takeScreenshot(driver);
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name = "Тестовые данные для негативного логина")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"test","test","Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Тестовые данные для негативного логина")
    @Description("Проверка входа с негативными кредами")
    public void negativeLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}