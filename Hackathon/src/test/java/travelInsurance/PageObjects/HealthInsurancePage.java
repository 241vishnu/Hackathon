package travelInsurance.PageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HealthInsurancePage extends BasePage{

	public HealthInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class=\"pb-logo\"]")
	WebElement logo1;

	@FindBy(xpath="//a[normalize-space()='Insurance Products']")
	WebElement InsuranceProduct;
	
	@FindBy(xpath="//h3/a[contains(@href,\"https://www.policybazaar.com/health-insurance/\")]")
	WebElement HealthInsurance;
	
	@FindBy(xpath="//div/ul/li[2]/div/div/div[3]/ul/li/a/span")
	List<WebElement> HealthInsuranceMenu;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[1]")
	WebElement step1Page;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[2]/div[1]/li[11]/span")
	WebElement moreMembers;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[2]/div[1]/li/input")
	List<WebElement> members;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[2]/div[3]/div")
	WebElement ContinueButton1;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[2]")
	WebElement step2Page;
	
	@FindBy(xpath="//*[@id=\"name_feild\"]/select")
	WebElement Age;
	
	@FindBy(xpath="//*[@id=\"step_2\"]/div[2]/div")
	WebElement ContinueButton2;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[3]")
	WebElement step3Page;

	@FindBy(xpath="//*[@id=\"step_3\"]/div[1]/label/input")
	List<WebElement> popularCities;
	
	@FindBy(xpath="//*[@id=\"btnHealthStep3\"]")
	WebElement ContinueButton3;
	
	@FindBy(xpath="//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[4]")
	WebElement step4Page;
	
	@FindBy(xpath="//*[@id=\"name_feild\"]/input")
	WebElement fullName;
	
	@FindBy(xpath="//*[@id=\"name5\"]")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id=\"btnHealthStep4\"]")
	WebElement ContinueButton4;
	
	@FindBy(xpath="//*[@id=\"step_5\"]/p[1]")
	WebElement medicalPage;
	
	@FindBy(xpath="//*[@id=\"step_5\"]/div[4]/label/input")
	WebElement whatsappbutton;
	
	@FindBy(xpath="//*[@id=\"ped_last\"]")
	WebElement medicalhist;
	
	@FindBy(xpath="//*[@id=\"errorHighlight\"]")
	WebElement errorMsg1;//Please select at least one member
	
	@FindBy(xpath="//*[@id=\"step_2\"]/div[1]")
	WebElement errorMsg2; //Please select age
	
	@FindBy(xpath="//*[@id=\"step_3\"]/ul/li/div[2]")
	WebElement errorMsg3;//Required
	
	@FindBy(xpath="//*[@id=\"person_name\"]/div[2]")
	WebElement errorMsg4;//Required
	
	@FindBy(xpath="//*[@id=\"registration_check\"]/div[2]")
	WebElement errorMsg5;//Required
	
	@FindBy(xpath="//*[@id=\"registration_check\"]/div[2]")
	WebElement errorMsg6;//Please enter valid mobile number
	
	@FindBy(xpath="//*[@id=\"step_5\"]/div[2]")
	WebElement errorMsg7;//Select one option
	
	@FindBy(xpath="//*[@id=\"btnHealthStep5\"]")
	WebElement viewPlansButton;
	
	@FindBy(xpath="//div[@id='1']")
	WebElement sortBy;
	
	@FindBy(xpath="//*[@id=\"[object Object]1\"]")
	WebElement lowToHigh;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div[3]/button[2]")
	WebElement applyBtn;
	
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    public void title() {
    	String t="Health Insurance";
    	if(driver.getTitle().contains(t)) {
    		Assert.assertTrue(true);
    	}
    	else {
    	Assert.assertTrue(false);
    	}
    }

    public void clicklogo() {
    	logo1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
	
	public void insuranceProducts() {
		Actions action = new Actions(driver);
		action.moveToElement(InsuranceProduct).perform();
	}

	public List<WebElement> healthInsurnaceMenu() {
		/*for(WebElement ele:HealthInsuranceMenu ) {
	        System.out.println(ele.getText());
		}*/
        return HealthInsuranceMenu;
	}
	
	public void healthInsurancePage() {
		js.executeScript("arguments[0].click();", HealthInsurance);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	public void moreMembers() {
		js.executeScript("arguments[0].click();", moreMembers);

	}
	
	public void continue1Btn() {
		js.executeScript("arguments[0].click();", ContinueButton1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	
	public String error1() {
		return errorMsg1.getText();
		
	}
	
	public void select_a_Member(String membertype) {
		for(int i=1;i<=members.size();i++) {
			WebElement memberName=driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li["+i+"]/input"));
			if(memberName.getAttribute("value").toString().equalsIgnoreCase(membertype)) {
				js.executeScript("arguments[0].click();", memberName);
				break;
			}
		}
		
	}
	
	public void continue2Btn() {
		js.executeScript("arguments[0].click();", ContinueButton2);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	public String error2() {
		return errorMsg2.getText();
	}
	
	public void selectAge(String age) {
		js.executeScript("arguments[0].click();", Age);
		Select se= new Select(Age);
		se.selectByValue(age);
		
	}
	public void continue3Btn() {
		js.executeScript("arguments[0].click();", ContinueButton3);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	public String error3() {
		return errorMsg3.getText();
	}
	
	public void selectCity(String city) {
		for(int i=1;i<=popularCities.size();i++) {
			WebElement ele= driver.findElement(By.xpath("//*[@id=\"step_3\"]/div[1]/label["+i+"]/input"));
			if(ele.getAttribute("value").toString().equalsIgnoreCase(city)) {
				js.executeScript("arguments[0].click();", ele);
				break;

			}
		}
		
	}
	public void continue4Btn() {
		js.executeScript("arguments[0].click();", ContinueButton4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


	}
	public String error4() {
		return errorMsg4.getText();
	}
	
	public void enterName(String name) {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		fullName.sendKeys(name);
		//js.executeScript("arguments[0].value='"+ name +"';", fullName);

	}
	public void enterPhoneNumber(String phoneNumber) {
		//mobile.click();
		//js.executeScript("arguments[0].click();", mobile);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		mobile.sendKeys(phoneNumber);
		//js.executeScript("arguments[0].value=phoneNumber;",mobile);

		
	}
	public String error5() {
		return errorMsg5.getText();
	}
	

	public String error6() {
		return errorMsg6.getText();	
	}
	public void NoCheckBox() {
		js.executeScript("arguments[0].click();", medicalhist);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	public void whatsappbtn() {
		js.executeScript("arguments[0].click();", whatsappbutton);

	}
	public void viewPlansBtn() {
		js.executeScript("arguments[0].click();", viewPlansButton);

	}
	public String error7() {
		return errorMsg7.getText();
	}
	
	public void membersPage() {
		Assert.assertEquals("#36b37e",BasePage.hexBackgroundColor(step1Page));
	}
	public void agePage() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Assert.assertEquals("#36b37e",BasePage.hexBackgroundColor(step2Page));
		Assert.assertEquals("Select age",driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[1]/div[1]/div[2]/div")).getText());

	}
	public void cityPage() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Assert.assertEquals("#36b37e",BasePage.hexBackgroundColor(step3Page));
		Assert.assertEquals("Select a city", driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[1]/div[1]/div[2]/div")).getText());

	}
	public void contactPage() {
		
		//Assert.assertEquals("#36b37e",BasePage.hexBackgroundColor(step4Page));
		Assert.assertEquals("Fill personal details",driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[1]/div[1]/div[2]/div")).getText());

	}
	public void medicalHistoryPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Assert.assertEquals("Do you have an existing illness or medical history?",medicalPage.getText().toString());
	}
	
	public void sortby() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='allfilterBox']")));
		driver.findElement(By.xpath("//div[@class='allfilterBox']")).click();  
		System.out.println("filter clicked");

		List<WebElement> filter=driver.findElements(By.xpath("//div[@class=\"selectionBoxWrapper\"][1]/div/label/span"));
		for(WebElement f:filter)
		{
			String v=f.getText();
			if(v.equalsIgnoreCase("Premium low to high"))
			{
				f.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[@id=\"ApplyFilter\"]")).click();

	}
	
	public HashMap<String,String> results() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='quotes_rvmp_card segmentation_quoteCard ']//div[@class='quotes_rvmp_card__content__plan_header']//span[1]"));
		
		List<WebElement> amtmon=driver.findElements(By.xpath("//div[@class='quotesRevampCtaWrap']/button"));
		HashMap<String,String> healthRes= new HashMap<String,String>();
		for(int i=0;i<3;i++)
		{
			String name=list.get(i).getText();
			String amt=amtmon.get(i).getText();
			healthRes.put(name, amt);
		}
		return healthRes;

	}






	

	



	
	


}
