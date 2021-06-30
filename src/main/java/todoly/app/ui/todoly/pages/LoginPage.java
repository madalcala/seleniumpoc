package todoly.app.ui.todoly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import todoly.app.ui.todoly.BasePage;

/**
 * This class handles the elements in Login Page, extends of the {@link BasePage} class.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class LoginPage extends BasePage {

    @FindBy(css = "[id*='LoginControl1_TextBoxEmail']")
    protected WebElement emailTxtBox;

    @FindBy(css = "[id*='LoginControl1_TextBoxPassword']")
    protected WebElement passwordTxtBox;

    @FindBy(css = "[src='/Images/logo2.png']")
    protected WebElement loginTitle;

    @FindBy(css = "[id*='ButtonLogin']")
    protected WebElement loginBtn;

    @FindBy(css = "[src*='pagelogin']")
    protected WebElement loginLink;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginTitle));
    }

    /**
     * Logs in into the Application.
     *
     * @param username - User's username.
     * @param password - User's password.
     */
    public void logIn(final String username, final String password) {
        driverTools.clickElement(loginLink);
        driverTools.setInputField(emailTxtBox, username);
        driverTools.setInputField(passwordTxtBox, password);
        driverTools.clickElement(loginBtn);
    }
}
