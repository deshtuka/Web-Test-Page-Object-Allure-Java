package project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement textTitleHeaderBar;

    @FindBy(xpath = "//*[@id='main-menu']/ul/li/a/span[text()='Расходы']")
    private WebElement btnCosts;

    @FindBy(xpath = "//li[@data-route='crm_business_trip_index']//span")
    private WebElement btnTrip;

    @Step("Проверить наличие заголовка 'Панель быстрого запуска'")
    public void checkTitle() {
        // Проверить наличие заголовка "Панель быстрого запуска"
        this.isDisplayed("Панель быстрого запуска", textTitleHeaderBar);
        this.isContainsText("Панель быстрого запуска", textTitleHeaderBar);
    }

    @Step("В выплывающем окне раздела 'Расходы' нажать на 'Командировки'")
    public void clickCostsToTrip() {
        // В выплывающем окне раздела "Расходы" нажать на "Командировки"
        btnCosts.click();
        this.waitUntilVisibilityOf(btnTrip);
        btnTrip.click();
    }

}
