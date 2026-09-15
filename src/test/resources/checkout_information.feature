@checkoutInformation
Feature: Checkout information validations
  # TestLink IDs 21, 22, 23 y 24

  Background: User has a product in the cart and opens the checkout form
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And I add the product "Sauce Labs Onesie" to the cart
    And I click on the cart icon
    And I click on the checkout button
    Then The page title should be "Checkout: Your Information"

  Scenario Outline: The checkout cannot continue when <case>
    When I fill the checkout information with
      | <firstName> | <lastName> | <postalCode> |
    And I click on the continue button
    Then The checkout error message "<errorMessage>" should be displayed
    And The page title should be "Checkout: Your Information"
    Examples:
      | case                     | firstName | lastName | postalCode | errorMessage                   |
      | the first name is empty  |           | Perez    | 0001       | Error: First Name is required  |
      | the last name is empty   | Ana       |          | 0001       | Error: Last Name is required   |
      | the postal code is empty | Ana       | Perez    |            | Error: Postal Code is required |
      | all the fields are empty |           |          |            | Error: First Name is required  |
