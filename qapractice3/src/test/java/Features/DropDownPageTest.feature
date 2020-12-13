
@DropDown
Feature: Dropdown
  The user should be able to use the dropdown
  
  Scenario: Opening and accessing a new window
  	Given I am on the theinternet Dropdown page
    When I open the dropdown list to see the options
		Then The dropdown list options will show up 
		And I click on "Option 2" 
		And I also will verify that "Option 2" is being chosen