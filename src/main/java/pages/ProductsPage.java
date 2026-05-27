package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Log4j2
public class ProductsPage extends BasePage {
    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By CART_ITEM = By.xpath("//*[@data-test='cart_item']");
    private final By ADD_TO_CART_BACKPACK = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    private final By ADD_TO_CART_BUTTONS = By.xpath("//button[text()='Add to cart']");
    private final By SHOPPING_CART_LINK = By.xpath("//*[@data-test='shopping-cart-link']");
    private final By SORT_DROPDOWN = By.xpath("//*[@data-test='product_sort_container']");
    private final By ITEM_NAME = By.xpath("//*[@data-test='inventory_item_name']");
    private final By ITEM_PRICE = By.xpath("//*[@data-test='inventory_item_price']");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавляем в корзину товар - '{product}'")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    public CartPage clickToCart() {
        log.info("Click to cart");
        driver.findElement(SHOPPING_CART_LINK).click();
        return new CartPage(driver);
    }
}