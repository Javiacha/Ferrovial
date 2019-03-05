package BBDDRunners;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/resources/features/bbdd_04_ROUTETOVEPFeature" }, glue = {
		"stepDefinitions/bbdd_04_ROUTETOVEPTest" }, monochrome = true, tags = {}, 
				plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class bbdd_04_ROUTETOVEPrunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
		BasePage.copyLatestExtentReport();
	}  
	
}
	
