package todoly.core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;

/**
 * This class initialize the Selenium web driver.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
interface IDriver {

    /**
     * Initialize web driver.
     *
     * @return Instance of Driver.
     */
    WebDriver initDriver();
}
