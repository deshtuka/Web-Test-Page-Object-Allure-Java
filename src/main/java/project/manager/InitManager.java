package project.manager;

import project.manager.DriverManager;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static project.properties.TestProperties.getInstance;

public class InitManager {

    private static final Properties properties = getInstance().getProperties();
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        // Инициализация стартовых настроек: полный экран + ожидания
        driverManager.getWebDriver().manage().window().maximize();
        driverManager.getWebDriver().manage().timeouts().implicitlyWait(
                Integer.parseInt(properties.getProperty("TIME_IMPLICITLY_WAIT")), TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        // Завыершение работы
        driverManager.closeDriver();
    }
}
