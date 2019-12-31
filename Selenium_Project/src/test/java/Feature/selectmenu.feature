Feature: Test the Amazon web site

#Scenario:
#Given I open the Amazon site
#And I enter username and password to login
#And I hover the shop by category and click on Computers
#And select the item in computers and add to cart
#And I click proceed to checkout
#And I enter shipping address
#Given I change the shipping address
#And I delete the address and add new addres
#When I enter credit card details

#@functional
#Scenario: test amazon by proceeding checkout
#Given I open the Amazon site
#And I enter username and password to login
#When I Select the product and add it to cart
#And I click proceed to checkout 
#And I enter shipping address
#And I click on proceed to checkout
#And I click on continue button
#When I enter credit card details

@functional
Scenario: test amazon by proceeding checkout
Given I open the Amazon site
And I enter username and password to login
When I Select the product and add it to cart
And I click proceed to checkout 
And I enter shipping address
And I click on proceed to checkout
And I click on continue button
When I enter credit card details
And I click continue button
And I click on use this address
#Then I did Place an order






