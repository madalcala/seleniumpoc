Feature: Create, delete a new Todo

  @logout
  Scenario: Create new todo
    Given I am logged as admin user
    Then the logout should appear in the panel
    When I create a new todo with the following information
      | name | Test03 |
    Then the todo created should be displayed
    When I mark the todo as completed
    Then the todo should be displayed as completed
    When I delete all Todos
    Then the todos should be deleted
