package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By CART_ITEM = By.xpath("//*[@data-test='cart_item']");
    private final By ADD_TO_CART_BACKPACK = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    private final By ADD_TO_CART_BUTTONS = By.xpath("//button[text()='Add to cart']");
    private final By SHOPPING_CART_LINK = By.xpath("//*[@data-test='shopping-cart-link']");
    private final By SORT_DROPDOWN = By.xpath("//*[@data-test='product_sort_container']");
    private final By ITEM_NAME = By.xpath("//*[@data-test='inventory_item_name']");
    private final By ITEM_PRICE = By.xpath("//*[@data-test='inventory_item_price']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    // Сортировка товаров (например: "Name (A to Z)", "Price (low to high)")
    public void sortItems(String sortOption) {
        WebElement sortDropdown = driver.findElement(SORT_DROPDOWN);
        sortDropdown.click();

        // Выбор опции сортировки
        String xpath = String.format("//option[text()='%s']", sortOption);
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public void addToCart() {
        driver.findElement(ADD_TO_CART_BACKPACK).click();
    }

    public void addFirstProductToCart() {
        List<WebElement> buttons = driver.findElements(ADD_TO_CART_BUTTONS);
        if (!buttons.isEmpty()) buttons.get(0).click();
    }

    public void clickToCart() {
         driver.findElement(SHOPPING_CART_LINK).click();
    }
}