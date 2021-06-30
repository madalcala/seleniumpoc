package todoly.app.ui.todoly;

import org.openqa.selenium.WebDriver;
import todoly.core.selenium.WebDriverManager;
import todoly.core.utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

/**
 * This class handles the navigation between pages.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public final class PageTransporter {
    private static Map<String, String> map = new HashMap<>();
    private static final String APP_CONFIG_FILE = "app.properties";
    private static final String URL_BASE = "url";
    private static WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

    /**
     * This is the empty constructor according to checkstyle.
     */
    private PageTransporter() {
    }

    /**
     * This method is used for go to a page.
     */
    public static void goToUrl() {
        webDriver.navigate().to(getBaseUrl());
    }

    /**
     * Returns a String containing the base url of the web application.
     *
     * @return a String containing the root URI of the web application under test.
     */
    public static String getBaseUrl() {
        PropertyReader.loadFile(APP_CONFIG_FILE);
        return PropertyReader.retrieveField(URL_BASE);
    }
}
