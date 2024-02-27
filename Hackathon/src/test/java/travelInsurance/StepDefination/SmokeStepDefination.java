package travelInsurance.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.HelperClass;
import com.utils.excelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import travelInsurance.PageObjects.CarInsurancePage;
import travelInsurance.PageObjects.HealthInsurancePage;
import travelInsurance.PageObjects.TravelInsurancePage;

public class SmokeStepDefination {
	public static WebDriver driver;
	static TravelInsurancePage TIP ;
	static CarInsurancePage CIP;
	static HealthInsurancePage HIP;
	static String path=System.getProperty("user.dir")+"\\src\\test\\resources\\HackathonOutputs.xlsx";

	
	
	@Given("user navigated policy bazaar homepage")
	public void user_navigated_policy_bazaar_homepage() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		TIP.title();
		//Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", driver.getTitle());  
	}

	@When("user clicked on travel insurance link and navigated to destination page")
	public void user_clicked_on_travel_insurance_link_and_navigated_to_destination_page() {
		TIP.travelInsuranceIcon();									//to click travel insurance icon
		TIP.destinationPage();										//to verify destination page
	}

	@When("user Entered valid destination place in text box")
	public void user_entered_valid_destination_place_in_text_box() {
		TIP.destinationDetails("United Kingdom");					//to enter a country name
	}

	@Then("user selects the place from dropdown and clicks next button1")
	public void user_selects_the_place_from_dropdown_and_clicks_next_button1() {
		TIP.DestinationDropDown(); 							//to select the respective country from dropdown
	}

	@Given("user navigated to trip dates page")
	public void user_navigated_to_trip_dates_page() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		TIP.travelInsuranceIcon();
		TIP.destinationDetails("United Kingdom");
		TIP.DestinationDropDown();
		TIP.tripDatePage();									//to verify the trip date page
	}

	@When("user selects the start and end dates from the tabel")
	public void user_selects_the_start_and_end_dates_from_the_tabel() {
		TIP.tripEnterDates();									//to enter start and end dates
	}

	@Then("clicks on next button2")
	public void clicks_on_next_button2() {
		TIP.navigateTotravellPage();							//to navigate travellers page
	}

	@Given("user navigated to traveller page")
	public void user_navigated_to_traveller_page() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		TIP.travelInsuranceIcon();
		TIP.destinationDetails("United Kingdom");
		TIP.DestinationDropDown();
		TIP.tripDatePage();
		TIP.tripEnterDates();									//to enter start and end dates
		TIP.navigateTotravellPage();							//to navigate travellers page
		TIP.travellersPage();									//to verify travellers page
	}

	@When("user selects {string} people")
	public void user_selects_people(String string) {
		TIP.no_of_Travellers(string);							//to select 'n' people
	}

	@When("selects their respective ages")
	public void selects_their_respective_ages() {
		TIP.travellerDetails();						//to select ages for respective people
	}
	@Then("clicks on next button3")
	public void clicks_on_next_button3() {
		TIP.navigatToMedicalHistoryPage(); 						//to navigate to medical history page
	}

	@Given("user navigated to medical history page")
	public void user_navigated_to_medical_history_page() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		TIP.travelInsuranceIcon();
		TIP.destinationDetails("United Kingdom");
		TIP.DestinationDropDown();
		TIP.tripDatePage();
		TIP.tripEnterDates();									//to enter start and end dates
		TIP.navigateTotravellPage();							//to navigate travellers page
		TIP.travellersPage();	
		TIP.no_of_Travellers("2");							//to select 'n' people
		TIP.travellerDetails();						//to select ages for respective people
		TIP.navigatToMedicalHistoryPage(); 						//to navigate to medical history page
		//TIP.medicalHistoryPage(); 								//to verify the medical history page
	}

	@When("user selects either of value i.e yes\\/no")
	public void user_selects_either_of_value_i_e_yes_no() {
		TIP.checkMedicalHistory();								//to select 'No' check box
	}
	@Then("clicks on next button4")
	public void clicks_on_next_button4() {
		TIP.navigateToContactDetailsPage(); 					//to navigate to contact details page
	}

	@Given("user navigated to contact details page")
	public void user_navigated_to_contact_details_page() {
		driver=HelperClass.getDriver();
		TIP = new TravelInsurancePage(driver);
		TIP.travelInsuranceIcon();
		TIP.destinationDetails("United Kingdom");
		TIP.DestinationDropDown();
		TIP.tripDatePage();
		TIP.tripEnterDates();									//to enter start and end dates
		TIP.navigateTotravellPage();							//to navigate travellers page
		TIP.travellersPage();	
		TIP.no_of_Travellers("2");							//to select 'n' people
		TIP.travellerDetails();						//to select ages for respective people
		TIP.navigatToMedicalHistoryPage(); 						//to navigate to medical history page
		//TIP.medicalHistoryPage();
		TIP.checkMedicalHistory();								//to select 'No' check box
		TIP.navigateToContactDetailsPage(); 					//to navigate to contact details page
		TIP.contactDetailsPage(); 								//to verify the contact details page
	}

	@When("user enters valid phone number in text box")
	public void user_enters_valid_phone_number_in_text_box() {
		TIP.enterMobileNumber("9785678954");
	}

	@When("user clicks button to uncheckbox the whatsapp updates")
	public void user_clicks_button_to_uncheckbox_the_whatsapp_updates() {
		TIP.whatsapp();
	}

	@Then("clicks on view plans button and user navigated to resuls page")
	public void clicks_on_view_plans_button_and_user_navigated_to_resuls_page() {
		TIP.viewPlans();

	}

										//******CAR INSURANCE******//

	@Given("user clicked on policy bazar logo link1")
	public void user_clicked_on_policy_bazar_logo_link1() {
		driver=HelperClass.getDriver();
		CIP=new CarInsurancePage(driver);
		TIP=new TravelInsurancePage(driver);
	}
	
	@When("user  navigated to home page2")
	public void user_navigated_to_home_page2() {
		System.out.println(driver.getTitle());
		TIP.title();
		//Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", driver.getTitle());
	}

	@When("user clicked on car insurance link and navigated to car insurance page")
	public void user_clicked_on_car_insurance_link_and_navigated_to_car_insurance_page() {
		 	CIP.carInsuranceIcon();
		    CIP.carInsurancePage();
	}

	@When("user clicks on view prices button without entering car number in text box")
	public void user_clicks_on_view_prices_button_without_entering_car_number_in_text_box() {
		   CIP.viewPrices();
	}

	@Then("user captures the error message")
	public void user_captures_the_error_message() throws IOException {
		   System.out.println(CIP.errorPage());
		   excelUtils.setCellData(path,"SmokeOutput",1,0,CIP.errorPage());

	   	}

	@Given("user navigated to car insurance page")
	public void user_navigated_to_car_insurance_page() {
		driver=HelperClass.getDriver();
		CIP= new CarInsurancePage(driver);
		TIP= new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		TIP.title();
		//Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", driver.getTitle());
		CIP.carInsuranceIcon();
	    CIP.carInsurancePage();
		System.out.println(driver.getTitle());
		CIP.title();
		 //  Assert.assertEquals("PolicyBazaar Car Insurance: Insure Your Car Today",driver.getTitle());
	}

	@When("user clicks on buying a new car button")
	public void user_clicks_on_buying_a_new_car_button() {
		   CIP.newCar();
	}

	@When("user navigated to city and select a RTO numer")
	public void user_navigated_to_city_and_select_a_rto_numer() {
		   CIP.rtoPage();
	}

	@Then("click on a city and select a RTO number")
	public void click_on_a_city_and_select_a_rto_number() {
		   CIP.rtoDetails("chennai");
	}

	@When("user verifies the brand name page")
	public void user_verifies_the_brand_name_page() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
	}

	@Then("user selects a brand")
	public void user_selects_a_brand() {
		   CIP.brandNameDetails("Tata");
	}

	@When("user verfies model name page")
	public void user_verfies_model_name_page() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
		   CIP.brandNameDetails("Tata");
		   CIP.modelNamePage();
	}

	@Then("user selects the model name")
	public void user_selects_the_model_name() {
		   CIP.modelNameDetails("Nexon");
	}

	@When("user verifies fueltype name page")
	public void user_verifies_fueltype_name_page() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
		   CIP.brandNameDetails("Tata");
		   CIP.modelNamePage();
		   CIP.modelNameDetails("Nexon");
		   CIP.fuelTypePage();
	}

	@Then("user selects fueltype name")
	public void user_selects_fueltype_name() {
		   CIP.fuelTypeDetails("Petrol");
	}

	@When("user verifies variant name page")
	public void user_verifies_variant_name_page() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
		   CIP.brandNameDetails("Tata");
		   CIP.modelNamePage();
		   CIP.modelNameDetails("Nexon");
		   CIP.fuelTypePage();
		   CIP.fuelTypeDetails("Petrol");
		   CIP.variantTypePage();
	}

	@Then("user selects a variant name")
	public void user_selects_a_variant_name() {
		   CIP.variantTypeDetails();
	}
	
	@When("user clicks on final view prices button")
	public void user_clicks_on_final_view_prices_button() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
		   CIP.brandNameDetails("Tata");
		   CIP.modelNamePage();
		   CIP.modelNameDetails("Nexon");
		   CIP.fuelTypePage();
		   CIP.fuelTypeDetails("Petrol");
		   CIP.variantTypePage();
		   CIP.variantTypeDetails();
		   CIP.clickViewPrices();
	}

	@Then("capture error messages")
	public void capture_error_messages() throws IOException {
		System.out.println(CIP.nameErrorStatement());
		System.out.println(CIP.mailErrorStatement());
		System.out.println(CIP.phoneErrorStatement());
		excelUtils.setCellData(path,"SmokeOutput",2,0,CIP.nameErrorStatement());
		excelUtils.setCellData(path,"SmokeOutput",3,0,CIP.mailErrorStatement());
		excelUtils.setCellData(path,"SmokeOutput",4,0,CIP.phoneErrorStatement());


		
	}

	
	@When("user entered valid fullname, email and invalid phone")
	public void user_entered_valid_fullname_email_and_invalid_phone() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
		   CIP.brandNameDetails("Tata");
		   CIP.modelNamePage();
		   CIP.modelNameDetails("Nexon");
		   CIP.fuelTypePage();
		   CIP.fuelTypeDetails("Petrol");
		   CIP.variantTypePage();
		   CIP.variantTypeDetails();
		   CIP.enterName("arjun");
		   CIP.enterEmail("abc@gmail.com");
		   CIP.enterPhone("4567");
		   CIP.clickViewPrices();

	}

	@Then("capture error message invalid phone")
	public void capture_error_message_invalid_phone() throws IOException {
		System.out.println(CIP.phoneErrorStatement());
		excelUtils.setCellData(path,"SmokeOutput",5,0,CIP.phoneErrorStatement());

	}
	
	@When("user entered valid fullname, phone and invalid email")
	public void user_entered_valid_fullname_phone_and_invalid_email() {
		   CIP.newCar();
		   CIP.rtoPage();
		   CIP.rtoDetails("chennai");
		   CIP.brandNamePage();
		   CIP.brandNameDetails("Tata");
		   CIP.modelNamePage();
		   CIP.modelNameDetails("Nexon");
		   CIP.fuelTypePage();
		   CIP.fuelTypeDetails("Petrol");
		   CIP.variantTypePage();
		   CIP.variantTypeDetails();
		   CIP.enterName("arjun");
		   CIP.enterEmail("abcgail.com");
		   CIP.enterPhone("9875675678");
		   CIP.clickViewPrices();
	}
	@Then("capture error message invalid mail")
	public void capture_error_message_invalid_mail() throws IOException {
		System.out.println(CIP.mailErrorStatement());
		excelUtils.setCellData(path,"SmokeOutput",6,0,CIP.mailErrorStatement());

	    
	}
	
							//******HEALTH INSURANCE******//
	
	@Given("user clicked on policy bazar logo link2")
	public void user_clicked_on_policy_bazar_logo_link2() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		TIP=new TravelInsurancePage(driver);
	}

	@When("user navigated to homepage3")
	public void user_navigated_to_homepage3() {
		System.out.println(driver.getTitle());
		TIP.title();
		//Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", driver.getTitle()); 
	
	}

	@When("user clicked on insurance products dropdown")
	public void user_clicked_on_insurance_products_dropdown() {
		HIP.insuranceProducts();
	}

	@Then("store all the health insurance menu in the list")
	public void store_all_the_health_insurance_menu_in_the_list() throws IOException {
		List<WebElement> list=HIP.healthInsurnaceMenu();
		
		for(int i=0;i<list.size();i++) {
	        System.out.println(list.get(i).getText());
	    	excelUtils.setCellData(path,"SmokeOutput", i+1, 1,list.get(i).getText());

		}
	}

	@Given("user navigated to homepage")
	public void user_navigated_to_homepage() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		TIP = new TravelInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		TIP.title();
		//Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", driver.getTitle());
	}

	@When("user clicked on health insurance link and navigated to health insurance page")
	public void user_clicked_on_health_insurance_link_and_navigated_to_health_insurance_page() {
		HIP.healthInsurancePage();
		System.out.println(driver.getTitle());
		HIP.title();
		//Assert.assertEquals("Health Insurance: Compare & Buy Medical Insurance Plans @ ₹8/Day*", driver.getTitle());
	}

	@When("user clicked on more members button")
	public void user_clicked_on_more_members_button() {
		HIP.moreMembers();
	}

	@When("user clicks on select self as a member")
	public void user_clicks_on_select_self_as_a_member() {
		HIP.select_a_Member("self");
	}
	
	@Then("user clicks on continue1 button")
	public void user_clicks_on_continue1_button() {
		HIP.continue1Btn();

	}

	@Given("user navigated to age page")
	public void user_navigated_to_age_page() {
		driver=HelperClass.getDriver();
		HIP= new HealthInsurancePage(driver);
		System.out.println(driver.getTitle());
		HIP.insuranceProducts();
		HIP.healthInsurancePage();
		HIP.moreMembers();
		HIP.select_a_Member("self");
		HIP.continue1Btn();
		HIP.agePage();
	}

	@When("user selects age from drop down")
	public void user_selects_age_from_drop_down() {
		HIP.selectAge("28");
	}
	@Then("user clicks on continue2 button")
	public void user_clicks_on_continue2_button() {
		HIP.continue2Btn();

	}

	@Given("user navigated to city page")
	public void user_navigated_to_city_page() {
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
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		HIP.cityPage();
	}

	@Then("user selects city from drop down and clicks on continue3 button")
	public void user_selects_city_from_drop_down_and_clicks_on_continue3_button() {
		HIP.selectCity("Hyderabad(Telangana)");
	}

	@Given("user navigated to contact page")
	public void user_navigated_to_contact_page() {
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
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		HIP.cityPage();
		HIP.selectCity("Hyderabad(Telangana)");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HIP.contactPage();
	}
	
	@When("user enters valid name and phone number in textboxes")
	public void user_enters_valid_name_and_phone_number_in_textboxes() {
		HIP.enterName("ram");
		HIP.enterPhoneNumber("8798646474");
	}

	@Then("user clicks on continue4")
	public void user_clicks_on_continue4() {
		HIP.continue4Btn();

	}


}
