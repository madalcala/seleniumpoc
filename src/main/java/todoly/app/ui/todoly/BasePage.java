package todoly.app.ui.todoly;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import todoly.core.selenium.WebDriverManager;
import todoly.core.selenium.tools.WebDriverTools;

/**
 * This class handles Base Page.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverTools driverTools;

    /**
     * Initializes the web driver, wait and web elements.
     */
    public BasePage() {
        this.driver = WebDriverManager.getInstance().getWebDriver();
        this.wait = WebDriverManager.getInstance().getWait();
        this.driverTools = new WebDriverTools();
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    /**
     * Waits until page object is loaded.
     */
    public abstract void waitUntilPageObjectIsLoaded();
}
