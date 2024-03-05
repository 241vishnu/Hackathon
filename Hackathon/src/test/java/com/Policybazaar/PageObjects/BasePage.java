package com.Policybazaar.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	static WebDriver driver;

	// Base page for initialization which extended by other page object classes
	@SuppressWarnings("static-access")
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // pageFactory initialization
	}

	// method for converting rgba to hex of color
	public static String hexColor(WebElement ele) {
		// provide color in rgba
		String s = ele.getCssValue("color");
		// convert rgba to hex
		String c = Color.fromString(s).asHex();

		return c;
	}
	// method for converting rgba to hex of background color

	public static String hexBackgroundColor(WebElement e) {
		String s1 = e.getCssValue("background-color");
		String c1 = Color.fromString(s1).asHex();
		return c1;
	}
}