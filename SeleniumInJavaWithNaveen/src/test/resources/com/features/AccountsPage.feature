@smoke
Feature: Account Page Feature


  Background:
    Given user has already logged in to application
      |username|password|
      |defabc12345@gmail.com|12345|

  @accounts
  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My Account"

  @accounts
  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      |My Account|
      |Edit Account|
      |Password|
      |Address Book|
      |Wish List|
      |Order History|
      |Downloads|
      |Recurring payments|
      |Reward Points|
      |Returns|
      |Transactions|
      |Newsletter|
      |Logout|
    And accounts section count should be 13