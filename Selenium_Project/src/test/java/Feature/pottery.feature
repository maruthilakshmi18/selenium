Feature: Test Pottery website

Background:
Given I open the pottery website
And I hover the registry button and click on get started for registration

#@functional
#Scenario: test the registration functionality
#And I enter the below details for creating a account
#|full name | email |   confirm email     | password | confirm password |
#|Lakshmi |maruthi.k@gmail.com |maruthi.k@gmail.com  | Password@1  | Password@1  |
#Then click on submit and account is created
#And I click on logout
#And I login the website with below credintials
#|maruthi.k@gmail.com| Password@1 |
#And I validate the loggedIn page
#And I click on Account setting
#And I edit the display name and verify it
#|mars|
#And I edit the email address and verify it
#|Password@1| lakshmi.kg@gmail.com| lakshmi.kg@gmail.com|

@functional1
Scenario Outline: test account settings in pottery
And I login the website with below credintials
|maruthi.mh@gmail.com| Password@1 |
And I click on Address Book
And I click on add Address Book
And I enter the below details in address book
|full name| address| city| zip code| phone number |
|JOHN |3747 N KIMBALL AVE    |CHICAGO| 48084| 7814315726 |
And set address as default for shipping and billing in address page
And I update the address in address page
And I add multiple addresses in address page
|full name| address| city| zip code| phone number |
|JOSE |417 BLOCK   |CHICAGO| 60605| 7816409528 |
And select the "<state>" and submit in address page
And I remove any address from address page
Examples:
|state|
|illinois|






                   





