package project.steps;

import project.pages.ListAllTripPage;

public class ListAllTripSteps {

    public CreateTripSteps clickCreate() {
        ListAllTripPage listAllTripPage = new ListAllTripPage();
        listAllTripPage.clickButtonCreateTrip();
        listAllTripPage.loading();
        return new CreateTripSteps();
    }

}
