package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class CheckoutStep1Test extends BaseTest {

    @Test
    public void checkoutWithPositive() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("Gayaz", "Akhunov", "412304");
        softAssert.assertEquals(checkoutStepTwoPage.getTitle(), "Checkout: Overview");
        softAssert.assertAll();
    }

    @Test
    public void checkoutWithEmptyFirstName() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("", "Akhunov", "412304");
        softAssert.assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: First Name is required");
        softAssert.assertAll();
    }

    @Test
    public void checkoutWithEmptyLastName() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("Gayaz", "", "412304");
        softAssert. assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: Last Name is required");
        softAssert.assertAll();
    }

    @Test
    public void checkoutWithEmptyZip() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("Gayaz", "Akhunov", "");
        softAssert.assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: Postal Code is required");
        softAssert.assertAll();
    }

    @Test
    public void checkoutWithEmptyFields() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm("", "", "");
        softAssert.assertEquals(checkoutStepTwoPage.getErrorMessage(), "Error: First Name is required");
        softAssert.assertAll();
    }
}