package hooks;

import cucumber.api.java.After;
import todoly.app.entities.Todo;
import todoly.app.ui.todoly.pages.HomePage;

/**
 * This class handles hooks.
 *
 * @author Maday Alcala
 * @since 06/28/2021
 */
public class TodoHook {

    private Todo todo;

    /**
     * Constructor for dependency injection.
     *
     * @param todos - a Todos instance containing entities to be shared across step definitions.
     */
    public TodoHook(final Todo todos) {
        this.todo = todos;
    }

    private final int five = 5;

    /**
     * logs out.
     */
    @After(order = five, value = "@logout")
    public void logOut() {
        HomePage homePage = new HomePage();
        homePage.logout();
    }
}
