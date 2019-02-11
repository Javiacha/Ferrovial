package stepDefinitions.ParametersMaintenance;

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

public class ParametersMaintenanceTest {
	
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

	
	@Given("^we access Parameters maintenance$")
	public void we_access_Parameters_maintenance() throws Throwable {
	 WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("verticalMenu:formularioMenuAplication:j_id32"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).click();
		Thread.sleep(2000);
		builder.moveToElement(web_Element_To_Be_Hovered).perform();
		Thread.sleep(2000);
		WebElement objetivo = driver.findElement(By.xpath("//span[contains(text(),'Parameters Maintenance')]"));
		Thread.sleep(2000);
		builder.moveToElement(objetivo);
		Thread.sleep(2000);
		builder.click();
		Thread.sleep(2000);
		builder.perform();   
		
		Thread.sleep(3000);
		System.out.println("Parameters Maintenance page accessed successfully");

	    
	}

	@Given("^select a parameter from the list$")
	public void select_a_parameter_from_the_list() throws Throwable {
		Thread.sleep(5000);
	    driver.findElement(By.id("body:parameterMaintenanceForm:searchButton")).click();
	    Thread.sleep(5000);
	    System.out.println("Parameter list appears correctly");
	}

	@Given("^enable or disable a parameter$")
	public void enable_or_disable_a_parameter() throws Throwable {
		
		Thread.sleep(5000);
		
		WebElement horizontal_scroll = driver.findElement(By.xpath("//input[@id='body:parameterMaintenanceForm:parametersTable:2:updateTaskButton']")); ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
		Thread.sleep(5000);
		
		WebElement checkboxtask = driver.findElement(By.name("body:parameterMaintenanceForm:parametersTable:0:j_id_id57pc4"));
		if((checkboxtask).isSelected()){
			
			System.out.println("The parameter was already selected, the new status will be inactive");
			checkboxtask.click();
		}
		else {
			checkboxtask.click();
			System.out.println("The parameter has been selected correctly");
		}
		
	  
	}

	@Then("^Modify parameter Status scenario is successful$")
	public void modify_parameter_Status_scenario_is_successful() throws Throwable {
		driver.findElement(By.xpath("//input[@id='body:parameterMaintenanceForm:parametersTable:2:updateTaskButton']")).click();
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
