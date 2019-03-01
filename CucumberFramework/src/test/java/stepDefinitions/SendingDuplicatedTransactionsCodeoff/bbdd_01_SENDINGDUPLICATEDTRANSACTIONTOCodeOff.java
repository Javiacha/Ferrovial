package stepDefinitions.SendingDuplicatedTransactionsCodeoff;

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
import cucumber.api.java.en.And;
import utils.DatabaseConnector;

public class bbdd_01_SENDINGDUPLICATEDTRANSACTIONTOCodeOff {
	
	WebDriver driver;

	@Before()
	public void setup() throws Throwable {
		//the following can be changed to: System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver","C:\\Users\\franciscojavier.acha\\git\\repository\\CucumberFramework\\src\\test\\java\\resources\\other\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://10.34.16.73:7201/war_texas-LBJ-1/login.jsf");
		
		Thread.sleep(3000);
		driver.close();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.manage().window().maximize();
		    
		}
		    Thread.sleep(6000);
			driver.findElement(By.id("j_username")).sendKeys("LMORENO");
			driver.findElement(By.id("j_password")).sendKeys("BOSbos777!");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input.btn")).click();
			Thread.sleep(5000);	
			System.out.println("BOS Main page accessed successfully");
	}
	
	@Given("^we access Final Code Off Review$")
	public void we_access_Final_Code_Off_Review() throws Throwable
	{
		WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("verticalMenu:formularioMenuAplication:j_id25"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).click();
		Thread.sleep(2000);
		builder.moveToElement(web_Element_To_Be_Hovered).perform();
		Thread.sleep(2000);
		WebElement objetivo = driver.findElement(By.xpath("//span[contains(text(),'Final Code Off Review')]"));
		Thread.sleep(2000);
		builder.moveToElement(objetivo);
		Thread.sleep(2000);
		builder.click();
		Thread.sleep(2000);
		builder.perform();   
		
		Thread.sleep(3000);
		System.out.println("Final Code Off Review page accessed successfully");
		
	}
	@And("^select database schema$")
	public void select_database_schema() throws Throwable
	{
		driver.findElement(By.xpath("//table[@id='header:formHeaderApplication:changeConcesionaryComboBox']//img[@vspace='1']")).click();
		driver.findElement(By.xpath("//td[@ec_value='9']")).click();

		Thread.sleep(5000);
		
	}
	
	@And("^select date$")
	public void select_date() throws Throwable
	{
		driver.findElement(By.xpath("(//img[starts-with(@src,\"images/table-icon.gi\")])[2]")).click();
	    Thread.sleep(5000);
		driver.findElement(By.className("calendarToday")).click();
		
	}
	@And("^click Search button$")
	public void click_Search_button() throws Throwable
	{

		Thread.sleep(5000);
		driver.findElement(By.id("body:anomalousTransactionForm:searchButton")).click();
		System.out.println("Transaction list is displayed correctly");
		Thread.sleep(5000);
	}
	
	@And("^select a transaction$")
	public void select_a_transaction() throws Throwable
	{
		Thread.sleep(5000);
		
		driver.findElement(By.id("body:anomalousTransactionForm:anomalousTransactionTable:9:trAnomlousTransactionfieldRecords")).click();

		System.out.println("Transaction has been selected correctly");
		Thread.sleep(2000);
	}
	@And ("^click Discard button$")
	public void click_Discard_button() throws Throwable
	{
		driver.findElement(By.id("body:anomalousTransactionForm:discardButtonReview")).click();
	}
	@Then ("^transaction has been correctly discarded$")
	public void transaction_has_been_correctly_discarded() throws Throwable
	{
		boolean checkText = false;
		driver.findElement(By.xpath("//span[contains(text(),'Accept')]")).click();
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
