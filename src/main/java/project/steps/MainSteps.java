package project.steps;

import project.pages.MainPage;

public class MainSteps {

    public ListAllTripSteps goToTrip() {
        MainPage mainPage = new MainPage();
        mainPage.checkTitle();
        mainPage.clickCostsToTrip();
        mainPage.loading();
        return new ListAllTripSteps();
    }

}
