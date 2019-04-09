package stepDefinitions.ColtRegressionTest;

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

public class TestingStepsTest {
	 
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
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
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
		
		//Comentarios 
		    Thread.sleep(6000);
			driver.findElement(By.id("j_username")).sendKeys("ADMIN");
			driver.findElement(By.id("j_password")).sendKeys("devI772020*");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input.btn")).click();
			Thread.sleep(5000);	
			System.out.println("BOS Main page accessed successfully");
	}

	
	@Given("^we access Task Maintenance to run \"([^\"]*)\"$")
	public void we_access_Task_Maintenance_to_run(String jobName) throws Throwable {
		Thread.sleep(3000);
		System.out.println("Accessing Task Maintenance to launch task: " + jobName);
		Thread.sleep(5000);
		
	 WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("verticalMenu:formularioMenuAplication:j_id33"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).click();
		Thread.sleep(2000);
		builder.moveToElement(web_Element_To_Be_Hovered).perform();
		Thread.sleep(2000);
		
		web_Element_To_Be_Hovered.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		web_Element_To_Be_Hovered.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		web_Element_To_Be_Hovered.sendKeys(Keys.ENTER);
		
		
		Thread.sleep(10000);
		//WebElement objetivo = driver.findElement(By.xpath("//span[text()=\"Task Maintenance\"]")); //driver.findElement(By.xpath("//span[text()=\"Task Maintenance\"]"))
		
		//builder.moveToElement(objetivo);
		
		//builder.click();
		
		//builder.perform();   
		
		Thread.sleep(3000);
		System.out.println("Task Maintenance page accessed successfully");
		

		Thread.sleep(6000);
		
		

	    
	}
	
	@And("^select database schema$")
	public void select_database_schema() throws Throwable{

		driver.findElement(By.name("header:formHeaderApplication:changeConcesionaryComboBox")).click();
			driver.findElement(By.name("header:formHeaderApplication:changeConcesionaryComboBox")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("header:formHeaderApplication:changeConcesionaryComboBox")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("header:formHeaderApplication:changeConcesionaryComboBox")).sendKeys(Keys.ARROW_DOWN);

			driver.findElement(By.name("header:formHeaderApplication:changeConcesionaryComboBox")).sendKeys(Keys.ENTER);

		Thread.sleep(20000); 

	}
	
	@Given("^run \"([^\"]*)\"$")
	public void run(String jobName) throws Throwable  {
		
		driver.findElement(By.id("body:taskMaintenanceForm:maneFilter")).sendKeys(jobName);
		driver.findElement(By.id("body:taskMaintenanceForm:searchButton")).click();
		
Thread.sleep(10000);
		
		WebElement horizontal_scroll = driver.findElement(By.xpath("//input[@id='body:taskMaintenanceForm:taskTable:0:updateTaskButton']")); ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
		Thread.sleep(5000);
		
		WebElement checkboxtask = driver.findElement(By.id("body:taskMaintenanceForm:taskTable:0:activeOption"));
		if((checkboxtask).isSelected()){
			
			System.out.println("The task was already selected, we will stop it and run again");
			checkboxtask.click();
			Thread.sleep(5000);
			driver.findElement(By.id("body:taskMaintenanceForm:taskTable:0:updateTaskButton")).click();
			Thread.sleep(5000);
			driver.findElement(By.className("ui-state-focus")).click();
			Thread.sleep(25000);

		}
		else {
			checkboxtask.click();
			System.out.println("The task has been selected correctly");
			Thread.sleep(5000);
			driver.findElement(By.id("body:taskMaintenanceForm:taskTable:0:updateTaskButton")).click();
			Thread.sleep(5000);
			driver.findElement(By.className("ui-state-focus")).click();
			Thread.sleep(25000);

		} 
		Thread.sleep(6000);
		//
	}
	@And("^check \"([^\"]*)\" status$")
	public void check_status(int StatusNumber) throws Throwable{
		System.out.println(StatusNumber);
		///////////////////////////////////////////////////////////////////////////////////////////////
		//DENTRO DE LA CONSULTA DEBEMOS CAMBIAR LOS NÚMEROS DENTRO DE LOS SEGUNDOS PARENTESIS POR EL DE LAS TRANSACCIONES QUE NECESITAMOS
		///////////////////////////////////////////////////////////////////////////////////////////////
		 String processExecuted = "SELECT count(1) FROM med_bos_transactions where medtr_oid in (18,150)";// and medtr_trnst_fk = \\\StatusNumber\\";//transacción número proporcionado
		Long cont = 2L;
		Long cont2 = 0L;
		Long currentDate = new Date().getTime();
		do{
			cont2 = DatabaseConnector.checkResultInDatabase(processExecuted);
			if(cont!=cont2) {
				System.out.println("Transaction has been proccessed");
			

				Thread.sleep(1000); 
				
				if((new Date().getTime())-currentDate>30000){
					System.out.println("Requested Job - TIMEOUT");
					break;
				}
			}
			else {
				System.out.println("Transaction has been proccessed"); 
			

			}
		}while(cont!=cont2); 
		
		List<String> ids = new ArrayList<String>();
		
		///////////////////////////////////////////////////////////////////////////
		//AQUÍ APARECEN LAS TRANSACCIONES QUE DEBEMOS AÑADIR O CAMBIAR. SÓLO DEBEMOS
		//CAMBIAR LOS NÚMEROS ENTEROS DISPUESTOS ENTRE COMILLAS
		///////////////////////////////////////////////////////////////////////////
		ids.add("18"); 
		ids.add("150");
		///////////////////////////////////////////////////////////////////////////
		List<String> showTransactions = DatabaseConnector.getTransactionValuesInDatabase(ids);
		for (String showTransaction : showTransactions) {
			System.out.println(String.join(",", showTransaction));			
		}
	}

	@Then ("^test case is successful$")
	public void test_case_is_successful() throws Throwable {
		WebElement checkboxtask = driver.findElement(By.id("body:taskMaintenanceForm:taskTable:0:activeOption"));
		checkboxtask.click();
		driver.findElement(By.id("body:taskMaintenanceForm:taskTable:0:updateTaskButton")).click();
		driver.findElement(By.className("ui-state-focus")).click();
		Thread.sleep(5000);
		System.out.println("Test case done");  
	   
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


