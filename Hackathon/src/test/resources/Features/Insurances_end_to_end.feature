Feature: Insurances_end_to_end

	@smoke, @regression
  Scenario Outline: Travel insurance
  
    Given user navigates to policy bazaar home
    When user clicked on travel insurance link and navigates to destination page
    And user provided valid data with "<Destinations>","<Traveller>","<contactDetails>" clicks on view plans button
    And user selects the students plan and sorts from low to high in the filters
    Then user collects first three insurance plans along with insurance provider
    Examples:
    | Destinations		| Traveller | contactDetails |
    |	United Kingdom	|		2				|	9876575345		|
 
  Scenario Outline: Car insurance
  
  	Given user navigated to policy bazaar application
  	When user clicked on car insurance link and navigates to car insurance page
  	And user clicked on view prices button without entering car number in text box
  	Then user captures the error message of car insurance page
  
  	When user clicked on buying a new car button
  	And user provided valid dummy data with "<SelectCity>","<CarBrand>","<CarModel>","<FuelType>"
  	And user provide invalid contact details "<Name>","<Email>","<phoneNumber>"
  	Then click on view price and capture error message
  	Examples:
  	|	SelectCity	|	CarBrand	|	CarModel	|	FuelType	|	Name	|		Email				|	phoneNumber	|
  	|	Chennai			| Tata			| Nexon			| petrol		| ram		| abcgamil.com	|	6784367565	|
 
 Scenario: Health Insurance menu
  	Given user navigated to policy bazaar homepage
  	When user clicked on insurance products drop down
  	Then store all the health insurances menu in the list

 Scenario Outline: Health Insurance
    Given user navigated to policy bazaar homepage
  	When user clicks on health insurance link and navigated to health insurance page
  	And user  provided valid data with "<member>","<age>","<city>","<name>","<phone>"and click on continue
  	Then sort results as low to high and capture the first three insurance packages and providers
  	Examples: 
  	|	member	|	age	|	city									|	name	|	 phone			|
  	|	self		|	34	| Hyderabad(Telangana)	| arjun	|	9769878756	|
  	
  	
 
  	
  	

  