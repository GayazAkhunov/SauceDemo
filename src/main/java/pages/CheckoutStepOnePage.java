package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Log4j2
public class CheckoutStepOnePage extends BasePage {

    private final By FIRST_NAME_FIELD = By.xpath("//*[@data-test='firstName']");
    private final By LAST_NAME_FIELD = By.xpath("//*[@data-test='lastName']");
    private final By POSTAL_CODE = By.xpath("//*[@data-test='postalCode']");
    private final By CANCEL_BUTTON = By.xpath("//*[@data-test='cancel']");
    private final By CONTINUE_BUTTON = By.xpath("//*[@data-test='continue']");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutStepOnePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_FIELD));
        return this;
    }

    public CheckoutStepOnePage fillForm(String firstName, String lastName, String zip) {
        log.info("Fill checkout form with fields: '{}','{}', '{}'", firstName, lastName, zip);
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public CartPage clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CartPage(driver);
    }
}