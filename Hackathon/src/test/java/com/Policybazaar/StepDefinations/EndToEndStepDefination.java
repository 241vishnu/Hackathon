package com.Policybazaar.StepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Policybazaar.PageObjects.CarInsurancePage;
import com.Policybazaar.PageObjects.HealthInsurancePage;
import com.Policybazaar.PageObjects.TravelInsurancePage;
import com.utils.HelperClass;
import com.utils.excelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EndToEndStepDefination {
	
	public static WebDriver driver;
	static TravelInsurancePage TIP ;
	static CarInsurancePage CIP;
	static HealthInsurancePage HIP;
	static String path=System.getProperty("user.dir")+"\\src\\test\\resources\\HackathonOutputs.xlsx";

	
	
	@Given("user navigates to policy bazaar home")
	public void user_navigates_to_policy_bazaar_home() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		TIP.title();
    	HelperClass.getLogger().info("Navigating to policy bazaar home page.....");

	}

	@When("user clicked on travel insurance link and navigates to destination page")
	public void user_clicked_on_travel_insurance_link_and_navigates_to_destination_page() {
    	HelperClass.getLogger().info("clicking on travel insurance icon.....");
		TIP.travelInsuranceIcon();									//to click travel insurance icon
		TIP.destinationPage();				
	}

	@When("user provided valid data with {string},{string},{string} clicks on view plans button")
	public void user_provided_valid_data_with_clicks_on_view_plans_button(String string, String string2, String string3) {
    	HelperClass.getLogger().info("Entering Destination country .....");
		TIP.destinationDetails(string);					//to enter a country name
		TIP.DestinationDropDown(); 							//to select the respective country from dropdown
		TIP.tripDatePage();									//to verify the trip date page
    	HelperClass.getLogger().info("Entering the dates.....");
		TIP.tripEnterDates();									//to enter start and end dates
		TIP.navigateTotravellPage();							//to navigate travellers page
		TIP.travellersPage();									//to verify travellers page
    	HelperClass.getLogger().info("Entering the Number of travellers and their ages.....");
		TIP.no_of_Travellers(string2);							//to select 'n' people
		TIP.travellerDetails();						//to select ages for respective people
		TIP.navigatToMedicalHistoryPage(); 						//to navigate to medical history page
		TIP.medicalHistoryPage(); 								//to verify the medical history page
    	HelperClass.getLogger().info("Selecting previous medical history.....");
		TIP.checkMedicalHistory();								//to select 'No' check box
		TIP.navigateToContactDetailsPage(); 					//to navigate to contact details page
		TIP.contactDetailsPage(); 								//to verify the contact details page
    	HelperClass.getLogger().info("Entering contact details.....");
		TIP.enterMobileNumber(string3);
		TIP.whatsapp();
    	HelperClass.getLogger().info("Navigating to results page.....");
		TIP.viewPlans();

		
	}

	@When("user selects the students plan and sorts from low to high in the filters")
	public void user_selects_the_students_plan_and_sorts_from_low_to_high_in_the_filters() {
		TIP.resultsPage();
    	HelperClass.getLogger().info("selecting plan type.....");
		TIP.planType();
    	HelperClass.getLogger().info("confirming with the No.of travellers.....");
	    TIP.travellersConfirmation();
    	HelperClass.getLogger().info("Sorting by low to high.....");
		TIP.sortby();



	}

	@Then("user collects first three insurance plans along with insurance provider")
	public void user_collects_first_three_insurance_plans_along_with_insurance_provider() throws IOException {
		HashMap<String,String> res= TIP.collectResults();
    	HelperClass.getLogger().info("Storing list in excel sheet.....");

		int row=1;
		   for(Map.Entry<String,String>e:res.entrySet()) {
		    	excelUtils.setCellData(path,"E2EOutput", row, 0,e.getKey());
		    	excelUtils.setCellData(path,"E2EOutput", row, 1,e.getValue());
		    	row=row+1;
		   }
	}

	@Given("user navigated to policy bazaar application")
	public void user_navigated_to_policy_bazaar_application() {
    	HelperClass.getLogger().info("Navigating to policy bazaar home page.....");
		driver=HelperClass.getDriver();
		CIP=new CarInsurancePage(driver);
		TIP=new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		TIP.title();
	
	}

	@When("user clicked on car insurance link and navigates to car insurance page")
	public void user_clicked_on_car_insurance_link_and_navigates_to_car_insurance_page() {
    	HelperClass.getLogger().info("clicking on car insurance icon.....");
    	CIP.inusranceshover();
		CIP.carInsuranceIcon();
	    CIP.carInsurancePage();
	}

	@When("user clicked on view prices button without entering car number in text box")
	public void user_clicked_on_view_prices_button_without_entering_car_number_in_text_box() {
    	HelperClass.getLogger().info("clicking on view prices button without car number.....");
		   CIP.viewPrices();

	}

	@Then("user captures the error message of car insurance page")
	public void user_captures_the_error_message_of_car_insurance_page() throws IOException {
    	HelperClass.getLogger().info("Error message captured.....");
		   System.out.println(CIP.errorPage());
	    	excelUtils.setCellData(path,"E2EOutput", 13, 0,CIP.errorPage());


	}

	@When("user clicked on buying a new car button")
	public void user_clicked_on_buying_a_new_car_button() {
    	HelperClass.getLogger().info("clicking on new car button.....");

		   CIP.newCar();

	}

	@When("user provided valid dummy data with {string},{string},{string},{string}")
	public void user_provided_valid_dummy_data_with(String string, String string2, String string3, String string4) {
		   CIP.rtoPage();
	    	HelperClass.getLogger().info("Selecting city and rto.....");
		   CIP.rtoDetails(string);
		   CIP.brandNamePage();
	    	HelperClass.getLogger().info("Selecting brand name.....");
		   CIP.brandNameDetails(string2);
		   CIP.modelNamePage();
	    	HelperClass.getLogger().info("Selecting model name.....");
		   CIP.modelNameDetails(string3);
		   CIP.fuelTypePage();
	    	HelperClass.getLogger().info("Selecting fuel type.....");
		   CIP.fuelTypeDetails(string4);
		   CIP.variantTypePage();
	    	HelperClass.getLogger().info("Selecting variant type.....");
		   CIP.variantTypeDetails();
	}

	@When("user provide invalid contact details {string},{string},{string}")
	public void user_provide_invalid_contact_details(String string, String string2, String string3) {
    	HelperClass.getLogger().info("Entering invalid email.....");
		   CIP.enterName(string);
		   CIP.enterEmail(string2);
		   CIP.enterPhone(string3);

	}

	@Then("click on view price and capture error message")
	public void click_on_view_price_and_capture_error_message() throws IOException {
		   CIP.clickViewPrices();
	    	HelperClass.getLogger().info("Error message captured.....");
			System.out.println(CIP.mailErrorStatement());
	    	excelUtils.setCellData(path,"E2EOutput", 14, 0,CIP.mailErrorStatement());


	}

	@Given("user navigated to policy bazaar homepage")
	public void user_navigated_to_policy_bazaar_homepage() {
    	HelperClass.getLogger().info("Navigating to policy bazaar home page.....");
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		TIP=new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		TIP.title();	
	}

	@When("user clicked on insurance products drop down")
	public void user_clicked_on_insurance_products_drop_down() {
    	HelperClass.getLogger().info("Hovering to insurance products.....");
		HIP.insuranceProducts();

	}

	@Then("store all the health insurances menu in the list")
	public void store_all_the_health_insurances_menu_in_the_list() throws IOException {
    	HelperClass.getLogger().info("Storing the health insurance menu in excel.....");
    	List<WebElement> list=HIP.healthInsurnaceMenu();
		for(int i=0;i<list.size();i++) {
	        System.out.println(list.get(i).getText());
	    	excelUtils.setCellData(path,"E2EOutput", i+1, 2,list.get(i).getText());

		}
	}
	@When("user clicks on health insurance link and navigated to health insurance page")
	public void user_clicks_on_health_insurance_link_and_navigated_to_health_insurance_page() {
		HIP.insuranceProducts();
    	HelperClass.getLogger().info("Clicking on health insurance link.....");
		HIP.healthInsurancePage();
		System.out.println(driver.getTitle());
		HIP.title();
	}

	@When("user  provided valid data with {string},{string},{string},{string},{string}and click on continue")
	public void user_provided_valid_data_with_and_click_on_continue(String string, String string2, String string3, String string4, String string5) {
		HIP.moreMembers();
    	HelperClass.getLogger().info("Selecting a member.....");
		HIP.select_a_Member(string);
		HIP.continue1Btn();
		HIP.agePage();
    	HelperClass.getLogger().info("Selecting age of the member.....");
		HIP.selectAge(string2);
		HIP.continue2Btn();
		HIP.cityPage();
    	HelperClass.getLogger().info("Selecting city of the member.....");
		HIP.selectCity(string3);
		HIP.contactPage();
    	HelperClass.getLogger().info("Entering contact details of the member.....");
		HIP.enterName(string4);
		HIP.enterPhoneNumber(string5);
		HIP.continue4Btn();

	}

	@Then("sort results as low to high and capture the first three insurance packages and providers")
	public void sort_results_as_low_to_high_and_capture_the_first_three_insurance_packages_and_providers() throws IOException {

		HIP.whatsappbtn();
		HIP.NoCheckBox();
		HIP.previousProviders();
		HIP.viewPlans();
		HIP.sortby();
    	HelperClass.getLogger().info("Sorting and storing the list in excel.....");
		HashMap<String,String> results=HIP.results();
		int row=6;
		   for(Map.Entry<String,String>e:results.entrySet()) {
		    	excelUtils.setCellData(path,"E2EOutput", row, 0,e.getKey());
		    	excelUtils.setCellData(path,"E2EOutput", row, 1,e.getValue());
		    	row=row+1;
		   }
	}


}