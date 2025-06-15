Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Account Login"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters email "amotooricap6@gmail.com"
And user enters password "12345"
And user clicks on Login button
Then user gets the title of the account page
And page title should be "My Account"