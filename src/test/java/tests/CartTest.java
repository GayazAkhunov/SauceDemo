package tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(
            testName = "Проверка добавления товара в корзину",
            description =
                    "a. Залогиниться" +
                    "b. Добавить товар в корзину" +
                    "c. Перейти в корзину" +
                    "d. Проверить (assertEquals) стоимость товара и его имя в корзине")
    public void addToCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addFirstProductToCart();
        productsPage.clickToCart();
        softAssert.assertEquals(cartPage.cartItemTitle(), "Sauce Labs Backpack");
        softAssert.assertEquals(cartPage.cartItemPrice(), "$29.99");
        softAssert.assertAll();
    }
}