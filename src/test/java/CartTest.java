import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.time.Duration.ofSeconds;

public class CartTest {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.className("btn_action");
    private final By addToCartBackpackButton = By.name("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By cartItemName = By.className("inventory_item_name");
    private final By cartItemPrice = By.className("inventory_item_price");
    private WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void testLoginAddToCartAndVerify() {
        driver.findElement(usernameInput).sendKeys("standard_user");
        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        driver.findElement(addToCartBackpackButton).click();

        driver.findElement(shoppingCartLink).click();

        WebElement nameElement = driver.findElement(cartItemName);
        WebElement priceElement = driver.findElement(cartItemPrice);

        String actualName = nameElement.getText();
        String actualPrice = priceElement.getText();

        String expectedName = "Sauce Labs Backpack";
        String expectedPrice = "$29.99";

        Assert.assertEquals(actualName, expectedName,
                "Ошибка: Название товара в корзине не совпадает с ожидаемым.");

        Assert.assertEquals(actualPrice, expectedPrice,
                "Ошибка: Цена товара в корзине не совпадает с ожидаемой.");

        System.out.println("Тест успешно завершен!");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}