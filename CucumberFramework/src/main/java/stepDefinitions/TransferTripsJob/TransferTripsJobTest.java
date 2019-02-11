package stepDefinitions.TransferTripsJob;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.DatabaseConnector;

public class TransferTripsJobTest {
	
	WebDriver driver;
	
	String url = "jdbc:oracle:thin:@10.101.138.58:1521:DEVI77";
	String user = "I77";
	String pass = "I77";
	
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
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\franciscojavier.acha\\Desktop\\webdriverhoy\\WebdriverUniversity\\CucumberFramework\\src\\test\\java\\resources\\other\\geckodriver.exe");
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

	
	@Given("^we access task maintenance$")
	public void we_access_task_maintenance() throws Throwable {
		WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("verticalMenu:formularioMenuAplication:j_id33"));
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
		
		System.out.println("Task Maintenance page accessed successfully");

	    
	}

	@Given("^select jobs$")
	public void select_jobs() throws Throwable {
		Thread.sleep(5000);
		
		WebElement horizontal_scroll = driver.findElement(By.id("body:taskMaintenanceForm:taskTable:allActiveCheck")); ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
		Thread.sleep(5000);
	    WebElement checkboxtask = driver.findElement(By.id("body:taskMaintenanceForm:taskTable:allActiveCheck"));
	    Thread.sleep(5000);
		if((checkboxtask).isSelected()){
			
			System.out.println("Tasks were already active. We'll reset them");
			checkboxtask.click();
			Thread.sleep(5000);
			driver.findElement(By.id("body:taskMaintenanceForm:updateButton")).click();
			Thread.sleep(5000);
			driver.findElement(By.className("ui-state-focus")).click();
	
			Thread.sleep(5000);
			checkboxtask.click();
		}
		else {
			checkboxtask.click();
			
			Thread.sleep(5000);
		}
	    
	}

	@Given("^run jobs$")
	public void run_Transfer_trips_jobs() throws Throwable {
		String processExecuted = "SELECT max(jobs_oid) FROM i77.INFO_JOBS_INFODATA where jobs_name = 'Transfer Trips Job' and jobs_fec_creation > sysdate - 1/24 order by JOBS_FEC_CREATION asc";
		Long cont = DatabaseConnector.checkResultInDatabase(processExecuted, url, user, pass);
		
		driver.findElement(By.id("body:taskMaintenanceForm:updateButton")).click();
		driver.findElement(By.className("ui-state-focus")).click();
		Thread.sleep(5000);
		
		Long cont2 = 0L;
		do{
			cont2 = DatabaseConnector.checkResultInDatabase(processExecuted, url, user, pass);
			if(cont==cont2) {
				System.out.println("Process still not executed");
				Thread.sleep(1000);
			}
		}while(cont==cont2);
		System.out.println("Process executed");
		//checkTransaction();
	}
	@Then("^check on DataBase Transfer trips job is successful$")
	public void check_on_DataBase_Transfer_trips_job_is_successful() throws Throwable {
		String processExecuted = "SELECT count(1) FROM i77.med_bos_transactions where medtr_oid = 18 and medtr_trnst_fk = 52"; //transacción número proporcionado
		Long cont = 1L;
		Long cont2 = 0L;
		do{
			cont2 = DatabaseConnector.checkResultInDatabase(processExecuted, url, user, pass);
			if(cont!=cont2) {
				System.out.println("Transaction KO");
				System.out.println("Transfer Trips KO");

				Thread.sleep(1000);
			}
			else {
				System.out.println("Transaction OK");		
				System.out.println("Transfer Trips OK");

			}
		}while(cont!=cont2);
		
		
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

