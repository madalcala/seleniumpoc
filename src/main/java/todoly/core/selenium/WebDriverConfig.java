package todoly.core.selenium;

import todoly.app.config.UserConfig;
import todoly.core.utils.PropertyReader;

/**
 * This class manages the config of web driver.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public final class WebDriverConfig {
    private static WebDriverConfig instance;
    private final String defaultBrowserConfigFile = "browser.properties";
    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;

    /**
     * Singleton private constructor.
     */
    private WebDriverConfig() {
        initialize();
    }

    /**
     * Singleton instance getter.
     *
     * @return the same instance for this class.
     */
    static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    /**
     * Initial actions to be performed when instantiating WebDriverConfig for the first class.
     */
    public void initialize() {
        PropertyReader.loadFile(defaultBrowserConfigFile);
        browser = System.getProperty("browser");
        implicitWaitTime = Integer.parseInt(PropertyReader.retrieveField("implicitWaitTime"));
        explicitWaitTime = Integer.parseInt(PropertyReader.retrieveField("explicitWaitTime"));
        UserConfig.getInstance().initialize();
    }

    /**
     * Returns the browser member of this class.
     *
     * @return a String holding the name of the browser the driver will be configured to work with.
     */

    public String getBrowser() {
        return browser;
    }

    /**
     * The period of time configured for Selenium implicit waits.
     *
     * @return a integer value representing the Selenium implicit wait value.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * The period of time configured for Selenium explicit wait.
     *
     * @return a integer value representing the Selenium explicit wait value.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }
}
