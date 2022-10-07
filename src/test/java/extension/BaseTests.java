package extension;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import project.manager.DriverManager;
import project.manager.InitManager;

import java.util.Properties;

import static project.properties.TestProperties.getInstance;

public class BaseTests {

    private final DriverManager driverManager = DriverManager.getDriverManager();
    private final Properties properties = getInstance().getProperties();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getWebDriver().get(properties.getProperty("HOSTNAME"));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }

}
