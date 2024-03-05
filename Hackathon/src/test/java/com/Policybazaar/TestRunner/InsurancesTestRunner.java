package com.Policybazaar.TestRunner;



import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.utils.HelperClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 
//@RunWith(Cucumber.class)
@CucumberOptions( 
					features= {"src//test//resources//Features//Insurances_end_to_end.feature"}, 
					//features= {"src//test//resources//Features//Insurances_smoke.feature"},
					//features= {"src//test//resources//Features//Insurances_regression.feature"},
					//features= {"src//test//resources//Features"},

							glue="com.Policybazaar.StepDefinations",
							plugin= {"pretty", "html:reports/myreport.html", 
									"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
									},
									
							dryRun=false,    // checks mapping between scenario steps and step definition methods
							monochrome=false,    // to avoid junk characters in output
							publish=true   // to publish report in cucumber server
			    )

public class InsurancesTestRunner extends AbstractTestNGCucumberTests{
	
		@BeforeMethod
		@Parameters({"browser"})
		  public void setUp(String b) throws IOException {
		    String browser = b;
		    HelperClass.initialBrowser(browser);
		  }
		  @AfterMethod
		  public void tearDown() {
			  HelperClass.quitDriver();
		  }
		 
}