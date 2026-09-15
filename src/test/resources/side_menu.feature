@sideMenu
Feature: Side menu navigation
  # TestLink ID 33

  Background: User login into sauce demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home pages should be displayed

  Scenario: The side menu shows all the navigation options
    When I open the side menu
    Then The side menu should display the following options
      | All Items       |
      | Dynamic Catalog |
      | About           |
      | Logout          |
      | Reset App State |

  Scenario: User can go back to the catalog with All Items
    When I click on the cart icon
    Then The page title should be "Your Cart"
    When I open the side menu
    And I select the "All Items" option from the side menu
    Then The page title should be "Products"

  Scenario: User can log out from the side menu
    When I open the side menu
    And I select the "Logout" option from the side menu
    Then The login page should be displayed
    And No protected content should be visible
