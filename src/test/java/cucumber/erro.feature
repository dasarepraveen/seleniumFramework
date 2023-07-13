@tag
Feature: Purchase the order for E-Commerce Website error sceanrios
  Background:
    Given I landed on the BasePage

  @error
  Scenario Outline: error validations
    Given Logged in with <username> and <password>
    When I add <productname> to the cart
    And I verify that the <productname> is not equal to actualname
    Examples:
      |      username       |     password   |    productname       |
      | appledasare@gmail.com   | Guruji8@       |    ZARA COAT 34       |


