package project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.manager.DriverManager;

import java.util.Properties;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static project.properties.TestProperties.getInstance;

public class BasePage {

    private static final Properties properties = getInstance().getProperties();
    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(
            driverManager.getWebDriver(),
            Integer.parseInt(properties.getProperty("TIME_EXPLICIT_WAIT")),
            Integer.parseInt(properties.getProperty("TIME_EXPLICIT_SLEEP_IN_MILLS")));

    @FindBy(xpath = "//div[contains(@class, 'loader-mask')]//*[contains(text(), 'Загрузка...')]")
    private WebElement msgLoader;

    public BasePage() {
        // Инициализация драйвера для всех методов без объявления
        initElements(driverManager.getWebDriver(), this);
    }

    public void waitUntilVisibilityOf(WebElement element) {
        // Явное ожидание - когда элемент станет видимым
        wait.until(visibilityOf(element));
    }

    public void waitUntilInvisibilityOf(WebElement element) {
        // Явное ожидание - когда элемент станет не видимым
        wait.until(invisibilityOfAllElements(element));
    }

     public void enterValueIntoInputAndCheck(String fieldName, WebElement element, String value) {
         // Заполнение полей типа Input + проверка
         element.clear();
         element.sendKeys(value);
         Assert.assertEquals(String.format("%s заполнен(-а) не верно!", fieldName), value, element.getAttribute("value"));
     }

    public void selectOptionByVisibleText(WebElement elementSelect, String textOption) {
        // Переключить элемент типа Select по названию отображаемой опции
        Select dropdown = new Select(elementSelect);
        dropdown.selectByVisibleText(textOption);
    }

    public void isDisplayed(String message, WebElement element) {
        // Проверка. Элемент отображается
        Assert.assertTrue(String.format("Элемент '%s' - не отображается", message), element.isDisplayed());
    }

    public void isSelected(String message, WebElement element) {
        // Проверка. Элемент выбран/зажат
        Assert.assertTrue(String.format("Элемент '%s' - не выбран", message), element.isSelected());
    }

    public void isContainsText(String textContains, WebElement element) {
        // Проверка. Элемент содержит указанный текст
        Assert.assertEquals("Текст элемента не совпадает", textContains, element.getText());
    }

    public void loading() {
        // Ожидание появления и исчезновения окна "Загрузка..."
        this.waitUntilVisibilityOf(msgLoader);
        this.waitUntilInvisibilityOf(msgLoader);
    }
}
