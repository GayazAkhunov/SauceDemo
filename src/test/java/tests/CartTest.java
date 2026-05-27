package tests;


import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(
            testName = "Проверка добавления товара в корзину",
            description = "Проверка добавления товара в корзину")
    @Description("Проверка добавления товара в корзину")
    @Epic("E2E")
    @Feature("Login into SauceDemo")
    @Severity(SeverityLevel.CRITICAL)
    @Link
    @TmsLink("ITM5")
    @Issue("ITM5")
    public void addToCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open()
                .login("standard_user", "secret_sauce")
                        .addToCart("Sauce Labs Backpack")
                                .clickToCart();
        softAssert.assertEquals(cartPage.cartItemTitle(), "Sauce Labs Backpack");
        softAssert.assertEquals(cartPage.cartItemPrice(), "$29.99");
        softAssert.assertAll();
    }
}