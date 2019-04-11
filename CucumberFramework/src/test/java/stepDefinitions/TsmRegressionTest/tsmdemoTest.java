package stepDefinitions.TsmRegressionTest;

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

public class tsmdemoTest {

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

	@Given("^access Toll Control Management$")
	public void access_Toll_Control_Management() throws Throwable{
		
		Thread.sleep(5000); 
		
	  WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("menu:formMenuApplication:j_id15"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).click();
		Thread.sleep(2000);
		builder.moveToElement(web_Element_To_Be_Hovered).perform();
		WebElement destino = driver.findElement(By.xpath("//span[contains(text(),'Toll Rate Management')]"));
		builder.moveToElement(destino).click();
		Thread.sleep(2000);
		builder.moveToElement(destino).perform();
		/*web_Element_To_Be_Hovered.sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(2000);
		
		for (int i = 0;i<800;i++) {
		web_Element_To_Be_Hovered.sendKeys(Keys.PAGE_DOWN);
		i++;
		}
		Thread.sleep(3000);
		for (int i = 0;i<800;i++) {
			web_Element_To_Be_Hovered.sendKeys(Keys.PAGE_DOWN);
			i++;
			} 
		
		
		
		//WebElement objetivo = driver.findElement(By.xpath("//span[text()=\"Task Maintenance\"]")); //driver.findElement(By.xpath("//span[text()=\"Task Maintenance\"]"))
		
		//builder.moveToElement(objetivo);
		
		//builder.click();
		
		//builder.perform();   */
		
		Thread.sleep(3000);
		System.out.println("Toll Rate Control Management accessed correctly");
		

		Thread.sleep(6000);
		
		

	    
	}
	
	@Given("^check string name is not present$")
	public void check_string_name_is_not_present() throws Throwable{
		
		driver.findElement(By.id("body:rateForm:rateNameFilter")).sendKeys("Transaction One");
		Thread.sleep(2000);
		driver.findElement(By.id("body:rateForm:searchButton")).click();
		Thread.sleep(5000);
		
		if (driver.findElement(By.id("body:j_id_jsp_1318845864_8")).isDisplayed()) {
			System.out.println("There is no data that fulfills the search criteria.");
		}
		

		Thread.sleep(20000); 

	}
	
	@Given("^upload new document$")
	public void upload_new_document() throws Throwable{
		
	
		driver.findElement(By.id("body:rateForm:uploadButton")).click();
		driver.findElement(By.id("body:rateForm:nameUpload")).sendKeys("Transaction One");
		
Thread.sleep(10000);

		driver.findElement(By.xpath("//table[@id='body:rateForm:segmentUpload']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_NB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:rateForm:modeTypeUpload']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'Default')]")).click();

		WebElement uploadElement = driver.findElement(By.id("body:rateForm:fileToUpload"));
		
		Thread.sleep(3000);
		uploadElement.sendKeys("C:\\ficheros\\LBJ_IH35EN-IH635-G13A_DEFAULT.xls");
		Thread.sleep(3000);
		
		driver.findElement(By.id("body:rateForm:uploadFileButton")).click();
		
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Accept')]")).click();   
		
		Thread.sleep(6000);
		//
	}

	

	@Then("^check new document is uploaded$")
		public void check_new_document_is_uploaded() throws Throwable {
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





