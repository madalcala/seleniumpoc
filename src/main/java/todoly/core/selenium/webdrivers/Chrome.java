package todoly.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * This class handles Chrome driver initialization.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class Chrome implements IDriver {

    /**
     * Initializes Chrome driver.
     * @return A new ChromeDriver.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        return new ChromeDriver(chromeOptions);
    }
}
