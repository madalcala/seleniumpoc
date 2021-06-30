package todoly.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import todoly.core.selenium.webdrivers.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * This class manages the web driver.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class WebDriverManager {
    private Logger log = Logger.getLogger(getClass());
    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private static WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private static WebDriverManager instance = null;

    /**
     * Constructor of page WebDriverManager.
     */
    protected WebDriverManager() {
        initialize();
    }

    /**
     * Singleton instance getter.
     *
     * @return the same instancstatic e for WebDriverManager class.
     */
    public static WebDriverManager getInstance() {
        if (webDriver == null || instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    /**
     * Initializes the settings for the driver.
     */
    private void initialize() {
        log.info("WebDriverManager initialize: Initializing the web driver");
        webDriverConfig.initialize();
        webDriver = DriverFactory.getDriver(webDriverConfig.getBrowser());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime());
    }

    /**
     * Gets the WebDriver.
     *
     * @return WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the WebDriver Wait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }

    /**
     * Closes all the browser instances.
     */
    public void quitDriver() {
        try {
            log.info("Quit driver");
            webDriver.quit();
        } catch (WebDriverException e) {
            log.error("Unable to quit the WebDriver", e);
        } finally {
            webDriver = null;
        }
    }
}
