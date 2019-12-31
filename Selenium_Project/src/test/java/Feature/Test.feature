Feature: test renorex

Background:
Given I click on signin icon
@functional
Scenario: Do registration and login
And click on register button for registration
When I entered data into registration form
|first name | last name | user name | email |password |
|Sweety| g| lalli| composesridhar@gmail.com| Password@1|
Then We get thankyou page

@Test
Scenario: signin and do process in renorex
And click on signin button to login the application
When I enter username and password in login page
|ngorrepati@nisum.com|Password@1|
Then I click the submit button
When click on blog in header
And hover the sliding in header and click on arrows








