package project.steps;

import project.pages.LoginPage;

public class LoginSteps {

    public MainSteps login(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginPassword(login, password);
        loginPage.clickSubmit();
        return new MainSteps();
    }

}
