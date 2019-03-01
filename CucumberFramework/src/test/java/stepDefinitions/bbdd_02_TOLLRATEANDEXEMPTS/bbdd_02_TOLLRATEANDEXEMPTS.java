package stepDefinitions.bbdd_02_TOLLRATEANDEXEMPTS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.DatabaseConnector;

public class bbdd_02_TOLLRATEANDEXEMPTS {
	
	WebDriver driver;
	String query = "select count(1) from med_bos_transactions where medtr_oid between 1 and 100000 order by medtr_oid desc";

	@Before()
	public void setup() throws Throwable {
		boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
		try {
		    if (isDebug)
		        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		//the following can be changed to: System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\franciscojavier.acha\\git\\repository\\CucumberFramework\\src\\test\\java\\resources\\other\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://10.101.138.58:7001/war_texas-LBJ-1/login.jsf");
		Thread.sleep(3000);
		driver.close();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.manage().window().maximize();
		    
		}
		    Thread.sleep(6000);
			driver.findElement(By.id("j_username")).sendKeys("ADMIN");
			driver.findElement(By.id("j_password")).sendKeys("devI772019*");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input.btn")).click();
			Thread.sleep(5000);	
			System.out.println("BOS Main page accessed successfully");
	}

	
	@Given("^we access Task Maintenance to run VALIDATION MANAGER FINAL VALIDATION$")
	public void we_access_Task_Maintenance_to_run_VALIDATION_MANAGER_FINAL_VALIDATION() throws Throwable {
	 WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("verticalMenu:formularioMenuAplication:j_id30"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).click();
		Thread.sleep(2000);
		builder.moveToElement(web_Element_To_Be_Hovered).perform();
		Thread.sleep(2000);
		WebElement objetivo = driver.findElement(By.xpath("//span[contains(text(),'Task Maintenance')]"));
		Thread.sleep(2000);
		builder.moveToElement(objetivo);
		Thread.sleep(2000);
		builder.click();
		Thread.sleep(2000);
		builder.perform();   
		
		Thread.sleep(3000);
		System.out.println("Task Maintenance page accessed successfully");
		
		driver.findElement(By.id("body:taskMaintenanceForm:maneFilter")).sendKeys("VALIDATION MANAGER INITIAL VALIDATIONS");
		driver.findElement(By.id("body:taskMaintenanceForm:searchButton")).click();
		
		

	    
	}
	
	@And("^select database schema$")
	public void select_database_schema() throws Throwable{
		driver.findElement(By.xpath("//table[@id='header:formHeaderApplication:changeConcesionaryComboBox']//img[@vspace='1']")).click();
		driver.findElement(By.xpath("//td[@ec_value='9']")).click();

	}
	
	@And ("^run VALIDATION MANAGER INITIAL VALIDATION$")
	public void run_VALIDATION_MANAGER_INITIAL_VALIDATION() throws Throwable{
		
		
		
	}
	
	@And ("^check '300' status$")
	public void check_300_status() throws Throwable{
		//System.out.println(DatabaseConnector.checkResultInDatabase(query));
		
		
	}

	

	
		
	  
	
	

	@Then ("^test case is successful$")
	public void test_case_is_successful() throws Throwable {
		
	   
	}
	
	
	@After
	public void tearDown() {
		try {
			if(driver != null ) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDown, Exception: " + e.getMessage());
		}
}

}
