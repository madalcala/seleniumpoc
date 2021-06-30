package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import todoly.app.config.UserConfig;
import todoly.app.entities.User;
import todoly.app.ui.todoly.PageTransporter;
import todoly.app.ui.todoly.pages.HomePage;
import todoly.app.ui.todoly.pages.LoginPage;

import static org.testng.Assert.assertTrue;

/**
 * This class handles the Login steps.
 *
 * @author Maday Alcala
 * @since 06/28/2021
 */
public class LoginSteps {

    // Pages
    private LoginPage loginPage;

    // Entities
    private User user;

    /**
     * Login Steps Constructor.
     *
     * @param user - User logged in the application.
     */
    public LoginSteps(final User user) {
        this.user = user;
    }

    /**
     * Login to the application.
     *
     * @param usertype - User type.
     */
    @Given("^I am logged as (.*?)$")
    public void verifyLoginAsUser(final String usertype) {
        PageTransporter.goToUrl();
        loginPage = new LoginPage();
        user = UserConfig.getInstance().getUserByUserType(usertype);
        loginPage.logIn(user.getEmailAddress(), user.getPassword());
    }

    /**
     * Verifies the login was completed, the Home Page should be displayed.
     */
    @Then("^the logout should appear in the panel$")
    public void verifyLoginIsSuccessful() {
        HomePage homePage = new HomePage();
        assertTrue(homePage.verifyLogoutBtnIsDisplayed(), "Home Page was not displayed.");
    }
}
