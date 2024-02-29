package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class HelperClass {

	public static WebDriver driver;
	static Properties p;
	static Logger logger;

	// method for initializing browser
	public static WebDriver initialBrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS..");
			}
			// browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);

		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		return driver;

	}

	// method to return the current driver
	public static WebDriver getDriver() {
		return driver;
	}

	// method to load properties file
	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		p = new Properties();
		p.load(file);
		return p;
	}
	  public static Logger getLogger() 
		{		 
			logger=LogManager.getLogger(); //Log4j
			return logger;
		}

}
