
@MultipleWindows
Feature: Multiple Windows
  The user should be able to open and access the new window
  
  Scenario: Opening and accessing a new window
  	Given I am on the theinternet Multiple Windows page
    When I click on the hyperlink in the page
		Then A new window will pop up
		And I will be able to access the new window
		And also I will be able to verify that I am in the right window