Feature: Test the macys web site

#Scenario: Open the macys we site as a guest

#Given I open the macys site
#And I close the popup
#And verify the title of the web page
#When I click on go to us site
#And I enter the product in search bar
#|adidas tiro 19|
#|jet 2019|
#And Add the product into bag

Scenario: Open the macys web site as a guest by adding products with size into bag and continue shopping

Given I open the macys site
And I close the popup
And verify the title of the web page
When I click on go to us site
And I enter the product in search bar
|adidas tiro 19|
And select the product to bag
And select the size and number of products
Then do checkout the items


