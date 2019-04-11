package stepDefinitions.TsmModeManagementTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.*;

public class tsmmodemanagementTest {

	WebDriver driver;
	//String query = "select count(1) from med_bos_transactions where medtr_oid between 1 and 100000 order by medtr_oid desc";

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
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://10.101.138.58:8280/TSMProcess/login.faces");
		Thread.sleep(3000);
		driver.close();
		for(String winHandle : driver.getWindowHandles()){ 
		    driver.switchTo().window(winHandle);
		    driver.manage().window().maximize();
		    
		}
		
		//Comentarios
		    Thread.sleep(6000);
			driver.findElement(By.id("j_username")).sendKeys("ADMIN");
			driver.findElement(By.id("j_password")).sendKeys("TSMtsm111!");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input.btn")).click();
			Thread.sleep(5000);	
			System.out.println("TSM Main page accessed successfully");
	}

	@Given("^we access mode management$")
	public void we_access_mode_management() throws Throwable{
		Thread.sleep(5000); 
		
		  WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("menu:formMenuApplication:j_id15"));
			Actions builder = new Actions(driver);
			builder.moveToElement(web_Element_To_Be_Hovered).click();
			Thread.sleep(2000);
			builder.moveToElement(web_Element_To_Be_Hovered).perform();
			WebElement destino = driver.findElement(By.xpath("//span[contains(text(),'Mode Management')]"));
			builder.moveToElement(destino).click();
			Thread.sleep(2000);
			builder.moveToElement(destino).perform();
			
			
			Thread.sleep(3000);
			System.out.println("Mode Management accessed correctly");
		
		
	}
	@Given("^select a gantry$")
	public void select_a_gantry() throws Throwable{
		
		driver.findElement(By.id("body:modeManagementViewForm:setMainGantryButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("body:modeManagementViewForm:managementTable:0:valueTable")).click();
	}

	@Given("^check manual$")
	public void check_manual() throws Throwable{
		driver.findElement(By.id("body:modeManagementViewForm:setMainGantryButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("body:modeManagementViewForm:managementTable:0:valueTable")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("body:modeManagementViewForm:changeManualButton")).click();
		Thread.sleep(5000);

		System.out.println("El modo manual se muestra correctamente");
		Thread.sleep(5000);

	}
	@Given("^check schedule$")
	public void check_schedule() throws Throwable{
		driver.findElement(By.id("body:modeManagementViewForm:setMainGantryButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("body:modeManagementViewForm:managementTable:0:valueTable")).click();
		driver.findElement(By.id("body:modeManagementViewForm:changeScheduleButton")).click();
		Thread.sleep(5000);
		System.out.println("El modo schedule se muestra correctamente");

	}
	@Given("^check dynamic$")
	public void check_dynamic() throws Throwable{
		driver.findElement(By.id("body:modeManagementViewForm:setMainGantryButton")).click();
		driver.findElement(By.id("body:modeManagementViewForm:managementTable:0:valueTable")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("body:modeManagementViewForm:changeDynamicButton")).click();
		Thread.sleep(5000);
		System.out.println("El modo dynamic se muestra correctamente");
		Thread.sleep(5000);
	}
	@Then("^tsm mode management test case is successful$")
	public void tsm_mode_management_test_case_is_successful() throws Throwable{
		
		System.out.println("La prueba ha finalizado");
		
		
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





