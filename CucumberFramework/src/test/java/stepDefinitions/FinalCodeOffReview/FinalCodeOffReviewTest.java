package stepDefinitions.FinalCodeOffReview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FinalCodeOffReviewTest {
	
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
	public void we_access_Final_Code_Off_Review() throws Throwable  {
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

	@Given("^click on Anomalous Transactions$")
	public void click_on_Anomalous_Transactions() throws Throwable   {
		driver.findElement(By.xpath("//table[@id='header:formHeaderApplication:changeConcesionaryComboBox']//img[@vspace='1']")).click();
		driver.findElement(By.xpath("//td[@ec_value='9']")).click();

		Thread.sleep(5000);
	  //  driver.findElement(By.id("body:anomalousTransactionForm:transactionCheck")).click();
	    Thread.sleep(5000);
	 //   System.out.println("Anomalous transactions button has been checked correctly");
	    driver.findElement(By.xpath("(//img[starts-with(@src,\"images/table-icon.gi\")])[2]")).click();
	    Thread.sleep(5000);
		driver.findElement(By.className("calendarToday")).click();
		//driver.findElement(By.xpath("//div[@class='pane']//div//tbody//td[2]//td[2]")).click();
		Thread.sleep(30000);


	}

	@Given("^click Search button$")
	public void click_Search_button() throws Throwable {
		
		Thread.sleep(5000);
		driver.findElement(By.id("body:anomalousTransactionForm:searchButton")).click();
		System.out.println("Transaction list is displayed correctly");
		Thread.sleep(5000);
		}
	
	

	@Given("^select a transaction$")
	public void select_a_transaction() throws Throwable {
		Thread.sleep(5000);
		
		driver.findElement(By.id("body:anomalousTransactionForm:anomalousTransactionTable:9:trAnomlousTransactionfieldRecords")).click();

		System.out.println("Transaction has been selected correctly");
	   Thread.sleep(20000);
	}
	
	@Given("^click Review button$")
	public void click_Review_button() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.id("body:anomalousTransactionForm:reviewButton")).click();
	    
	}
	
	@Given("^click Cancel button$")
	public void click_Cancel_button() throws Throwable {
		Thread.sleep(5000);
	    driver.findElement(By.id("body:anomalousTransactionForm:cancelButton")).click();
	}
	
	@Then("^Final Code Off Review is checked successfully$")
	public void final_Code_Off_Review_is_checked_successfully() throws Throwable {
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

 





