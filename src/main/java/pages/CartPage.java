package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class CartPage extends BasePage {
    private final By REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");
    private final By CART_QTY = By.xpath("//*[@data-test='item-quantity']");
    private final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@data-test='continue-shopping']");
    private final By CHECKOUT_BUTTON = By.xpath("//*[@data-test='checkout']");
    private final By CART_ITEM = By.xpath("//*[@data-test='inventory-item-name']");
    private final By CART_PRICE = By.xpath("//*[@data-test='inventory-item-price']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_ITEM));
        return this;
    }

    @Step("Нажимаем кнопку Checkout")
    public CheckoutStepOnePage clickCheckout() {
        log.info("ClickToCheckout");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutStepOnePage(driver);
    }

    public List<WebElement> getItemsInCart() {
        return driver.findElements(CART_ITEM);
    }

    public String cartItemTitle() {
        return driver.findElement(CART_ITEM).getText();
    }

    public String cartItemPrice() {
        return driver.findElement(CART_PRICE).getText();
    }
}