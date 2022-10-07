package project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement formAuth;

    @FindBy(xpath = "//*[@name='_username']")
    private WebElement loginAuth;

    @FindBy(xpath = "//*[@name='_password']")
    private WebElement passwordAuth;

    @FindBy(id = "_submit")
    private WebElement btnAuth;

    @Step("Ожидание загрузки страницы и ввод логина='{login}' и пароля='{password}'")
    public void enterLoginPassword(String login, String password) {
        // Ожидание загрузки страницы и ввод логина/пароля
        this.waitUntilVisibilityOf(formAuth);
        loginAuth.sendKeys(login);
        passwordAuth.sendKeys(password);
    }

    @Step("Нажать на кнопку 'Авторизоваться'")
    public void clickSubmit() {
        // Нажать на кнопку "Авторизоваться"
        btnAuth.click();
    }
}
