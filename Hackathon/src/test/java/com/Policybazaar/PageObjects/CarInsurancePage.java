package com.Policybazaar.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CarInsurancePage extends BasePage {

	public CarInsurancePage(WebDriver driver) {
		super(driver);
	}

	// policy bazaar icon
	@FindBy(xpath = "//h1/a[contains(@href,\"policybazaar\")]")
	WebElement logo;
	
	// insurance products link
	@FindBy(xpath = "//a[normalize-space()='Insurance Products']")
	WebElement InsuranceProduct;

	// car insurance icon
	@FindBy(xpath = "//a[@class='headlink'][normalize-space()='Car Insurance']")
	WebElement CarInsuranceIcon;

	// car insurance page
	@FindBy(xpath = "//*[@id=\"step-one-pq\"]/div/div/div[1]/span[1]")
	WebElement carInsurancePage;

	// view price button
	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement viewPrices;
	
	// error message web element
	@FindBy(xpath = "//*[@id=\"step-one-pq\"]/div/div/div[2]/div[2]/div/div[2]")
	WebElement errorMessage;

	// new car button
	@FindBy(xpath = "(//form[@id=\"frmCar\"]//div[@class=\"other-options new-car no-brd\"]/button)[1]")
	WebElement newCar;

	// rto page
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[2]/span[1]")
	WebElement rtoPage;

	// RTO city list
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[3]/div[2]/div[2]/div")
	List<WebElement> RTOList;

	// car brand page
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[2]/span[1]")
	WebElement carBrandpage;

	// car brand name list
	@FindBy(xpath = "//div[@class='car-prequote-brands']//ul[@class='make']/li")
	List<WebElement> carBrand;

	// car model page
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[2]/span[1]")
	WebElement carModelPage;

	// car model name list
	@FindBy(xpath = "//ul[@class='model-wise']/li")
	List<WebElement> carModel;

	// car fuelType Page
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[2]/span[1]")
	WebElement fuelTypePage;

	// car fuel type list
	@FindBy(xpath = "(//ul[@class='fuelwise'])[1]/li")
	List<WebElement> fuelType;

	// car variant page
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[2]/span[1]")
	WebElement carVariantPage;

	// car variant selection
	@FindBy(xpath = "//ul[@class='model-wise variant']/li")
	List<WebElement> carVariants;

	// contact page
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[2]/span[1]")
	WebElement contactPage;

	// user name
	@FindBy(xpath = "//*[@id=\"txtName\"]")
	WebElement name;

	// user email
	@FindBy(xpath = "//input[@id='txtEmail']")
	WebElement email;

	// user phone number
	@FindBy(xpath = "//input[@id='mobNumber']")
	WebElement phone;

	// final view prices button
	@FindBy(xpath = "//div[normalize-space()='View Prices']")
	WebElement viewprices2;

	// user name error
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[3]/div[9]/div[2]/div/div[2]")
	WebElement nameError;

	// mail error msg
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[3]/div[9]/div[2]/div/div[4]")
	WebElement mailError;

	// phone erro msg
	@FindBy(xpath = "//*[@id=\"pre-quote\"]/div[2]/div[3]/div[9]/div[2]/div/div[5]/div[2]")
	WebElement phoneError;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	Actions action = new Actions(driver);



	// method to get title of the page
	public void title() {
		String t = "Car Insurance Online";
		if (driver.getTitle().contains(t)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	// method to navigate back to homepage
	public void inusranceshover() {
	
		action.moveToElement(InsuranceProduct).perform();

	}

	// method for navigating to car insurance page
	public void carInsuranceIcon() {

		js.executeScript("arguments[0].click();", CarInsuranceIcon);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// method to verify the car insurance page
	public void carInsurancePage() {
			if (carInsurancePage.getText().contains("Get Car Insurance")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	
	}

	// method to click view prices
	public void viewPrices() {

			js.executeScript("arguments[0].click();", viewPrices);
	}

	// method to get error msg
	public String errorPage() {
	
		return errorMessage.getText();
		
	}

	// method to click on new car button
	public void newCar() {
		wait.until(ExpectedConditions.elementToBeClickable(newCar));
		action.click(newCar).build().perform();
	}

	// method to verify rto page
	public void rtoPage() {
		wait.until(ExpectedConditions.visibilityOf(rtoPage));
		Assert.assertEquals(rtoPage.getText(), "Select City & RTO");
		
	}

	// method to fill rto details
	public void rtoDetails(String RTOCity) {
		// RTO city selection	
			for (int i = 1; i <= RTOList.size(); i++) {
			WebElement city = driver.findElement(By.xpath("//*[@id=\"pre-quote\"]/div[2]/div[3]/div[2]/div[2]/div["+i+"]/div[1]"));
			String cityName = city.getText().toString();
			if (cityName.equalsIgnoreCase(RTOCity)) {
				js.executeScript("arguments[0].click();", city);
				WebElement RTOnumber = driver
						.findElement(By.xpath("//*[@id=\"pre-quote\"]/div[2]/div[3]/div[2]/div[2]/div["+i+"]/div[2]/ul/li[1]/label"));
				js.executeScript("arguments[0].click();", RTOnumber);
				break;
			}
			}
	}

	// method to verify brand name
	public void brandNamePage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(carBrandpage));
		Assert.assertEquals(carBrandpage.getText(), "Select Car Brand");
	
		}

	// method to fill brand details
	public void brandNameDetails(String carbrand) {
		// car brand name selection
		for (int i = 1; i <= carBrand.size(); i++) {
			WebElement brand = driver.findElement(By.xpath("//div[@class='car-prequote-brands']//ul[@class='make']/li["+i+"]//span[2]"));
			if (brand.getText().toString().equalsIgnoreCase(carbrand)) {
				js.executeScript("arguments[0].click();", brand);
				break;
			}
		}
	}

	// method to verify model name page
	public void modelNamePage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(carModelPage));
		Assert.assertEquals(carModelPage.getText(), "Select Car Model");
			
		
	}

	// method to fill model details
	public void modelNameDetails(String model) {
		// car model name selection		
		for (int i = 1; i <= carModel.size(); i++) {
			WebElement modelName = driver.findElement(By.xpath("//ul[@class='model-wise']/li["+i+"]//span"));
			if (modelName.getText().toString().equalsIgnoreCase(model)) {
				js.executeScript("arguments[0].click();", modelName);
				break;
			}
		}
		
	}

	// method to verify fuel type page
	public void fuelTypePage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(fuelTypePage));
		Assert.assertEquals(fuelTypePage.getText(), "Select Car Fuel Type");
			
	}

	// method to fill fuel details
	public void fuelTypeDetails(String fuel) {
		// car fuel type selection
		for (int i = 1; i <= fuelType.size(); i++) {
			WebElement fuelName = driver.findElement(By.xpath("(//ul[@class='fuelwise'])[1]/li["+i+"]//span"));
			if (fuelName.getText().toString().equalsIgnoreCase(fuel)) {
				js.executeScript("arguments[0].click();", fuelName);
				break;
			}
		}
		

	}

	// method to verify variant page
	public void variantTypePage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(carVariantPage));	
		Assert.assertEquals(carVariantPage.getText(), "Select Car Variant");
	}

	// method to fill variant type details
	public void variantTypeDetails() {
		// car variant selection		
		driver.findElement(By.xpath("//label[@data-id=\"6570\"]")).click();

	}

	// method to verify contact page
	public void contactsPage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(contactPage));
		Assert.assertEquals(contactPage.getText(), "Please Fill Your Details");
	}

	// method to enter name
	public void enterName(String Name) {
		name.clear();
		name.sendKeys(Name);
		
	}

	// method to enter email
	public void enterEmail(String Email) {
		
			email.clear();
		email.sendKeys(Email);
		
	}

	// method to enter phone number
	public void enterPhone(String mobile) {
	
		phone.clear();
		phone.sendKeys(mobile);
		
	}

	// method to click view prices at last of page
	public void clickViewPrices() {
		
		js.executeScript("arguments[0].click();", viewprices2);
		

	}

	// method to get name error
	public String nameErrorStatement() {
		
		return nameError.getText();
		
	}

	// method to get email error
	public String mailErrorStatement() {
		
		return mailError.getText();
		
		}

	// method to get phone number error
	public String phoneErrorStatement() {
	
		return phoneError.getText();
		
	}

}