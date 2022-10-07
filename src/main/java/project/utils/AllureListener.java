package project.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import project.manager.DriverManager;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) {
        // Создание скриншота
        getSrceenshot();

        // Остальное выполнение функции
        super.testFailure(failure);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getSrceenshot() {
        return ((TakesScreenshot) DriverManager.getDriverManager().getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
