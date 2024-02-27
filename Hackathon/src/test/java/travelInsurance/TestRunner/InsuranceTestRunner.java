package travelInsurance.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 
//@RunWith(Cucumber.class)
@CucumberOptions( 
					//features= {"src//test//resources//Features//Insurances_end_to_end.feature"}, 
					features= {"src//test//resources//Features//Insurances_smoke.feature"},
					//features= {"src//test//resources//Features//Insurances_regression.feature"},
					//features= {"src//test//resources//Features"},

							glue="travelInsurance.StepDefination",
							plugin= {"pretty", "html:reports/myreport.html", 
									"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
									},
									
							dryRun=false,    // checks mapping between scenario steps and step definition methods
							monochrome=false,    // to avoid junk characters in output
							publish=true   // to publish report in cucumber server
			    )

public class InsuranceTestRunner extends AbstractTestNGCucumberTests{
	
	   
		 
}
