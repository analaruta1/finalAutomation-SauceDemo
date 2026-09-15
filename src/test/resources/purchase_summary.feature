@purchaseSummary
Feature: Purchase summary and cancellation
  # TestLink IDs 29 (incluye 13) y 31

  Background: User adds several products and reaches the checkout overview
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And I add the following products to the cart
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    Then I verify that the cart icon displays "3"
    When I click on the cart icon
    And I click on the checkout button
    And I fill the checkout information with
      | Ana | Perez | 0001 |
    And I click on the continue button
    Then The page title should be "Checkout: Overview"

  Scenario: The purchase summary shows the right products and amounts
    Then The checkout overview should list the following products
      | Sauce Labs Backpack     | 29.99 |
      | Sauce Labs Bike Light   | 9.99  |
      | Sauce Labs Bolt T-Shirt | 15.99 |
    And The item total should be the sum of the product prices
    And The tax should be 8% of the item total
    And The total should be the item total plus tax

  Scenario: User can cancel the purchase from the checkout overview
    When I click on the cancel button
    Then The page title should be "Products"
    And The purchase confirmation should not be displayed
    And I verify that the cart icon displays "3"
