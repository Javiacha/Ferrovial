package resources.runners;

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

@CucumberOptions(features = { "src\\test\\java\\resources\\features\\bbdd_01_INITIALVALIDATIONS.feature","src\\test\\java\\resources\\features\\bbdd_02_TAGVALIDATIONS.feature","src\\test\\java\\resources\\features\\bbdd_03_VIDEOVALIDATIONS.feature","src\\test\\java\\resources\\features\\bbdd_03_VIDEOVALIDATIONS.feature","src\\test\\java\\resources\\features\\bbdd_04_ROUTETOVEP.feature","src\\test\\java\\resources\\features\\bbdd_05_INSIDEVEP.feature","src\\test\\java\\resources\\features\\bbdd_06_FINALVALIDATIONS.feature","src\\test\\java\\resources\\features\\bbdd_07_TRIPBUILDING.feature","src\\test\\java\\resources\\features\\bbdd_08_TOLLRATE.feature","src\\test\\java\\resources\\features\\bbdd_09_DISCOUNTSURCHARGE.feature","src\\test\\java\\resources\\features\\bbdd_10_FEECALCULATION.feature","src\\test\\java\\resources\\features\\bbdd_11_TRANSFERIMAGES.feature","src\\test\\java\\resources\\features\\bbdd_12_TRANSFERTRIPS.feature" }, 
glue = {"src/test/java/BBDDFERROVIAL/TestingStepsTest.java"}, monochrome = true, tags = {}, 
				plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class regressionColtrunnerTest extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
		BasePage.copyLatestExtentReport();
	}  
	
}