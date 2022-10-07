package project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListAllTripPage extends BasePage {

    @FindBy(xpath = "//div[@class='btn-group']//a[@href='/business-trip/create/']")
    private WebElement btnCreateTrip;

    @Step("Нажать на 'Создать командировку'")
    public void clickButtonCreateTrip() {
        // Нажать на "Создать командировку"
        this.isDisplayed("Создать командировку", btnCreateTrip);
        btnCreateTrip.click();
    }
}
