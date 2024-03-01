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

public class HealthInsurancePage extends BasePage {

	public HealthInsurancePage(WebDriver driver) {
		super(driver);
	}

	// logo icon
	@FindBy(xpath = "//a[@class=\"pb-logo\"]")
	WebElement logo1;

	// insurance products link
	@FindBy(xpath = "//a[normalize-space()='Insurance Products']")
	WebElement InsuranceProduct;

	// health insurance heading
	@FindBy(xpath = "//h3/a[contains(@href,\"https://www.policybazaar.com/health-insurance/\")]")
	WebElement HealthInsurance;

	// list of health insurances
	@FindBy(xpath = "//div/ul/li[2]/div/div/div[3]/ul/li/a/span")
	List<WebElement> HealthInsuranceMenu;

	// page to select the members
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[1]")
	WebElement step1Page;

	// more members button
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[2]/div[1]/li[11]/span")
	WebElement moreMembers;

	// list of memebers
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[2]/div[1]/li/input")
	List<WebElement> members;

	// continue 1 button
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[2]/div[3]/div")
	WebElement ContinueButton1;

	// age page
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[2]")
	WebElement step2Page;

	// age drop down
	@FindBy(xpath = "//*[@id=\"name_feild\"]/select")
	WebElement Age;

	// continue 2 button
	@FindBy(xpath = "//*[@id=\"step_2\"]/div[2]/div")
	WebElement ContinueButton2;

	// cities page
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[3]")
	WebElement step3Page;

	// list of popular cities
	@FindBy(xpath = "//*[@id=\"step_3\"]/div[1]/label/input")
	List<WebElement> popularCities;

	// continue 3 button
	@FindBy(xpath = "//*[@id=\"btnHealthStep3\"]")
	WebElement ContinueButton3;

	// contact details page
	@FindBy(xpath = "//*[@id=\"health_bu\"]/div[1]/div[2]/ul/li[4]")
	WebElement step4Page;

	// full name
	@FindBy(xpath = "//*[@id=\"name_feild\"]/input")
	WebElement fullName;

	// phone number
	@FindBy(xpath = "//*[@id=\"name5\"]")
	WebElement mobile;

	// continue 4 button
	@FindBy(xpath = "//*[@id=\"btnHealthStep4\"]")
	WebElement ContinueButton4;

	// medical page
	@FindBy(xpath = "//*[@id=\"step_5\"]/p[1]")
	WebElement medicalPage;

	// whatsapp button slider
	@FindBy(xpath = "//*[@id=\"step_5\"]/div[4]/label/input")
	WebElement whatsappbutton;

	// no check box in medical page
	@FindBy(xpath = "//*[@id=\"ped_last\"]")
	WebElement medicalhist;

	// error message in members page
	@FindBy(xpath = "//*[@id=\"errorHighlight\"]")
	WebElement errorMsg1;// Please select at least one member

	// error message in age page
	@FindBy(xpath = "//*[@id=\"step_2\"]/div[1]")
	WebElement errorMsg2; // Please select age

	// error msg in cities page
	@FindBy(xpath = "//*[@id=\"step_3\"]/ul/li/div[2]")
	WebElement errorMsg3;// Required

	// error msg in contacts page
	@FindBy(xpath = "//*[@id=\"person_name\"]/div[2]")
	WebElement errorMsg4;// Required

	// error msg in contacts page
	@FindBy(xpath = "//*[@id=\"registration_check\"]/div[2]")
	WebElement errorMsg5;// Required

	// error msg in contacts page
	@FindBy(xpath = "//*[@id=\"registration_check\"]/div[2]")
	WebElement errorMsg6;// Please enter valid mobile number

	// erro msg in medical page
	@FindBy(xpath = "//*[@id=\"step_5\"]/div[2]")
	WebElement errorMsg7;// Select one option

	// view plans button
	@FindBy(xpath = "//*[@id=\"btnHealthStep5\"]")
	WebElement viewPlansButton;

	// sort by button in the filters
	@FindBy(xpath = "//div[@id='1']")
	WebElement sortBy;

	// low to high radio button
	@FindBy(xpath = "//*[@id=\"[object Object]1\"]")
	WebElement lowToHigh;

