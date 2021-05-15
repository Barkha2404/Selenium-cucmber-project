Feature: Login Functionality


@Login
Scenario: Test Case to verify Login functionality with valid username and password

Given Browser should be open with login page 
When User should log-in using Username and password 
And Click on login button 
Then Home Page should get Open and verify page title.
And Close browser

