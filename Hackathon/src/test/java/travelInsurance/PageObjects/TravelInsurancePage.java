package travelInsurance.PageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TravelInsurancePage extends BasePage {

	public TravelInsurancePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// travel Insurance icon
	@FindBy(xpath = "//div[2]/section/div[7]/a")
	WebElement icon;

	// Destinations page
	@FindBy(xpath = "//div[@class=\"stepper\"]/ul/li[1]/span")
	WebElement Destinations;

	// Destination country
	@FindBy(xpath = "//*[@id=\"country\"]")
	WebElement DestinationCountry;

	// Destination search list
	@FindBy(xpath = "//*[@id=\"search-country\"]/ul/li")
	WebElement searchlist;

	// proceed to trip date by next button
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement NextButton;

	// Trip date page
	@FindBy(xpath = "//div[@class=\"stepper\"]/ul/li[2]/span")
	WebElement TripDate;

	// start date
	@FindBy(xpath = "//div[@class='MuiPickersDateRangePickerInput-root']//div[1]//div[1]//div[1]//input[1]")
	WebElement fromd;

	// from month and year head
	@FindBy(xpath = "//div[1]/div[1]/h6")
	WebElement fromMonthHead;

	// list of all start dates
	@FindBy(xpath = "//div[1]/div/div/div/div/div/button[@data-mui-test=\"DateRangeDay\"]/span[1]")
	List<WebElement> fromdatelists;

	// End month and year head
	@FindBy(xpath = "//div[2]/div[1]/h6")
	WebElement toMonthHead;

	// list of all end dates
	@FindBy(xpath = "//div[2]/div/div/div/div/div/button[@data-mui-test=\"DateRangeDay\"]/span[1]")
	List<WebElement> todatelists;

	// proceed to travellers page next button
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement ProceedToTravellers;

	// Travellers page
	@FindBy(xpath = "//div[@class=\"stepper\"]/ul/li[3]/span")
	WebElement Travellers;

	// no.of travellers
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[1]/div/input")
	List<WebElement> NoOfTravellers;

	// traveller1 details
	@FindBy(xpath = "//div[1]/div/div/div/div[@id=\"divarrow_undefined\"]")
	WebElement Traveller1;

	// traveller1 age
	@FindBy(xpath = "//*[@id=\"21 years_undefined\"]")
	WebElement Traveller1Age;

	// traveller2 details
	@FindBy(xpath = "//div[2]/div/div/div/div[@id=\"divarrow_undefined\"]")
	WebElement Traveller2;

	// traveller2 age
	@FindBy(xpath = "//*[@id=\"22 years_undefined\"]")
	WebElement Traveller2Age;

	// proceed to medical history next button
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement proceedToMedicalHistory;

	// Medical history page
	@FindBy(xpath = "//div[@class=\"stepper\"]/ul/li[4]/span")
	WebElement MedicalHistory;

	// click on no medical history
	@FindBy(xpath = "//*[@id=\"ped_no\"]")
	WebElement NoMedicalHistory;

	// proceed to contact details next Button
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement proceedToContactDetails;

	// contact details page
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/ul/li[5]/span")
	WebElement ContactDetails;

	// phone number in text box
	@FindBy(xpath = "//*[@id=\"mobileNumber\"]")
	WebElement phone;
	// error msg in contact page
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/p")
	WebElement errorMsg;
	// whatsapp slider
	@FindBy(xpath = "//*[@id=\"whatsapp-updates\"]")
	WebElement whatsappCheckbox;

	// view plans button
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/div/button")
	WebElement viewplans;

	// plantype button in the filter
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/aside/section[3]/details[1]/summary")
	WebElement plantype;

	// student plan radio button in filter
	@FindBy(xpath = "//*[@id=\"studentTrip\"]")
	WebElement StudentPlan;

	// selecting traveller 1 checkbox
	@FindBy(xpath = "//*[@id=\"Traveller_1\"]")
	WebElement taveller1;

	// selecting traveller 2 checkbox
	@FindBy(xpath = "//*[@id=\"Traveller_2\"]")
	WebElement taveller2;

	// no of days in select list
	@FindBy(xpath = "//*[@id=\"feet\"]")
	WebElement noOfDays;

	// apply button in the filter
	@FindBy(xpath = "//*[@id=\"amt-modal\"]/div[3]/button")
	WebElement apply;

	// sort by button in the filter
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary")
	WebElement sortBy;

	// low to high radio button in filter
	@FindBy(xpath = "//*[@id=\"17_sort\"]")
	WebElement LowToHigh;

	// policy bazaar icon
	@FindBy(xpath = "//h1/a[contains(@href,\"policybazaar\")]")
	WebElement logo;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// method to assert with title
	public void title() {
		String t = "Health, Term, Life, Car";
		if (driver.getTitle().contains(t)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	// method to click on travel insuranc icon
	public void travelInsuranceIcon() {
		icon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	// method to verify the destination page
	public void destinationPage() {
		System.out.println(Destinations.getText());
		Assert.assertEquals("#36b37e", BasePage.hexColor(Destinations));
	}

	// method to send destination details
	public void destinationDetails(String CountryName) {
		DestinationCountry.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		DestinationCountry.sendKeys(CountryName);
	}

	// method to click on suggested one
	public void DestinationDropDown() {
		searchlist.click();
		NextButton.click();
	}

	// method to verify the tripdate page
	public void tripDatePage() {
		System.out.println(TripDate.getText());
		Assert.assertEquals("#36b37e", BasePage.hexColor(TripDate));
	}

	// method to enter the dates
	public void tripEnterDates() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		js.executeScript("arguments[0].click();", fromd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		Calendar fromDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("d");

		String fromMonthYear = formatter.format(fromDate.getTime());
		String from_Date = formatter1.format(fromDate.getTime());

		if (fromMonthHead.getText().toString().equals(fromMonthYear)) {
			for (WebElement ele : fromdatelists) {
				if (ele.getText().toString().equals(from_Date)) {
					ele.click();
					break;
				}
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		fromDate.add(Calendar.DAY_OF_MONTH, 30);
		String toMonthYear = formatter.format(fromDate.getTime());
		String to_Date = formatter1.format(fromDate.getTime());

		WebElement toMonthHead = driver.findElement(By.xpath("//div[2]/div[1]/h6"));

		if (toMonthHead.getText().toString().equals(toMonthYear)) {
			for (WebElement ele : todatelists) {
				if (ele.getText().toString().equals(to_Date)) {
					ele.click();
					break;
				}
			}
		}
	}

	// method to clik on proceed to travellers button
	public void navigateTotravellPage() {
		js.executeScript("arguments[0].click();", ProceedToTravellers);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	// method to verify the travellers page
	public void travellersPage() {
		System.out.println(Travellers.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals("#36b37e", BasePage.hexColor(Travellers));
	}

	// method to fill the number of travellers
	public void no_of_Travellers(String n) {
		for (WebElement ele : NoOfTravellers) {
			if (ele.getAttribute("value").toString().equals(n)) {
				js.executeScript("arguments[0].click();", ele);
				break;
			}
		}

	}

	// method to select travellers age
	public void travellerDetails() {

		js.executeScript("arguments[0].click();", Traveller1);

		js.executeScript("arguments[0].click();", Traveller1Age);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		js.executeScript("arguments[0].click();", Traveller2);
		js.executeScript("arguments[0].click();", Traveller2Age);

	}

	// method to click on proceed to medical history button
	public void navigatToMedicalHistoryPage() {
		js.executeScript("arguments[0].click();", proceedToMedicalHistory);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	// method to verify the medical history page
	public void medicalHistoryPage() {
		System.out.println(MedicalHistory.getText());
		Assert.assertEquals("#36b37e", BasePage.hexColor(MedicalHistory));
	}

	// method to click on no check box in medical history
	public void checkMedicalHistory() {
		js.executeScript("arguments[0].click();", NoMedicalHistory);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	// method to click in navigate to contact details page
	public void navigateToContactDetailsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Next']")));
		js.executeScript("arguments[0].click();", proceedToContactDetails);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// method to verify the contact details
	public void contactDetailsPage() {
		System.out.println(ContactDetails.getText());
		// Assert.assertEquals("#36b37e", BasePage.hexColor(ContactDetails));
	}

	// method to enter phone number
	public void enterMobileNumber(String phonenumber) {
		phone.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		phone.sendKeys(phonenumber);
	}

	// method to get error msg
	public String error() {
		return errorMsg.getText();
	}

	// method to click on whatsapp slider
	public void whatsapp() {
		js.executeScript("arguments[0].click();", whatsappCheckbox);

	}

	// method to click on view plans
	public void viewPlans() {

		js.executeScript("arguments[0].click();", viewplans);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	// method to verify results page
	public void resultsPage() {
		String results = driver.findElement(By.xpath("//h2[contains(text(),\"Showing\")]")).getText();
		if (results.contains("Showing")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	// method to select student plan type
	public void planType() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		js.executeScript("arguments[0].click();", plantype);
		js.executeScript("arguments[0].click();", StudentPlan);
	}

	// method to confirm the travellers and no.of days
	public void travellersConfirmation() {
		js.executeScript("arguments[0].click();", taveller1);
		js.executeScript("arguments[0].click();", taveller2);
		js.executeScript("arguments[0].click();", noOfDays);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		Select se = new Select(noOfDays);
		se.selectByValue("1");
		js.executeScript("arguments[0].click();", apply);

	}

	// method to sort
	public void sortby() {

		js.executeScript("arguments[0].click();", sortBy);
		js.executeScript("arguments[0].click();", LowToHigh);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}

	// method for sorted results
	public HashMap<String, String> collectResults() {
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			js.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/span")));

		} catch (Exception e) {

		}
		// lowest three plans with plan providers
		for (int i = 1; i <= 3; i++) {
			String planPrice = driver
					.findElement(By
							.xpath("//*[@id=\"root\"]/div/div[2]/section/article[" + i + "]/div/div/div/div[3]/p/span"))
					.getText();

			String planProvider = driver
					.findElement(By.xpath(
							"//*[@id=\"root\"]/div/div[2]/section/article[" + i + "]/div/div/div/div[1]/div/p[1]"))
					.getText();
			result.put(planPrice, planProvider);
		}
		return (result);

	}

	// method to click logo icon
	public void logoclick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		js.executeScript("arguments[0].click();", logo);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
}
