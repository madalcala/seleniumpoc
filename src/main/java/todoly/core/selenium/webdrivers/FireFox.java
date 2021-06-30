package todoly.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class handles FireFox driver initialization.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class FireFox implements IDriver {

    /**
     * Initializes FireFox driver.
     * @return A new FireFoxDriver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

        //Todo Add more code here to set the profile, etc.
        return new FirefoxDriver();
    }
}
