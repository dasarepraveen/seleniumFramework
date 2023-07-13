@tag
Feature: Purchase the order for E-Commerce Website
  Background:
    Given I landed on the BasePage

    @regression
    Scenario Outline: Postive flow of submiting end - end flow
      Given Logged in with <username> and <password>
      When I add <productname> to the cart
      And I Check out the Product with relevent inputs
      Then Verify that the "THANKYOU FOR THE ORDER." message is displayed
      Examples:
      |      username       |     password   |    productname       |
      | appledasare@gmail.com   | Guruji6@       |    ZARA COAT 3       |


