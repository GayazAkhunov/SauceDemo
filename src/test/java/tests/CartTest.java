package tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void addToCart() throws InterruptedException {
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