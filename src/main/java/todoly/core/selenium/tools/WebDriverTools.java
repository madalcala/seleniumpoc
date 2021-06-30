package todoly.core.selenium.tools;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import todoly.core.selenium.WebDriverManager;

/**
 * This class manages web driver tools.
 *
 * @author Maday Alcala
 * @since 06/28/2021
 */
public class WebDriverTools {
    private WebDriverWait wait;
    private Logger log;

    /** Constructor for WebDriverTools. */
    public WebDriverTools() {
        log = Logger.getLogger(getClass());
        this.wait = WebDriverManager.getInstance().getWait();
    }

    /**
     * Waits and clear the WebElement.
     *
     * @param webElement - WebElement to wait and clear.
     */
    private void clearTextField(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * Sets an Input Field.
     *
     * @param webElement - Input WebElement.
     * @param text - Text to fill.
     */
    public void setInputField(final WebElement webElement, final String text) {
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    /**
     * Waits and click on the WebElement.
     *
     * @param webElement - WebElement to wait and click.
     */
    public void clickElement(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Verifies if a WebElement is displayed.
     *
     * @param webElement - WebElement to verify if its displayed.
     * @return true if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }
}
