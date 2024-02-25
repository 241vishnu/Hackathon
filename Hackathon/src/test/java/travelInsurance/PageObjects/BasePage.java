package travelInsurance.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	static WebDriver driver;
	//Base page for initialization which extended by other page object classes
	@SuppressWarnings("static-access")
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);		//pageFactory initialization
	}
	
	public static String hexColor(WebElement ele) {
		// provide color in rgba
		String s = ele.getCssValue("color");
		// convert rgba to hex
		String c = Color.fromString(s).asHex();
		
		return c;			
	}
	
	public static String hexBackgroundColor(WebElement e) {
		String s1=e.getCssValue("background-color");
		String c1= Color.fromString(s1).asHex();
		return c1;
	}
}
