package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private final By REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");
    private final By CART_QTY = By.xpath("//*[@data-test='item-quantity']");
    private final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@data-test='continue-shopping']");
    private final By CHECKOUT_BUTTON = By.xpath("//*[@data-test='checkout']");
    private final By CART_ITEM = By.xpath("//*[@data-test='inventory-item-name']");
    private final By CART_PRICE = By.xpath("//*[@data-test='inventory-item-price']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Проверка, что страница корзины открыта
    public boolean isPageOpened() {
        return driver.findElement(CART_ITEM).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public List<WebElement> getItemsInCart() {
        return driver.findElements(CART_ITEM);
    }

    // Получение количества товаров в корзине
    public int getCartItemCount() {
        return getItemsInCart().size();
    }

    public String cartItemTitle() {
        return driver.findElement(CART_ITEM).getText();
    }

    public String cartItemPrice() {
        return driver.findElement(CART_PRICE).getText();
    }
}