package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutStep1Test extends BaseTest {

    @Test(
            testName = "Проверка входа с позитивными кредами",
            description = "Проверка входа с позитивными кредами")
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

    @DataProvider(name = "Тестовые данные для негативного чекаута")
    public Object[][] checkoutData(){
        return new Object[][]{
                {"","Akhunov","412304","Error: First Name is required"},
                {"Gayaz","","412304","Error: Last Name is required"},
                {"Gayaz","Akhunov","","Error: Postal Code is required"},
                {"","","","Error: First Name is required"}
        };
    }

    @Test(dataProvider = "Тестовые данные для негативного чекаута")
    public void negativeCheckout(String firstName, String lastName, String zip, String errorMessage) {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        productsPage.clickToCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillForm(firstName,lastName, zip);
        softAssert.assertEquals(checkoutStepTwoPage.getErrorMessage(), errorMessage);
        softAssert.assertAll();
    }
}