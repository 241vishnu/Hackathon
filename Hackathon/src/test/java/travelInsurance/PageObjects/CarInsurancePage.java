package travelInsurance.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CarInsurancePage extends BasePage {

	public CarInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	//policy bazaar icon
	@FindBy(xpath="//h1/a[contains(@href,\"policybazaar\")]")
	WebElement logo;
	
	//car insurance icon
	@FindBy(xpath="//div[2]/section/div[4]/a")
	WebElement CarInsuranceIcon;
	
	//car insurance page
	@FindBy(xpath="//*[@id=\"show_text\"]/h2")
	WebElement carInsurancePage;

	//view price button
	@FindBy(xpath="//*[@id=\"btnGetQuotes\"]")
	WebElement viewPrices;
	
	//error message web element
	@FindBy(xpath="//*[@id=\"error_car_number\"]")
	WebElement errorMessage;
	
	//new car button
	@FindBy(xpath="//*[@id=\"before-tp\"]/div[2]/a")
	WebElement newCar;
	
	//rto page
	@FindBy(xpath="//*[@id=\"dvRTO\"]/h3/span[2]")
	WebElement rtoPage;
	
	//RTO city list
	@FindBy(xpath="//*[@id=\"dvRTO\"]/div/ul/li")
	List<WebElement> RTOList;
	
	//car brand page
	@FindBy(xpath="//*[@id=\"dvMake\"]/h3/span[2]")
	WebElement carBrandpage;
	
	//car brand name list
	@FindBy(xpath="//*[@id=\"dvMake\"]/div/ul/div/li")
	List<WebElement> carBrand;
	
	//car model page
	@FindBy(xpath="//*[@id=\"dvModel\"]/h3/span[2]")
	WebElement carModelPage;
	
	//car model name list
	@FindBy(xpath="//ul[1]/div[@id=\"modelScroll\"]/li")
	List<WebElement> carModel;
	
	//car fuelType Page
	@FindBy(xpath="//*[@id=\"dvFuelType\"]/h3/span[2]")
	WebElement fuelTypePage;
	
	//car fuel type list
	@FindBy(xpath="//*[@id=\"dvFuelType\"]/ul/div/li")
	List<WebElement> fuelType;
	
	//car variant page
	@FindBy(xpath="//*[@id=\"dvVariant\"]/h3/span[2]")
	WebElement carVariantPage;
	
	//car variant selection
	@FindBy(xpath="//ul[1]/div[@id=\"variantScroll\"]/li")
	List<WebElement> carVariants;
	
	//contact page
	@FindBy(xpath="//*[@id=\"dvVariant\"]/h3/span[2]")
	WebElement contactPage;
	
	//user name
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement name;
	
	//user email
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	
	//user phone number
	@FindBy(xpath="//*[@id=\"mobileNo\"]")
	WebElement phone;
	
	//final view prices button
	@FindBy(xpath="//*[@id=\"btnLeadDetails\"]")
	WebElement viewprices2;
	
	//user name error
	@FindBy(xpath="//*[@id=\"dvVariant\"]/div[2]/div[1]/div[1]/div[1]")
	WebElement nameError;
	
	//mail error msg
	@FindBy(xpath="//*[@id=\"dvVariant\"]/div[2]/div[1]/div[2]/div[2]")
	WebElement mailError;
	
	//phone erro msg
	@FindBy(xpath="//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[1]")
	WebElement phoneError;
	
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    public void title() {
    	String t = "PolicyBazaar Car Insurance: Insure Your Car Today";
    	Assert.assertEquals(t,driver.getTitle().toString());
    }
    
    //method to navigate back to homepage
    public void logoclick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    	js.executeScript("arguments[0].click();", logo);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

	//method for navigating to car insurance page
	public void carInsuranceIcon() {
		
		js.executeScript("arguments[0].click();", CarInsuranceIcon);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void carInsurancePage() {
		if(carInsurancePage.getText().contains("on Car Insurance")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void viewPrices() {
		
		js.executeScript("arguments[0].click();", viewPrices);

	}
	
	public String errorPage() {
		return errorMessage.getText();
	}

	public void newCar() {
		js.executeScript("arguments[0].click();", newCar);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}
	
	public void rtoPage() {
		Assert.assertEquals(rtoPage.getText(),"Select City & RTO");
	}
	
	public void rtoDetails(String RTOCity) {
		//RTO city selection
		for(int i=1;i<=RTOList.size();i++) {
			WebElement city=driver.findElement(By.xpath("//*[@id=\"dvRTO\"]/div/ul/li["+i+"]/span[2]"));
			String cityName=city.getText().toString();
			if(cityName.equalsIgnoreCase(RTOCity)){
				js.executeScript("arguments[0].click();", city);
				WebElement RTOnumber=driver.findElement(By.xpath("//*[@id=\"dvRTO\"]/div/ul/li["+i+"]/div/ul/li[1]/span"));
				js.executeScript("arguments[0].click();", RTOnumber);
				break;
			}
					
		}
		
	}
	
	public void brandNamePage() {
		Assert.assertEquals(carBrandpage.getText(),"Select Car Brand");
	}
	
	public void brandNameDetails(String carbrand) {
		//car brand name selection
		for(int i=1;i<=carBrand.size();i++) {
			WebElement brand=driver.findElement(By.xpath("//*[@id=\"dvMake\"]/div/ul/div/li["+i+"]/span"));
			if(brand.getText().toString().equalsIgnoreCase(carbrand)){
				js.executeScript("arguments[0].click();", brand);
				break;
			}
		}
		
	}
	
	public void modelNamePage() {
		Assert.assertEquals(carModelPage.getText(),"Select Car Model");	
	}
	
	public void modelNameDetails(String model) {
		//car model name selection
		for(int i=1;i<=carModel.size();i++) {
			WebElement modelName=driver.findElement(By.xpath("//ul[1]/div[@id=\"modelScroll\"]/li["+i+"]/span"));
			if(modelName.getText().toString().equalsIgnoreCase(model)) {
				js.executeScript("arguments[0].click();", modelName);
				break;
			}
		}

		
	}
	
	public void fuelTypePage() {
		Assert.assertEquals(fuelTypePage.getText(),"Select Car Fuel Type");	
	}
	
	public void fuelTypeDetails(String fuel) {
		//car fuel type selection
		for(int i=1;i<=fuelType.size();i++) {
			WebElement fuelName=driver.findElement(By.xpath("//*[@id=\"dvFuelType\"]/ul/div/li["+i+"]/span"));
			if(fuelName.getText().toString().equalsIgnoreCase(fuel)) {
				js.executeScript("arguments[0].click();", fuelName);
				break;
			}
		}
		
	}
	
	public void variantTypePage() {
		Assert.assertEquals(carVariantPage.getText(),"Select Car Variant");	

	}
	
	public void variantTypeDetails() {
		//car variant selection
		for(int i=1;i<=carVariants.size();i++) {
			WebElement variantName=driver.findElement(By.xpath("//ul[1]/div[@id=\"variantScroll\"]/li["+i+"]/span"));
			if(variantName.getText().toString().equalsIgnoreCase("Creative 1.2 Revotron Petrol 6MT (1199 cc)")) {
				js.executeScript("arguments[0].click();", variantName);
				break;
			}
	    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	public void contactsPage() {
		Assert.assertEquals(contactPage.getText(), "Please Fill Your Details");
		
	}
	
	public void enterName(String Name) {
		name.clear();
		name.sendKeys(Name);

		
	}
	public void enterEmail(String Email) {
		email.clear();
		email.sendKeys(Email);	
	}
	
	public  void enterPhone(String mobile) {
		phone.clear();
		phone.sendKeys(mobile);
	}
	public void clickViewPrices() {
		js.executeScript("arguments[0].click();", viewprices2);

	}
	
	public String nameErrorStatement() {
		return nameError.getText();
	}
	
	public String mailErrorStatement() {
		return mailError.getText();
	}
	
	public String phoneErrorStatement() {
		return phoneError.getText();
	}
	
	




	
	


}
