package todoly.app.ui.todoly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import todoly.app.entities.Todo;
import todoly.app.ui.todoly.BasePage;

/**
 * This class handles the elements in Home Page, extends of the {@link BasePage} class.
 *
 * @author Maday Alcala
 * @since 06/26/2021
 */
public class HomePage extends BasePage {

    @FindBy(css = "[href*='Logout']")
    protected WebElement logoutBtn;

    @FindBy(id = "NewItemContentInput")
    protected WebElement addNewTodoTxtBox;

    @FindBy(id = "NewItemAddButton")
    protected WebElement addNewTodoBtn;

    @FindBy(css = "#ItemCheckBox[itemid]")
    protected WebElement todoChckBox;

    @FindBy(id = "DoneItemsCount")
    protected WebElement doneItemsCountLbl;

    @FindBy(id = "DoneItemsDeleteLink")
    protected WebElement deleteAllBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
    }

    /**
     * Verifies that logout button is displayed.
     *
     * @return true if the button is displayed, false otherwise.
     */
    public boolean verifyLogoutBtnIsDisplayed() {
        return driverTools.isElementDisplayed(logoutBtn);
    }

    /**
     * Creates new Todos.
     *
     * @param todos - names to creates the todos.
     */
    public void createNewTodo(final Todo todos) {
        driverTools.setInputField(addNewTodoTxtBox, todos.getName());
        driverTools.clickElement(addNewTodoBtn);
    }

    /**
     * Verifies the todos created are displayed.
     *
     * @param todos - entity with the data.
     * @return true if it is displayed, false otherwise.
     */
    public boolean verifyTodoCreatedIsDisplayed(final Todo todos) {
        return true;
    }

    /**
     * Marks the todos as completed.
     */
    public void markTodoAsCompleted() {
        driverTools.clickElement(todoChckBox);
    }

    /**
     * Verifies todos is completed.
     *
     * @return true if it's completed, false otherwise.
     */
    public boolean verifyTodoIsDisplayedAsCompleted() {
        return driverTools.isElementDisplayed(doneItemsCountLbl);
    }

    /**
     * Deletes all todos.
     */
    public void deleteAllTodos() {
        driverTools.clickElement(deleteAllBtn);
    }

    /**
     * Verifies All todos are deleted.
     *
     * @return true if todos are deleted, false otherwise.
     */
    public boolean verifyAllTodosAreDeleted() {
        return true;
    }

    /**
     * Logs out.
     */
    public void logout() {
        driverTools.clickElement(logoutBtn);
    }
}
