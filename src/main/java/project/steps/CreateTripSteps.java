package project.steps;

import org.junit.Assert;
import project.pages.CreateTripPage;

public class CreateTripSteps {

    CreateTripPage createTripPage = new CreateTripPage();

    public CreateTripSteps checkTitleCreateTrip() {
        createTripPage.checkTitleCreateTrip();
        return this;
    }

    public CreateTripSteps selectSubdivision(String textOption) {
        createTripPage.selectSubdivision(textOption);
        return this;
    }

    public CreateTripSteps selectHostCompany() {
        createTripPage.openSelectHostCompany();
        createTripPage.selectCompanyFromList();
        return this;
    }

    public CreateTripSteps putCheckboxTicketBooking() {
        createTripPage.putCheckboxTicketBooking();
        return this;
    }

    public CreateTripSteps enterCitiesOrDatesOfDepartureArrival(String fieldName, String value) {
        switch (fieldName) {
            case "Город выбытия":
                createTripPage.enterCitiesOfDeparture(value);
                break;
            case "Город прибытия":
                createTripPage.enterCitiesOfArrival(value);
                break;
            case "Дата выезда":
                createTripPage.enterDatesOfDeparture(value);
                break;
            case "Дата возвращения":
                createTripPage.enterDatesOfArrival(value);
                break;
            default:
                Assert.fail("Выбрано не корректно поле ввода!");
        }
        return this;
    }

    public CreateTripSteps clickSaveAndClose() {
        createTripPage.clickSaveAndClose();
        return this;
    }

    public void checkMessageError() {
        createTripPage.checkMessageError();
    }
}
