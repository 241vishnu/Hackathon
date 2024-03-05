Feature: Insurance_regression

@regression
  Scenario: user validates Travel insurance contact details page in policy bazaar website
    Given user navigate to contact details page
    When user enters invalid phone number
    Then user captures error message
    
@regression
  Scenario: user validates Travel Insurance results in policy bazaar website
  
  	Given user navigated travel insurance results page
    When clicks on filter plan type and selects student plan radio button
    And user confirms the travellers by selecting their age and enters the no of days and clicks on apply button
    And user ckicks on sortby filter and selects premium low to high radio button
    Then user collects the first three insurance plans along with insurance provider

@Regression
  Scenario: user validates the health insurance-members page in policy bazaar

  	Given user navigates to policy bazaar homepage
  	When user clickes on health insurance link and navigates to health insurance page
  	And user clickes on more members button
  	And user clicks directly on continue1 button
  	Then user captures error message1

@Regression
  Scenario: user validates Health insurance member page in policy bazaar website
    Given user navigates to member page
  	When user clicks on select self as a member and clicks on continue1 button
  	And user clicks directly on continue2 button
  	Then capture error message2

@Regression 
  Scenario: user validates Health insurance age page in policy bazaar website
  	Given user navigates to age page
  	When user selects age from drop down and clicks on continue2 button
  	And user clicks directly on continue3  
  	Then capture error message3

@Regression
	Scenario: user validates Health insurance city page in policy bazaar website
  	Given user navigates to city page
  	When user selects city from dropdown and clicks on continue3 button
  	And user clicks directly on continue4  
  	Then capture error message4

@Regression 
  Scenario: user validates Health insurance contact page with positive name in policy bazaar website
  	Given user navigates to contact page
  	When user enters valid name and clicks on continue4
  	Then capture error message5
  	
@Regression
  Scenario: user validates Health insurance contact page with positve name and negative phone number
  	Given user navigates to contact page
  	When user enters valid name and invalid phone number and clicks on continue4
  	Then capture error message6
 
 @Regression
  Scenario: user validates Health insurance result page in policy bazaar
  	Given user navigates to medical illnes page
  	When user clicks on viewplans directly 
  	Then capture error message7
  	
@regression
  Scenario: user validates Health Insurance results in policy bazaar
  	Given user navigates to health insurances results page
  	When user clicks on No checkbox
  	Then first three inusurances prices and insurance providers are stored in list
  	