
package com.hackathon;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Insurances {
	public static WebDriver driver;

	public void driversetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
	}

	public void travelInsurance() {
		// assertion with the title
		Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", driver.getTitle());
		WebElement icon = driver.findElement(By.xpath("//div[2]/section/div[7]/a"));
		icon.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println(driver.getTitle());

		// assertion with destination page
		WebElement Destinations = driver.findElement(By.xpath("//div[@class=\"stepper\"]/ul/li[1]/span"));
		System.out.println(Destinations.getText());
		// provide color in rgba
		String s = Destinations.getCssValue("color");
		// convert rgba to hex
		String c = Color.fromString(s).asHex();
		Assert.assertEquals("#36b37e", c);

		WebElement DestinationCountry = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		DestinationCountry.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		DestinationCountry.sendKeys("United kingdom");

		WebElement searchlist = driver.findElement(By.xpath("//*[@id=\"search-country\"]/ul/li"));
		searchlist.click();

		WebElement NextButton = driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button"));
		NextButton.click();

		// assertion with tripdate page
		WebElement TripDate = driver.findElement(By.xpath("//div[@class=\"stepper\"]/ul/li[2]/span"));
		System.out.println(TripDate.getText());
		// provide color in rgba
		String s1 = TripDate.getCssValue("color");
		// convert rgba to hex
		String c1 = Color.fromString(s1).asHex();
		Assert.assertEquals("#36b37e", c1);

		//start date
		WebElement fromd = driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input"));
		fromd.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("d");

		Calendar fromDate = Calendar.getInstance();
		String fromMonthYear = formatter.format(fromDate.getTime());
		String from_Date = formatter1.format(fromDate.getTime());
		WebElement fromMonthHead = driver.findElement(By.xpath("//div[1]/div[1]/h6"));
	
		List<WebElement> fromdatelist=driver.findElements(By.xpath("//div[1]/div/div/div/div/div/button[@data-mui-test=\"DateRangeDay\"]/span[1]"));
        if(fromMonthHead.getText().toString().equals(fromMonthYear)) {
        	for(WebElement ele:fromdatelist) {
        		if(ele.getText().toString().equals(from_Date)) {
        			ele.click();
        			break;
        		}
        	}
        }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//end date
		fromDate.add(Calendar.DAY_OF_MONTH, 30);
		String toMonthYear = formatter.format(fromDate.getTime());
		String to_Date=formatter1.format(fromDate.getTime());

		WebElement toMonthHead=driver.findElement(By.xpath("//div[2]/div[1]/h6"));
		
		List<WebElement> todatelist=driver.findElements(By.xpath("//div[2]/div/div/div/div/div/button[@data-mui-test=\"DateRangeDay\"]/span[1]"));
        if(toMonthHead.getText().toString().equals(toMonthYear)) {
        	for(WebElement ele:todatelist) {
        		if(ele.getText().toString().equals(to_Date)) {
        			ele.click();
        			break;
        		}
        	}
        }
		//proceed to travellers
		WebElement ProceedToTravellers=driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button"));
        ProceedToTravellers.click();
        
     // assertion with travellers page
     		WebElement Travellers = driver.findElement(By.xpath("//div[@class=\"stepper\"]/ul/li[3]/span"));
     		System.out.println(Travellers.getText());
     		// provide color in rgba
     		String s2 = Travellers.getCssValue("color");
     		// convert rgba to hex
     		String c2 = Color.fromString(s2).asHex();
     		Assert.assertEquals("#36b37e", c2);
    
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

     		
     //no.of travellers
     WebElement NoOfTravellers=driver.findElement(By.xpath("//*[@id=\"traveller_2\"]"));
     //NoOfTravellers.click();
     JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", NoOfTravellers);
	//traveller1 details
     WebElement Traveller1=driver.findElement(By.xpath("//div[1]/div/div/div/div[@id=\"divarrow_undefined\"]"));
     Traveller1.click();
     WebElement Traveller1Age=driver.findElement(By.xpath("//*[@id=\"21 years_undefined\"]"));
		js.executeScript("arguments[0].click();", Traveller1Age);

     //traveller2 details
     WebElement Traveller2 =driver.findElement(By.xpath("//div[2]/div/div/div/div[@id=\"divarrow_undefined\"]"));
     Traveller2.click();
     WebElement Traveller2Age=driver.findElement(By.xpath("//*[@id=\"22 years_undefined\"]"));
		js.executeScript("arguments[0].click();", Traveller2Age);
	//proceed to medical history
	 WebElement proceedToMedicalHistory=driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button"));
		js.executeScript("arguments[0].click();", proceedToMedicalHistory);
		
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	  // assertion with medical history page
  		WebElement MedicalHistory = driver.findElement(By.xpath("//div[@class=\"stepper\"]/ul/li[4]/span"));
  		System.out.println(MedicalHistory.getText());
  		// provide color in rgba
  		String s3 = MedicalHistory.getCssValue("color");
  		// convert rgba to hex
  		String c3 = Color.fromString(s3).asHex();
  		Assert.assertEquals("#36b37e", c3);
  		//click on no medical history
  		WebElement NoMedicalHistory=driver.findElement(By.xpath("//*[@id=\"ped_no\"]"));
		js.executeScript("arguments[0].click();", NoMedicalHistory);
		//proceed to contact details
		 WebElement proceedToContactDetails=driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button"));
			js.executeScript("arguments[0].click();", proceedToContactDetails);
  		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		// assertion with contact details page
	  		WebElement ContactDetails = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/ul/li[5]/span"));
	  		System.out.println(ContactDetails.getText());
	  		// provide color in rgba
	  		String s4 = ContactDetails.getCssValue("color");
	  		// convert rgba to hex
	  		String c4 = Color.fromString(s4).asHex();
	  		//System.out.println(c4);
	  		//Assert.assertEquals("#36b37e", c4);
	  		
	  	//entering a phone number in text box
	  	WebElement phone=driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]"));
	  	phone.sendKeys("9478942341");
	  	//click on checkbox to deselect the whatsapp updates
	  	js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"whatsapp-updates\"]")));
	  	
	  	//click on view plans
	  	WebElement viewplans=driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/div/button"));
	  	js.executeScript("arguments[0].click();", viewplans);
	  	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 //click on plantype in the filter
	  	WebElement plantype=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/section[3]/details[1]/summary"));
	  	js.executeScript("arguments[0].click();",plantype );
		
	  	//selecting student plan in filter
	  	WebElement StudentPlan=driver.findElement(By.xpath("//*[@id=\"studentTrip\"]"));
	  	js.executeScript("arguments[0].click();", StudentPlan);
    
	  	//selecting traveller 1
	  	WebElement taveller1=driver.findElement(By.xpath("//*[@id=\"Traveller_1\"]"));
	  	js.executeScript("arguments[0].click();", taveller1);

		//selecting traveller 2
	  	WebElement taveller2=driver.findElement(By.xpath("//*[@id=\"Traveller_2\"]"));
	  	js.executeScript("arguments[0].click();", taveller2);

		//click on no of days
	  	WebElement noOfDays=driver.findElement(By.xpath("//*[@id=\"feet\"]"));
	  	js.executeScript("arguments[0].click();", noOfDays);
	  	//selecting 30 days by option value i.e,1
	  	Select se=new Select(noOfDays);
	  	se.selectByValue("1");

	  	//click on apply filter
	  	WebElement apply=driver.findElement(By.xpath("//*[@id=\"amt-modal\"]/div[3]/button"));
	  	js.executeScript("arguments[0].click();", apply);

		
		//click on sort by
	  	WebElement sortBy=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary"));
	  	js.executeScript("arguments[0].click();", sortBy);

		//selecting low to high in filter
	  	WebElement LowToHigh=driver.findElement(By.xpath("//*[@id=\"17_sort\"]"));
	  	js.executeScript("arguments[0].click();", LowToHigh);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		try {
		  	js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/span")));

		}
		catch(Exception e) {
			
		}
	  //lowest three plans with plan providers
	  for(int i=1;i<=3;i++){
		  String planPrice=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/article["+i+"]/div/div/div/div[3]/p/span")).getText();
	  
		  String planProvider=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/article["+i+"]/div/div/div/div[1]/div/p[1]")).getText();
		System.out.println(planPrice+" & "+planProvider);
	  }

	  
	  
	}

	public void carInsurance() {
	     JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement logo= driver.findElement(By.xpath("//h1/a[contains(@href,\"policybazaar\")]"));
		js.executeScript("arguments[0].click();", logo);
		
		WebElement CarInsuranceIcon=driver.findElement(By.xpath("//div[2]/section/div[4]/a"));
		js.executeScript("arguments[0].click();", CarInsuranceIcon);
		
		WebElement viewPrices=driver.findElement(By.xpath("//*[@id=\"btnGetQuotes\"]"));
		js.executeScript("arguments[0].click();", viewPrices);
		
		String errorMessage=driver.findElement(By.xpath("//*[@id=\"error_car_number\"]")).getText();
		System.out.println(errorMessage);
		
		WebElement newCar=driver.findElement(By.xpath("//*[@id=\"before-tp\"]/div[2]/a"));
		js.executeScript("arguments[0].click();", newCar);
		
		//RTO city selection
		List<WebElement> RTOList=driver.findElements(By.xpath("//*[@id=\"dvRTO\"]/div/ul/li"));
		for(int i=1;i<=RTOList.size();i++) {
			
				WebElement city=driver.findElement(By.xpath("//*[@id=\"dvRTO\"]/div/ul/li["+i+"]/span[2]"));
				String cityName=city.getText().toString();
				if(cityName.equalsIgnoreCase("chennai")){
					js.executeScript("arguments[0].click();", city);
					WebElement RTOnumber=driver.findElement(By.xpath("//*[@id=\"dvRTO\"]/div/ul/li["+i+"]/div/ul/li[1]/span"));
					js.executeScript("arguments[0].click();", RTOnumber);
					break;
				}
			
		}
		
		//car brand name selection
		List<WebElement> carBrand=driver.findElements(By.xpath("//*[@id=\"dvMake\"]/div/ul/div/li"));
		for(int i=1;i<=carBrand.size();i++) {
			WebElement brand=driver.findElement(By.xpath("//*[@id=\"dvMake\"]/div/ul/div/li["+i+"]/span"));
			if(brand.getText().toString().equalsIgnoreCase("Tata")) {
				js.executeScript("arguments[0].click();", brand);
				break;
			}
		}
		
		//car model name selection
		List<WebElement> carModel=driver.findElements(By.xpath("//ul[1]/div[@id=\"modelScroll\"]/li"));
		for(int i=1;i<=carModel.size();i++) {
			WebElement modelName=driver.findElement(By.xpath("//ul[1]/div[@id=\"modelScroll\"]/li["+i+"]/span"));
			if(modelName.getText().toString().equalsIgnoreCase("Nexon")) {
				js.executeScript("arguments[0].click();", modelName);
				break;
			}
		}
		
		//car fuel type selection
		List<WebElement> fuelType= driver.findElements(By.xpath("//*[@id=\"dvFuelType\"]/ul/div/li"));
		for(int i=1;i<=fuelType.size();i++) {
		WebElement fuelName=driver.findElement(By.xpath("//*[@id=\"dvFuelType\"]/ul/div/li["+i+"]/span"));
		if(fuelName.getText().toString().equalsIgnoreCase("Petrol")) {
			js.executeScript("arguments[0].click();", fuelName);
			break;
			}
	    }
		
		//car variant selection
		List<WebElement> carVariants=driver.findElements(By.xpath("//ul[1]/div[@id=\"variantScroll\"]/li"));
		for(int i=1;i<=carVariants.size();i++) {
			WebElement variantName=driver.findElement(By.xpath("//ul[1]/div[@id=\"variantScroll\"]/li["+i+"]/span"));
			if(variantName.getText().toString().equalsIgnoreCase("Creative 1.2 Revotron Petrol 6MT (1199 cc)")) {
				js.executeScript("arguments[0].click();", variantName);
				break;
				}
		    }
		
		WebElement name=driver.findElement(By.xpath("//*[@id=\"name\"]"));
		name.sendKeys("arjun");
		
		WebElement email=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("abcgmail.com");
		
		WebElement phone=driver.findElement(By.xpath("//*[@id=\"mobileNo\"]"));
		phone.sendKeys("9876545678");
		
		String errorMsg= driver.findElement(By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[2]/div[2]")).getText();
		System.out.println(errorMsg);
		
	}
	
	public void healthInsurance() {
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	     
		WebElement logo1= driver.findElement(By.xpath("//a[@class=\"pb-logo\"]"));
		js.executeScript("arguments[0].click();", logo1);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		WebElement InsuranceProduct=driver.findElement(By.xpath("//div[4]/div[2]/div/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(InsuranceProduct).perform();
		
		WebElement HealthInsurance= driver.findElement(By.xpath("//h3/a[contains(@href,\"https://www.policybazaar.com/health-insurance/\")]"));
		List<WebElement> HealthInsuranceMenu=driver.findElements(By.xpath("//div/ul/li[2]/div/div/div[3]/ul/li/a/span"));
		
		for(WebElement ele:HealthInsuranceMenu ) {
	        System.out.println(ele.getText());
		}
		js.executeScript("arguments[0].click();", HealthInsurance);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
		WebElement moreMembers= driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li[11]/span"));
															
		js.executeScript("arguments[0].click();", moreMembers);

		List<WebElement> members =driver.findElements(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li/input")); 
		for(int i=1;i<=members.size();i++) {
			WebElement memberName=driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li["+i+"]/input"));
			if(memberName.getAttribute("value").toString().equalsIgnoreCase("self")) {
				js.executeScript("arguments[0].click();", memberName);
				break;
				}
		    }

		WebElement ContinueButton1 = driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[3]/div"));
		js.executeScript("arguments[0].click();", ContinueButton1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement Age= driver.findElement(By.xpath("//*[@id=\"name_feild\"]/select"));
		js.executeScript("arguments[0].click();", Age);
		Select se= new Select(Age);
		se.selectByValue("28");
		
		WebElement ContinueButton2 = driver.findElement(By.xpath("//*[@id=\"step_2\"]/div[2]/div"));
		js.executeScript("arguments[0].click();", ContinueButton2);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		List<WebElement> popularCities = driver.findElements(By.xpath("//*[@id=\"step_3\"]/div[1]/label/input")); 
		for(int i=1;i<=popularCities.size();i++) {
			WebElement ele= driver.findElement(By.xpath("//*[@id=\"step_3\"]/div[1]/label["+i+"]/input"));
			if(ele.getAttribute("value").toString().equalsIgnoreCase("Hyderabad(Telangana)")) {
				js.executeScript("arguments[0].click();", ele);
				break;

			}
		}
		/*WebElement city=driver.findElement(By.xpath("//*[@id=\"healthCityPincode\"]"));
		js.executeScript("arguments[0].click();", city);
		city.sendKeys("Chennai");
		
		WebElement enterCity= driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
		
		if(enterCity.getText().toString().contains("Chennai")) {
			js.executeScript("arguments[0].click();", enterCity);

		}*/
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement fullName= driver.findElement(By.xpath("//*[@id=\"name_feild\"]/input"));
		fullName.sendKeys("ram");
		
		WebElement mobile = driver.findElement(By.xpath("//*[@id=\"name5\"]"));
		mobile.sendKeys("9348573403");
		
		WebElement ContinueButton4 = driver.findElement(By.xpath("//*[@id=\"btnHealthStep4\"]"));
		js.executeScript("arguments[0].click();", ContinueButton4);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		
		WebElement whatsappbutton= driver.findElement(By.xpath("//*[@id=\"step_5\"]/div[4]/label/input"));
		js.executeScript("arguments[0].click();", whatsappbutton);

		WebElement medicalhist = driver.findElement(By.xpath("//*[@id=\"ped_last\"]"));
		js.executeScript("arguments[0].click();", medicalhist);
		
		
	}
	public void close() {
		driver.quit();
	}

	public static void main(String[] args) {
		Insurances In = new Insurances();
		In.driversetup();
		In.travelInsurance();
		In.carInsurance();
		In.healthInsurance();
		//In.close();

	}
}
