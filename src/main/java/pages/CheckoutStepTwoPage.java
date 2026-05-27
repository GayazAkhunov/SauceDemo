package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Log4j2
public class CheckoutStepTwoPage extends BasePage {
    private final By TITLE = By.xpath("//*[@data-test='title']");
    private final By FINISH_BUTTON = By.xpath("//button[text()='FINISH']");
    private final By CANCEL_BUTTON = By.xpath("//*[@data-test='cancel']");
    private final By ITEM_NAME = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name']");
    private final By ITEM_PRICE = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_price']");
    private final By SUBTOTAL = By.xpath("//div[@class='summary_subtotal_label']");
    private final By TAX = By.xpath("//div[@class='summary_tax_label']");
    private final By TOTAL = By.xpath("//div[@class='summary_total_label']");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutStepTwoPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    // Нажатие кнопки "FINISH"
    public CheckoutCompletePage clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }

    // Нажатие кнопки "CANCEL"
    public CartPage clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CartPage(driver);
    }

    // Получение названия товара в корзине на этом шаге
    public String getItemName(int index) {
        return driver.findElements(ITEM_NAME).get(index).getText();
    }

    // Получение цены товара в корзине на этом шаге
    public String getItemPrice(int index) {
        return driver.findElements(ITEM_PRICE).get(index).getText();
    }

    // Получение текста подытога (Subtotal)
    public String getSubtotal() {
        return driver.findElement(SUBTOTAL).getText();
    }

    // Получение текста налога (Tax)
    public String getTax() {
        return driver.findElement(TAX).getText();
    }

    // Получение итоговой суммы (Total)
    public String getTotal() {
        return driver.findElement(TOTAL).getText();
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}