package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutStep1Test extends BaseTest {

    @Test
    public void checkoutWithPositive() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("Gayaz", "Akhunov", "412304");
        assertEquals(checkoutStepTwoPage.getTitle(), "Checkout: Overview");
    }

    @Test
    public void checkoutWithEmptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("", "Akhunov", "412304");
        assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void checkoutWithEmptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("Gayaz", "", "412304");
        assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void checkoutWithEmptyZip() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("Gayaz", "Akhunov", "");
        assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: Postal Code is required");
    }

    @Test
    public void checkoutWithEmptyFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("", "", "");
        assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: First Name is required");
    }
}