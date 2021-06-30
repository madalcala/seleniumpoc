package todoly.core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * This class returns the correct instance of the driver.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public final class DriverFactory {
    private static final Map<String, IDriver> DRIVER_MAP = new HashMap<>();
    static {
        DRIVER_MAP.put("chrome", new Chrome());
        DRIVER_MAP.put("firefox", new FireFox());
    }

    /**
     * Private constructor.
     */
    private DriverFactory() { }

    /**
     * Returns a WebDriver object associated to a given browser.
     *
     * @param browser String holding the name of the browser to be used. Currently it supports the following
     *                values:
     *                Chrome
     *                Firefox
     * @return a WebDriver object that makes it possible to connect to a webserver and perform requests via its UI
     * elements.
     */
    public static WebDriver getDriver(final String browser) {
        return DRIVER_MAP.get(browser.toLowerCase()).initDriver();
    }
}
