package stepDefinitions.ColtCheckRatesTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Timer;
import cucumber.api.java.Before;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.*;
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

public class CheckRatesTest {
	WebDriver driver;
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
		    
			//Comentarios
		    Thread.sleep(6000);
			driver.findElement(By.id("j_username")).sendKeys("ADMIN");
			driver.findElement(By.id("j_password")).sendKeys("TSMtsm111!");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input.btn")).click();
			Thread.sleep(5000);	
			System.out.println("TSM Main page accessed successfully"); 
	}
		    
		}
	
	@Given("^Access Check Rates$")
	public void access_Check_Rates() throws Throwable {
		
		Thread.sleep(5000);
		
		  WebElement web_Element_To_Be_Hovered = driver.findElement(By.id("menu:formMenuApplication:j_id15"));
			Actions builder = new Actions(driver);
			builder.moveToElement(web_Element_To_Be_Hovered).click();
			Thread.sleep(2000);
			builder.moveToElement(web_Element_To_Be_Hovered).perform();
			WebElement destino = driver.findElement(By.xpath("//span[contains(text(),'Check Rates')]"));
			builder.moveToElement(destino).click();
			Thread.sleep(2000);
			builder.moveToElement(destino).perform();
			Thread.sleep(3000);
			System.out.println("Check Rates accessed correctly");
			

			Thread.sleep(6000);
	    
	}

	@Given("^perform searchs$")
	public void perform_searchs() throws Throwable {
		


		//LocalDate.now().format("MM/dd/yyyy");

		
		
	    
		((JavascriptExecutor)driver).executeScript ("document.getElementById('body:checkRateForm:startingDateFilter').removeAttribute('readonly',0);");

		


		//LocalDate.now().format("MM/dd/yyyy");

		String date = LocalDate.now().minusDays(19).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
		System.out.println(date);
		
		String newdate = date.toString();
		
		
		
		
	    

		//CONSULTA SEG1 1 NB TODOS LOS GANTRIES
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_NB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='11011']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Primer gantry de SEG 1 NB consultado");
		Thread.sleep(60000);
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_NB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='11012']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Segundo gantry de SEG 1 NB consultado");
		Thread.sleep(60000);
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_NB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='11021']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Tercer gantry de SEG 1 NB consultado");
		Thread.sleep(60000);
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_NB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='11141']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Cuarto gantry de SEG 1 NB consultado");
		Thread.sleep(60000);
		
		
		
		//CONSULTA SEG1 1 SB TODOS LOS GANTRIES
	
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_SB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='11131']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Primer gantry de SEG 1 consultado");
		Thread.sleep(60000);
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_1_SB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		//td[@ec_value='11132']
		driver.findElement(By.xpath("//td[@ec_value='11132']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Segundo gantry de SEG 1 SB consultado");
		Thread.sleep(60000);
	//CONSULTA SEG_2_EB TODOS LOS GANTRIES
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_2_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='12031']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Primer gantry de SEG 2 EB consultado");
		Thread.sleep(60000);
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_2_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		//td[@ec_value='11132']
		driver.findElement(By.xpath("//td[@ec_value='12041']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		Thread.sleep(60000);
		Thread.sleep(5000);
		//td[@ec_value='11132']
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_2_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[@ec_value='12151']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Segundo gantry de SEG 2 EB consultado");
		Thread.sleep(60000);
		//CONSULTA SEG_2_WB
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_2_WB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='12101']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Primer gantry de SEG 2 WB consultado");
		Thread.sleep(60000);
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_2_WB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		//td[@ec_value='11132']
		driver.findElement(By.xpath("//td[@ec_value='12121']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Segundo gantry de SEG 2 WB consultado");
		Thread.sleep(60000);
		
		//CONSULTA SEG 3 EB
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='13051']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		
		System.out.println("Primer gantry de SEG 3 EB consultado");
		Thread.sleep(60000);
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='13061']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		
		System.out.println("Segundo gantry de SEG 3 EB consultado");
		Thread.sleep(60000);
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='13081']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Tercer gantry de SEG 3 EB consultado");
		Thread.sleep(60000);
		
		//CONSULTA SEG 3 EB
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='13051']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Cuarto gantry de SEG 3 EB consultado");
		Thread.sleep(60000);
		
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_EB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='13061']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		
		System.out.println("Quinto gantry de SEG 3 EB consultado");
	
		
		Thread.sleep(60000);
		
		
	
		
		//CONSULTA SEG 3 WB
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_WB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		
		driver.findElement(By.xpath("//td[@ec_value='13071']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Primer gantry de SEG 3 WB consultado");
		Thread.sleep(60000);
		
		
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_WB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='13082']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		
		System.out.println("Segundo gantry de SEG 3 WB consultado");
		
		Thread.sleep(60000);
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_WB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='13091']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Tercer gantry de SEG 3 WB consultado");
		Thread.sleep(60000);
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbSegment']//img[@class='imgComboBox']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'SEG_3_WB')]")).click();
		
		driver.findElement(By.xpath("//table[@id='body:checkRateForm:idCmbGantry']//img[@class='imgComboBox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@ec_value='13111']")).click();
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("body:checkRateForm:startingDateFilter")).sendKeys(newdate); 
		driver.findElement(By.id("body:checkRateForm:acceptButton")).click();
		System.out.println("Cuarto gantry de SEG 3 WB consultado");
		Thread.sleep(60000);
		
		
	
	}

	@Then("^test is successful$")
	public void test_is_successful() throws Throwable {
		
		
		
	    
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
