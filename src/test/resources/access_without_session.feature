@accessWithoutSession
Feature: Access to protected pages without an active session
  # TestLink IDs 11, 12, 19 y 32

  Background: User has not logged in
    Given I am in sauce demo web page

  Scenario Outline: A user without session cannot open <page>
    When I navigate directly to "<path>"
    Then The login page should be displayed
    And A error message that says "Epic sadface: You can only access '<page>' when you are logged in." should be displayed
    And No protected content should be visible
    Examples:
      | page                    | path                      |
      | /inventory.html         | /inventory.html           |
      | /inventory-item.html    | /inventory-item.html?id=4 |
      | /cart.html              | /cart.html                |
      | /checkout-step-two.html | /checkout-step-two.html   |
