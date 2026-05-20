package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage extends BasePage {

    private final By COMPLETE_HEADER = By.xpath("//h2[@class='complete-header' and contains(text(), 'THANK YOU')]");
    private final By COMPLETE_TEXT = By.xpath("//div[@class='complete-text']");
    private final By PONY_EXPRESS = By.xpath("//img[@alt='Pony Express']");
    private final By BACK_HOME_BUTTON = By.xpath("//a[@class='btn_secondary' and contains(text(), 'BACK HOME')]");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutCompletePage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMPLETE_HEADER));
        return this;
    }

    // Получение текста заголовка (например, "THANK YOU FOR YOUR ORDER")
    public String getCompleteHeaderText() {
        return driver.findElement(COMPLETE_HEADER).getText();
    }

    // Получение основного текста подтверждения
    public String getCompleteText() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }

    // Проверка, что изображение Pony Express отображается
    public boolean isPonyExpressImageDisplayed() {
        return driver.findElement(PONY_EXPRESS).isDisplayed();
    }

    // Нажатие кнопки "BACK HOME" для возврата на главную страницу
    public ProductsPage clickBackHome() {
        driver.findElement(BACK_HOME_BUTTON).click();
        return new ProductsPage(driver);
    }
}