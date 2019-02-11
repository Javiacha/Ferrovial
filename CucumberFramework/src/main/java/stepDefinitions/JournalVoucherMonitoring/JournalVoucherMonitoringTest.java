package stepDefinitions.JournalVoucherMonitoring;

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

public class JournalVoucherMonitoringTest {
	
	WebDriver driver;

	@Before()
	public void setup() throws Throwable {
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

	
	@Given("^we access Journal Voucher Monitoring$")
	public void we_access_Journal_Voucher_Monitoring() throws Throwable {
	 WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("verticalMenu:formularioMenuAplication:j_id31"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).click();
		Thread.sleep(2000);
		builder.moveToElement(web_Element_To_Be_Hovered).perform();
		Thread.sleep(2000);
		WebElement objetivo = driver.findElement(By.xpath("//span[contains(text(),'Journal Voucher Monitoring')]"));
		Thread.sleep(2000);
		builder.moveToElement(objetivo);
		Thread.sleep(2000);
		builder.click();
		Thread.sleep(2000);
		builder.perform();   
		
		Thread.sleep(3000);
		System.out.println("Journal Voucher Monitoring aceessed correctly");

	    
	}

	@Given("^Select file type$")
	public void select_file_type() throws Throwable {  
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//table[@id='body:jvMonitoringForm:extInterfaceFilter']//img[@vspace='1']")).click();
	    Thread.sleep(5000);
	    System.out.println("File Type selected correctly");
	}

	@Given("^select a date$")
	public void select_a_date() throws Throwable { 
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//img[starts-with(@src,\"images/table-icon.gi\")]")).click();
		driver.findElement(By.xpath("//span[text()=\"2018\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"calendarDropdown\"])[2]")).click();
		driver.findElement(By.xpath("(//img)[17]")).click();
		driver.findElement(By.xpath("(//div[@class=\"calendarDropdown\"])[2]")).click();
		driver.findElement(By.xpath("//td[text()=\"1\"]")).click();

		
	  
	}
	
	@Given("^click Search button$")
	public void click_Search_button() throws Throwable {
		driver.findElement(By.id("body:jvMonitoringForm:searchButton")).click();
	    Thread.sleep(10000);
	}
	
	@Given("^click PDF File Download$")
	public void click_PDF_File_Download() throws Throwable {
		
		Thread.sleep(10000);
	    
	}
	
	@Given("^click EXCEL File Download$")
	public void click_EXCEL_File_Download() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("^Journal Voucher Monitoring is successful$")
	public void journal_Voucher_Monitoring_is_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	

	@Then("^Modify DMV Agreements State modification is done successfully$")
	public void modify_DMV_Agreements_State_modification_is_done_successfully() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.id("body:dmvAgreementsForm:agreementTable:0:updateStateButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("ui-state-focus")).click();
		Thread.sleep(5000);

		System.out.println("The task's status has been modified correctly");
	   
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

//////////////////////////////////////////////////////////////////////////////////////////////




 







