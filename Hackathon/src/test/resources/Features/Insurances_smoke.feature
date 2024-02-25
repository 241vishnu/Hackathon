Feature: Insurances_smoke

  @smoke
  Scenario: Travel insurance home page
    Given user navigated policy bazaar homepage
    When user clicked on travel insurance link and navigated to destination page
    When user Entered valid destination place in text box
    Then user selects the place from dropdown and clicks next button1
  @smoke
  Scenario: Travel insurance trip date page
    Given user navigated to trip dates page
    When user selects the start and end dates from the tabel
    Then clicks on next button2
  @smoke
  Scenario: Travel insurance traveller page
    Given user navigated to traveller page
    When user selects "2" people
    And selects their respective ages
    Then clicks on next button3
  @smoke
  Scenario: Travel insurance medical history page
    Given user navigated to medical history page
    When user selects either of value i.e yes/no
    Then clicks on next button4
  
  @smoke
  Scenario: Travel insurance results page
    Given user navigated to contact details page
    When user enters valid phone number in text box
    And user clicks button to uncheckbox the whatsapp updates
    Then clicks on view plans button and user navigated to resuls page
 
     ##### CAR INSURANCE #####
   
  @smoke
  Scenario: car insurance home page
    Given user clicked on policy bazar logo link1
  	When user  navigated to home page2
  	And user clicked on car insurance link and navigated to car insurance page
  	And user clicks on view prices button without entering car number in text box
  	Then user captures the error message
  @smoke
  Scenario: car insurance RTO page
  	Given user navigated to car insurance page 
  	When user clicks on buying a new car button
  	And user navigated to city and select a RTO numer
  	Then  click on a city and select a RTO number
  @smoke
  Scenario: car insurance brand name page
  	Given user navigated to car insurance page
  	When user verifies the brand name page
  	Then user selects a brand 
  @smoke
  Scenario: car insurance model name page
  	Given user navigated to car insurance page
  	When user verfies model name page
  	Then user selects the model name
  @smoke
  Scenario: car insurance model fueltype page
  	Given user navigated to car insurance page
  	When user verifies fueltype name page
  	Then user selects fueltype name
  @smoke
  Scenario: car insurance variant name page
  	Given user navigated to car insurance page
  	When user verifies variant name page
  	Then user selects a variant name
  @smoke
  Scenario: car insurance contact details page
  	Given user navigated to car insurance page
    When user clicks on final view prices button
    Then capture error messages
 
  @smoke
  Scenario: car insurance contact details page
  	Given user navigated to car insurance page
    When user entered valid fullname, email and invalid phone
    Then capture error message invalid phone
  @smoke
  Scenario: car insurance final page
  	Given user navigated to car insurance page
  	When user entered valid fullname, phone and invalid email
    Then capture error message invalid mail
    
    
    ##### HEALTH INSURANCE #####
 
	@smoke
  Scenario: Health insurance menu
  	Given user clicked on policy bazar logo link2
  	When user navigated to homepage3
  	And user clicked on insurance products dropdown
  	Then store all the health insurance menu in the list
  	
  @smoke
  Scenario: Health insurance link

  	Given user navigated to homepage
  	When user clicked on health insurance link and navigated to health insurance page
  	And user clicked on more members button
  	When user clicks on select self as a member
  	Then user clicks on continue1 button
  	
  @smoke
  Scenario: Health insurance age page
  	Given user navigated to age page
  	Then user selects age from drop down
  	Then user clicks on continue2 button
  
	@smoke
	Scenario: Health insurance city page
  	Given user navigated to city page
  	Then user selects city from drop down and clicks on continue3 button
  		  	
  @smoke 
  Scenario: Health insurance positive contact page
  	Given user navigated to contact page
  	When user enters valid name and phone number in textboxes 
  	Then user clicks on continue4
  	
  
  
  	
  	

  