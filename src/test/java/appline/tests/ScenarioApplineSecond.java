package appline.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import project.steps.LoginSteps;

import java.util.Properties;

import extension.BaseTests;

import static project.properties.TestProperties.getInstance;

public class ScenarioApplineSecond extends BaseTests {

    private final LoginSteps loginSteps = new LoginSteps();
    private final Properties properties = getInstance().getProperties();

    @Test
    @DisplayName("Проверка создания командировки (негативный)")
    public void testScenarioSecond() {
        loginSteps
                .login(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"))
                .goToTrip()
                .clickCreate()
                .checkTitleCreateTrip()
                .selectSubdivision("Отдел внутренней разработки")
                .selectHostCompany()
                .putCheckboxTicketBooking()
                .enterCitiesOrDatesOfDepartureArrival("Город выбытия", "Россия, Санкт-Петербург")
                .enterCitiesOrDatesOfDepartureArrival("Город прибытия", "Россия, Владивосток")
                .enterCitiesOrDatesOfDepartureArrival("Дата выезда","01.01.2022")
                .enterCitiesOrDatesOfDepartureArrival("Дата возвращения","02.02.2022")
                .clickSaveAndClose()
                .checkMessageError();
    }
}
