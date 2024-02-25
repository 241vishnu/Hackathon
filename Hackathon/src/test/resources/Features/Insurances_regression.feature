Feature: Insurance_regression

@regression
  Scenario: Travel insurance contact details page
    Given user navigate to contact details page
    When user enters invalid phone number
    Then user captures error message
    
@regression
  Scenario: Travel Insurance results
  
  	Given user navigated travel insurance results page
    When clicks on filter plan type and selects student plan radio button
    And user confirms the travellers by selecting their age and enters the no of days and clicks on apply button
    And user ckicks on sortby filter and selects premium low to high radio button
    Then user collects the first three insurance plans along with insurance provider

@Regression
  Scenario: Health insurance link

  	Given user navigates to policy bazaar homepage
  	When user clickes on health insurance link and navigates to health insurance page
  	And user clickes on more members button
  	And user clicks directly on continue1 button
  	Then user captures error message1

@Regression
  Scenario: Health insurance member page
    Given user navigates to member page
  	When user clicks on select self as a member and clicks on continue1 button
  	And user clicks directly on continue2 button
  	Then capture error message2

@Regression
  Scenario: Health insurance age page
  	Given user navigates to age page
  	When user selects age from drop down and clicks on continue2 button
  	And user clicks directly on continue3  
  	Then capture error message3

@Regression
	Scenario: Health insurance city page
  	Given user navigates to city page
  	When user selects city from dropdown and clicks on continue3 button
  	And user clicks directly on continue4  
  	Then capture error message4

@Regression 
  Scenario: Health insurance positive name contact page
  	Given user navigates to contact page
  	When user enters valid name and clicks on continue4
  	Then capture error message5
  	
@Regression
  Scenario: Health insurance positve name and negative phone contact page
  	Given user navigates to contact page
  	When user enters valid name and invalid phone number and clicks on continue4
  	Then capture error message6
 
 @Regression
  Scenario: Health insurance result page
  	Given user navigates to medical illnes page
  	When user clicks on viewplans directly 
  	Then capture error message7
  	
@regression
  Scenario: Health Insurances results
  	Given user navigates to health insurances results page
  	When user clicks on No checkbox
  	#And  user clicks on sort by filter and selects premium low to high dropdown and click on apply
  	Then first three inusurances prices and insurance providers are stored in list
  	