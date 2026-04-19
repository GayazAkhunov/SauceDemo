import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LocatorTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLocators() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement usernameInputCss = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).click();


        // --- Локаторы ---

        // tagName (например, первый <a> на странице)
        WebElement firstLink = driver.findElement(By.tagName("a"));

        // linkText (например, ссылка "Sauce Labs Backpack")
        WebElement backpackLink = driver.findElement(By.linkText("Sauce Labs Backpack"));

        // partialLinkText (например, по части текста)
        WebElement bikelink = driver.findElement(By.partialLinkText("Bike"));

        // XPath

        // Поиск по атрибуту
        WebElement addToCartSauceLabsBikeLight = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']"));

        // Поиск по тексту
        WebElement shoppingCartSpan = driver.findElement(By.xpath("//span[text()='Products']"));

        // Поиск по частичному совпадению атрибута
        WebElement anyAddToCartButton = driver.findElement(By.xpath("//button[contains(@data-test,'add-to-cart')]"));

        // Поиск по частичному совпадению текста
        WebElement anyCartItem = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs')]"));

        // Ancestor: Найти элемент с текстом, затем подняться к предку div
        WebElement ancestorDiv = driver.findElement(By.xpath("//*[text()='Products']//ancestor::div[@data-test='header-container']"));

        // Descendant: Найти div с классом и внутри него span с текстом
        WebElement descendantSpan = driver.findElement(By.xpath("//div[@class='right_component']//descendant::span[text()='Name (A to Z)']"));

        // Following: Найти элемент с текстом, затем следующий за ним button
        WebElement followingButton = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/following::button[@data-test='add-to-cart-sauce-labs-backpack']"));

        // Parent: Найти span, затем подняться к его родителю div
        WebElement parentDiv = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/parent::a[@data-test='item-4-title-link']"));

        // Preceding: Найти элемент, затем предыдущий за ним div
        WebElement precedingDiv = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']/preceding::div[@class='pricebar']"));

        // AND в XPath
        WebElement usernameInputAndType = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ' and@data-test = 'add-to-cart-sauce-labs-backpack']"));


        // --- CSS Selectors ---

        // .class
        WebElement cartLink = driver.findElement(By.cssSelector(".shopping_cart_link"));

        // .class1.class2 (например, если бы был такой элемент)
        WebElement complexClass = driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));

        // .class1 .class2 (поиск потомка)
        WebElement pricebar = driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));

        // tagname
        WebElement allButtons = driver.findElements(By.cssSelector("button")).get(0);

        // tagname.class
        WebElement addToCartButtonCss = driver.findElements(By.cssSelector("button.btn_primary")).get(0);

        // [attribute=value]
        WebElement addToCartSauceLabsBikeLightCss = driver.findElements(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']")).get(0);

        // [attribute*=value] (содержит value)
        WebElement containsSauce = driver.findElements(By.cssSelector("[data-test*='sauce']")).get(0);

    }
}