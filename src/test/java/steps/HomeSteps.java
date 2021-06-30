package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import todoly.app.entities.Todo;
import todoly.app.ui.todoly.pages.HomePage;

import java.util.Map;

import static org.testng.Assert.assertTrue;

/**
 * This class handles the Home steps.
 *
 * @author Maday Alcala
 * @since 06/28/2021
 */
public class HomeSteps {

    // Pages
    private HomePage homePage;

    // Entities
    private Todo todo;

    /**
     * Constructor class and gets the instance of needed entities.
     *
     * @param todos - item entity.
     */
    public HomeSteps(final Todo todos) {
        this.todo = todos;
    }

    /**
     * Creates a new task.
     *
     * @param todoMap - Map with the information to create the task.
     */
    @When("^I create a new todo with the following information$")
    public void createANewTodoWithTheFollowingName(final Map<String, String> todoMap) {
        Todo todo = new Todo();
        homePage = new HomePage();
        todo.setValues(todoMap);
        homePage.createNewTodo(todo);
    }

    /**
     * Verifies that the task is created.
     */
    @Then("^the todo created should be displayed$")
    public void verifyTodoCreated() {
        assertTrue(homePage.verifyTodoCreatedIsDisplayed(todo), "Todo is not displayed.");
    }

    /**
     * Marks the task as completed.
     */
    @When("^I mark the todo as completed$")
    public void markTodoAsCompleted() {
        homePage.markTodoAsCompleted();
    }

    /**
     * Verifies that the task is displayed as completed.
     */
    @Then("^the todo should be displayed as completed$")
    public void verifyTodoIsCompleted() {
        assertTrue(homePage.verifyTodoIsDisplayedAsCompleted(), "Todo is not displayed as completed.");
    }

    /**
     * Deletes all the todos.
     */
    @When("^I delete all Todos$")
    public void deleteAllTodos() {
        homePage.deleteAllTodos();
    }

    /**
     * Verifies that all the todos were deleted.
     */
    @Then("^the todos should be deleted$")
    public void verifyAllTodosAreDeleted() {
        assertTrue(homePage.verifyAllTodosAreDeleted(), "Todos were not deleted.");
    }
}
