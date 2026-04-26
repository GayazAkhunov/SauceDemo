package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {

    private final By FIRST_NAME_FIELD = By.xpath("//*[@data-test='firstName']");
    private final By LAST_NAME_FIELD = By.xpath("//*[@data-test='lastName']");
    private final By POSTAL_CODE = By.xpath("//*[@data-test='postalCode']");
    private final By CANCEL_BUTTON = By.xpath("//*[@data-test='cancel']");
    private final By CONTINUE_BUTTON = By.xpath("//*[@data-test='continue']");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String firstName, String lastName, String zip) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public CartPage clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CartPage(driver);
    }
}