Feature: Automate Google form by using selenium automation
@Test2
Scenario: Fill the Google form
#When click on nisum login page
Given I open the Google form
And I enter the username and click on next
And I enter user name and password in login page
|ngorrepati@nisum.com|Password@5282|
Then I click on the submit button and click continue
Then I enter the first name and Last name
|Lakshmi| g|
And I select Gender
And I select Work Experience
And I enter date of birth
And I select the skills
And I select automation tools
And I enter my work experience
And I upload the file
And I enter current time
And I enter my signature
And I click on submit button
Then response has been recorded
