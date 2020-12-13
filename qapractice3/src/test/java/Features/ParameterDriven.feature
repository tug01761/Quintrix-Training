@ParameterDriven
Feature: ParameterDriven
  The user should be able to fill and submit the student registration form

  Scenario Outline: Fill and submit the student registration form
  
    Given I am on the automation practice form website
    When I fill the First Name textbox with "<f_name>" 
    And I fill the Last Name textbox with "<l_name>" 
    And I fill the email textbox with "<email>" 
    And I choose the "<gender>" gender
    And I fill the Mobile Number textbox with "<mobile_number>" 
    And I put "<dob>" in the dob textbox
    And I choose "<subjects>" as the subjects
    And I check "<hobbies>" as the hobbies
    And I put "<address>" as my Current Address
    And I choose "<state>" as my State
    And I choose "<city>" as my City
    Then I can submit the form
    And I will verify that I put the correct informations

    Examples: 
      | f_name | l_name | email            | gender | mobile_number | dob 			 | subjects         | hobbies         | address           | state         | city    |  
      | Mike   | Lauw   | mlauw@gmail.com  | Male   | 2654333111    | 05/01/1996 | Accounting, Arts | Reading         | 2210 South Street | NCR           | Delhi   |    
      | Bob    | Troy   | btroy@gmail.com  | Other  | 1234567890    | 10/12/2000 | Maths, English   | Sports, Reading | 110 North Street  | Haryana       | Panipat |  
			| Kathy  | White  | kwhite@gmail.com | Female | 5234954032    | 12/25/2003 | Computer Science | Music           | 200 Wolf Street   | Uttar Pradesh | Agra    |   