#This is test scenario
Feature: I want to verify that user login to application

  
Scenario: Check login is successful with valid login credentials
    Given I opened the Chrome browser and I open application URL
    	When I entered username "newtest" and password "Test@123"
    		And I click on Login button
    			Then I verified user loged in successfully 
    				And I logout from application and close the browser

Scenario: Check login is not successful with invalid login credentials
    Given I opened the Chrome browser and I open application URL
    	When I entered username "newtest1" and password "1Test@123"
    		And I click on Login button
    			Then I verified user not loged in and close the browser
    			
    			
Scenario Outline: Check login with different test data
    Given I opened the Chrome browser and I open application URL
    	When I entered username <username> and password <password> and click login button
    		Then I verified user <username> is displayed on home page
    		  And I logout from application and close the browser
  
  Examples:
  |username|password|
  |newtest|Test@123|
  |newtest1|Test@123|		  
    