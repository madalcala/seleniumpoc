package runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;
import todoly.app.config.UserConfig;
import todoly.core.selenium.WebDriverManager;

/**
 * This class handles the Runner class for the test.
 *
 * @author Maday Alcala
 * @since 06/28/2021
 */
public class RunCuckesTest extends AbstractTestNGCucumberTests {
    private Logger log = Logger.getLogger(getClass());

    /**
     * Starts the execution.
     */
    @BeforeTest
    public void beforeExecution() {
        PropertyConfigurator.configure("log.properties");
        UserConfig.getInstance().initialize();
        log.info("-----Start Automation execution-----");
    }

    /**
     * AfterExecution close the driver.
     */
    @AfterTest
    public void afterExecution() {
        log.info("-----Ends Automation execution-----");
        WebDriverManager.getInstance().quitDriver();
    }
}