	// apply button in filter
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div[3]/button[2]")
	WebElement applyBtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// method to verify the title of page
	public void title() {
		String t = "Health Insurance";
		if (driver.getTitle().contains(t)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	// method to click on logo icon
	public void clicklogo() {
		logo1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	// method to hover on insurance products
	public void insuranceProducts() {
		Actions action = new Actions(driver);
		action.moveToElement(InsuranceProduct).perform();
	}

	// method to return list of health insurances
	public List<WebElement> healthInsurnaceMenu() {
		return HealthInsuranceMenu;
	}

	// method to click on health insurance heading link
	public void healthInsurancePage() {
		js.executeScript("arguments[0].click();", HealthInsurance);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	// method to click on more members button
	public void moreMembers() {
		js.executeScript("arguments[0].click();", moreMembers);

	}

	// method to click on continue 1 button
	public void continue1Btn() {
		js.executeScript("arguments[0].click();", ContinueButton1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	// method to get error msg in memebers page
	public String error1() {
		return errorMsg1.getText();

	}

	// method to select a member
	public void select_a_Member(String membertype) {
		for (int i = 1; i <= members.size(); i++) {
			WebElement memberName = driver
					.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li[" + i + "]/input"));
			if (memberName.getAttribute("value").toString().equalsIgnoreCase(membertype)) {
				js.executeScript("arguments[0].click();", memberName);
				break;
			}
		}

	}

	// method to click on continue 2 button
	public void continue2Btn() {
		js.executeScript("arguments[0].click();", ContinueButton2);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	// method to get error message in age page
	public String error2() {
		return errorMsg2.getText();
	}

	// method to select age
	public void selectAge(String age) {
		js.executeScript("arguments[0].click();", Age);
		Select se = new Select(Age);
		se.selectByValue(age);

	}

	// method to click on continue 3 button
	public void continue3Btn() {
		js.executeScript("arguments[0].click();", ContinueButton3);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	// method to get error msg on cities page
	public String error3() {
		return errorMsg3.getText();
	}

	// method to select the city
	public void selectCity(String city) {
		for (int i = 1; i <= popularCities.size(); i++) {
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"step_3\"]/div[1]/label[" + i + "]/input"));
			if (ele.getAttribute("value").toString().equalsIgnoreCase(city)) {
				js.executeScript("arguments[0].click();", ele);
				break;

			}
		}

	}

	// method to click on continue 4 button
	public void continue4Btn() {
		js.executeScript("arguments[0].click();", ContinueButton4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	// method to get error msg on contacts page
	public String error4() {
		return errorMsg4.getText();
	}

	// method to enter name
	public void enterName(String name) {

		fullName.sendKeys(name);

	}

	// method to enter phone number
	public void enterPhoneNumber(String phoneNumber) {
		mobile.sendKeys(phoneNumber);
	}

	// method to get name error
	public String error5() {
		return errorMsg5.getText();
	}

	// method to get phone number error
	public String error6() {
		return errorMsg6.getText();
	}

	// method to select no check box in medical history
	public void NoCheckBox() {
		js.executeScript("arguments[0].click();", medicalhist);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}

	// method to click on whatsapp button
	public void whatsappbtn() {
		js.executeScript("arguments[0].click();", whatsappbutton);

	}

	// method to click on view plans
	public void viewPlansBtn() {
		js.executeScript("arguments[0].click();", viewPlansButton);

	}

	// method to get error msg on medical history page
	public String error7() {
		return errorMsg7.getText();
	}

	// method to verify the memebers page
	public void membersPage() {
		Assert.assertEquals("#36b37e", BasePage.hexBackgroundColor(step1Page));
	}

	// method to verify the age page
	public void agePage() {
		Assert.assertEquals("Select age",
				driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[1]/div[1]/div[2]/div")).getText());

	}

	// method to verify the city page
	public void cityPage() {
		Assert.assertEquals("Select a city",
				driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[1]/div[1]/div[2]/div")).getText());

	}

	// method to verify the contact page
	public void contactPage() {

		Assert.assertEquals("Fill personal details",
				driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[1]/div[1]/div[2]/div")).getText());

	}

	// method to verify the medical history page
	public void medicalHistoryPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Assert.assertEquals("Do you have an existing illness or medical history?", medicalPage.getText().toString());
	}

	// method to sort
	public void sortby() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='allfilterBox']")));
		driver.findElement(By.xpath("//div[@class='allfilterBox']")).click();
		List<WebElement> filter = driver
				.findElements(By.xpath("//div[@class=\"selectionBoxWrapper\"][1]/div/label/span"));
		for (WebElement f : filter) {
			String v = f.getText();
			if (v.equalsIgnoreCase("Premium low to high")) {
				f.click();
				break;
			}
		}
		WebElement filterButton = driver.findElement(By.xpath("//button[@id=\"ApplyFilter\"]"));
		js.executeScript("arguments[0].click();", filterButton);

	}

	// method to get results of health insurances
	public HashMap<String, String> results() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> list = driver.findElements(By.xpath(
				"//div[@class='quotes_rvmp_card segmentation_quoteCard ']//div[@class='quotes_rvmp_card__content__plan_header']//span[1]"));

		List<WebElement> amtmon = driver.findElements(By.xpath("//div[@class='quotesRevampCtaWrap']/button"));
		HashMap<String, String> healthRes = new HashMap<String, String>();
		for (int i = 0; i < 3; i++) {
			String name = list.get(i).getText();
			String amt = amtmon.get(i).getText();
			healthRes.put(name, amt);
		}
		return healthRes;

	}

}
