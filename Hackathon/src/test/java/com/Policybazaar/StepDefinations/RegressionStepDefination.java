package com.Policybazaar.StepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.Policybazaar.PageObjects.CarInsurancePage;
import com.Policybazaar.PageObjects.HealthInsurancePage;
import com.Policybazaar.PageObjects.TravelInsurancePage;
import com.utils.HelperClass;
import com.utils.excelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegressionStepDefination {
	
	public static WebDriver driver;
	static TravelInsurancePage TIP ;
	static CarInsurancePage CIP;
	static HealthInsurancePage HIP;
	public static String path=System.getProperty("user.dir")+"\\src\\test\\resources\\HackathonOutputs.xlsx";
	
	@Given("user navigate to contact details page")
	public void user_navigate_to_contact_details_page() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
    	HelperClass.getLogger().info("Navigating to policy bazaar home page.....");
		TIP.title();
    	HelperClass.getLogger().info("clicking on travel insurance icon.....");
		TIP.travelInsuranceIcon();									//to click travel insurance icon
    	HelperClass.getLogger().info("Entering Destination country .....");
		TIP.destinationDetails("United Kingdom");					//to enter a country name
		TIP.DestinationDropDown(); 							//to select the respective country from dropdown
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	HelperClass.getLogger().info("Entering the dates.....");
		TIP.tripEnterDates();									//to enter start and end dates
		TIP.navigateTotravellPage();							//to navigate travellers page
    	HelperClass.getLogger().info("Entering the Number of travellers and their ages.....");
		TIP.no_of_Travellers("2");							//to select 'n' people
		TIP.travellerDetails();						//to select ages for respective people
		TIP.navigatToMedicalHistoryPage(); 						//to navigate to medical history page
    	HelperClass.getLogger().info("Selecting previous medical history.....");
		TIP.checkMedicalHistory();								//to select 'No' check box
		TIP.navigateToContactDetailsPage(); 
		TIP.contactDetailsPage(); 								//to verify the contact details page
	}

	@When("user enters invalid phone number")
	public void user_enters_invalid_phone_number() {
    	HelperClass.getLogger().info("Entering invalid contact details.....");
		TIP.enterMobileNumber("345678");
	}

	@Then("user captures error message")
	public void user_captures_error_message() throws IOException {
    	HelperClass.getLogger().info("Capturing error message.....");
		System.out.println(TIP.error());
	   	  excelUtils.setCellData(path,"RegressionOutput",13,1,TIP.error());

	}
	@Given("user navigated travel insurance results page")
	public void user_navigated_travel_insurance_results_page() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		TIP.title();
		TIP.travelInsuranceIcon();									//to click travel insurance icon
		TIP.destinationDetails("United Kingdom");					//to enter a country name
		TIP.DestinationDropDown(); 							//to select the respective country from dropdown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		TIP.tripEnterDates();									//to enter start and end dates
		TIP.navigateTotravellPage();							//to navigate travellers page
		TIP.no_of_Travellers("2");							//to select 'n' people
		TIP.travellerDetails();						//to select ages for respective people
		TIP.navigatToMedicalHistoryPage(); 						//to navigate to medical history page
		TIP.checkMedicalHistory();								//to select 'No' check box
		TIP.navigateToContactDetailsPage(); 					//to navigate to contact details page
		TIP.enterMobileNumber("9785678954");
		TIP.whatsapp();
		TIP.viewPlans();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("clicks on filter plan type and selects student plan radio button")
	public void clicks_on_filter_plan_type_and_selects_student_plan_radio_button() {
    	HelperClass.getLogger().info("selecting plan type.....");
		TIP.planType();
	}

	@When("user confirms the travellers by selecting their age and enters the no of days and clicks on apply button")
	public void user_confirms_the_travellers_by_selecting_their_age_and_enters_the_no_of_days_and_clicks_on_apply_button() {
    	HelperClass.getLogger().info("confirming with the No.of travellers.....");
		TIP.travellersConfirmation();
	}

	@When("user ckicks on sortby filter and selects premium low to high radio button")
	public void user_ckicks_on_sortby_filter_and_selects_premium_low_to_high_radio_button() {
    	HelperClass.getLogger().info("Sorting by low to high.....");
		TIP.sortby();
	}

	@Then("user collects the first three insurance plans along with insurance provider")
	public void user_collects_the_first_three_insurance_plans_along_with_insurance_provider() throws IOException {
    	HelperClass.getLogger().info("Storing list in excel sheet.....");
		HashMap<String,String> res= TIP.collectResults();
	   int row=1;
	   for(Map.Entry<String,String>e:res.entrySet()) {
	    	excelUtils.setCellData(path,"RegressionOutput", row, 0,e.getKey());
	    	excelUtils.setCellData(path,"RegressionOutput", row, 1,e.getValue());
	    	row=row+1;
	   }
	  
	}
	
	@Given("user navigates to policy bazaar homepage")
	public void user_navigates_to_policy_bazaar_homepage() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		TIP =new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
    	HelperClass.getLogger().info("Navigating to policy bazaar home page.....");
		TIP.title();
	

	}

	@When("user clickes on health insurance link and navigates to health insurance page")
	public void user_clickes_on_health_insurance_link_and_navigates_to_health_insurance_page() {
    	HelperClass.getLogger().info("Hovering to insurance products.....");
		HIP.insuranceProducts();
    	HelperClass.getLogger().info("Storing the health insurance menu in excel.....");
		HIP.healthInsurancePage();
		System.out.println(driver.getTitle());
		HIP.title();
	}

	@When("user clickes on more members button")
	public void user_clickes_on_more_members_button() {
		HIP.moreMembers();

	}

	@When("user clicks directly on continue1 button")
	public void user_clicks_directly_on_continue1_button() {
    	HelperClass.getLogger().info("Clicking continue without selecting a member.....");
		HIP.continue1Btn();

	}

	@Then("user captures error message1")
	public void user_captures_error_message1() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
	   System.out.println(HIP.error1());
   	  excelUtils.setCellData(path,"RegressionOutput",13,0,HIP.error1());

	   
	}

	@Given("user navigates to member page")
	public void user_navigates_to_member_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		TIP=new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		HIP.healthInsurancePage();
		System.out.println(driver.getTitle());
		HIP.title();
		HIP.moreMembers();

	}

	@When("user clicks on select self as a member and clicks on continue1 button")
	public void user_clicks_on_select_self_as_a_member_and_clicks_on_continue1_button() {
		HIP.select_a_Member("self");
		HIP.continue1Btn();

	}

	@When("user clicks directly on continue2 button")
	public void user_clicks_directly_on_continue2_button() {
    	HelperClass.getLogger().info("Clicking continue without selecting a age.....");
		HIP.continue2Btn();
	}

	@Then("capture error message2")
	public void capture_error_message2() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
		System.out.println(HIP.error2());
	   	  excelUtils.setCellData(path,"RegressionOutput",14,0,HIP.error2());

	}

	@Given("user navigates to age page")
	public void user_navigates_to_age_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		TIP = new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		TIP.title();
		HIP.healthInsurancePage();
		HIP.title();
		HIP.moreMembers();
		HIP.select_a_Member("self");
		HIP.continue1Btn();
		HIP.agePage();
	}

	@When("user selects age from drop down and clicks on continue2 button")
	public void user_selects_age_from_drop_down_and_clicks_on_continue2_button() {
		HIP.selectAge("28");
		HIP.continue2Btn();

	}

	@When("user clicks directly on continue3")
	public void user_clicks_directly_on_continue3() {
    	HelperClass.getLogger().info("Clicking continue without selecting a city.....");
		HIP.continue3Btn();
	}

	@Then("capture error message3")
	public void capture_error_message3() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
		System.out.println(HIP.error3());
	   	  excelUtils.setCellData(path,"RegressionOutput",15,0,HIP.error3());

	}

	@Given("user navigates to city page")
	public void user_navigates_to_city_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		HIP.healthInsurancePage();
		HIP.moreMembers();
		HIP.select_a_Member("self");
		HIP.continue1Btn();
		HIP.agePage();
		HIP.selectAge("28");
		HIP.continue2Btn();
		HIP.cityPage();
	}

	@When("user selects city from dropdown and clicks on continue3 button")
	public void user_selects_city_from_dropdown_and_clicks_on_continue3_button() {
		HIP.selectCity("Hyderabad(Telangana)");

	}

	@When("user clicks directly on continue4")
	public void user_clicks_directly_on_continue4() {
    	HelperClass.getLogger().info("Clicking continue without entering contact details.....");
		HIP.continue4Btn();
	}

	@Then("capture error message4")
	public void capture_error_message4() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
		System.out.println(HIP.error4());
	   	  excelUtils.setCellData(path,"RegressionOutput",16,0,HIP.error4());

	}

	@Given("user navigates to contact page")
	public void user_navigates_to_contact_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		HIP.healthInsurancePage();
		HIP.moreMembers();
		HIP.select_a_Member("self");
		HIP.continue1Btn();
		HIP.agePage();
		HIP.selectAge("28");
		HIP.continue2Btn();
		HIP.cityPage();
		HIP.selectCity("Hyderabad(Telangana)");
		HIP.contactPage();
	}

	@When("user enters valid name and clicks on continue4")
	public void user_enters_valid_name_and_clicks_on_continue4() {
    	HelperClass.getLogger().info("Clicking continue without entering phone number.....");
		HIP.enterName("arjun");
		HIP.continue4Btn();
	}

	@Then("capture error message5")
	public void capture_error_message5() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
		System.out.println(HIP.error5());
	   	  excelUtils.setCellData(path,"RegressionOutput",17,0,HIP.error5());

	}

	@When("user enters valid name and invalid phone number and clicks on continue4")
	public void user_enters_valid_name_and_invalid_phone_number_and_clicks_on_continue4() {
    	HelperClass.getLogger().info("Clicking continue without entering invalid phone number.....");
		HIP.enterName("arjun");
		HIP.enterPhoneNumber("5678");
		HIP.continue4Btn();
	}

	@Then("capture error message6")
	public void capture_error_message6() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
	    System.out.println(HIP.error6());
	   	  excelUtils.setCellData(path,"RegressionOutput",18,0,HIP.error6());

	}

	@Given("user navigates to medical illnes page")
	public void user_navigates_to_medical_illnes_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		HIP.healthInsurancePage();
		HIP.moreMembers();
		HIP.select_a_Member("self");
		HIP.continue1Btn();
		HIP.agePage();
		HIP.selectAge("28");
		HIP.continue2Btn();
		HIP.cityPage();
		HIP.selectCity("Hyderabad(Telangana)");
		HIP.contactPage();
		HIP.enterName("arjun");
		HIP.enterPhoneNumber("9785678954");
		HIP.continue4Btn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@When("user clicks on viewplans directly")
	public void user_clicks_on_viewplans_directly() {
    	HelperClass.getLogger().info("Clicking continue without selecting medical check box.....");
		HIP.viewPlansBtn();
	}

	@Then("capture error message7")
	public void capture_error_message7() throws IOException {
    	HelperClass.getLogger().info("capturing error message.....");
		System.out.println(HIP.error7());
	   	  excelUtils.setCellData(path,"RegressionOutput",19,0,HIP.error7());

	}


	@Given("user navigates to health insurances results page")
	public void user_navigated_to_health_insurances_results_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		HIP.healthInsurancePage();
		HIP.moreMembers();
		HIP.select_a_Member("self");
		HIP.continue1Btn();
		HIP.agePage();
		HIP.selectAge("28");
		HIP.continue2Btn();
		HIP.cityPage();
		HIP.selectCity("Hyderabad(Telangana)");
		HIP.contactPage();
		HIP.enterName("arjun");
		HIP.enterPhoneNumber("9785678954");
		HIP.continue4Btn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@When("user clicks on No checkbox")
	public void user_clicks_on_no_checkbox() {
		HIP.whatsappbtn();
		HIP.NoCheckBox();
		HIP.previousProviders();
		HIP.viewPlans();
	
	}

	@Then("first three inusurances prices and insurance providers are stored in list")
	public void first_three_inusurances_prices_and_insurance_providers_are_stored_in_list() throws IOException {
    	HelperClass.getLogger().info("Sorting and storing the list in excel.....");
		HIP.sortby();
		HashMap<String,String> results=HIP.results();
		int row=6;
		   for(Map.Entry<String,String>e:results.entrySet()) {
		    	excelUtils.setCellData(path,"RegressionOutput", row, 0,e.getKey());
		    	excelUtils.setCellData(path,"RegressionOutput", row, 1,e.getValue());
		    	row=row+1;
		   }
	}


}