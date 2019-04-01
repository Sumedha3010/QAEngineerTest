package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	WebDriver driver;


	@Given("^I launch Insurance portal URL$")
	public void LaunchInsurancePortalURL() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		String baseURL = "https://covercheck.vwfsinsuranceportal.co.uk";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	
	@When("^I enter valid vehicle ([^\"]*) into Find Vehicle textbox$")
	public void EnterValidVehicleRegistrationNumber(String registrationNumber) throws Throwable {

	driver.findElement(By.xpath(Locators.txtbox_registration_number)).sendKeys(registrationNumber); 
		}
	
	@When("^I enter invalid vehicle ([^\"]*) into Find Vehicle textbox$")
	public void EnterInvalidVehicleRegistrationNumber(String registrationNumber) throws Throwable {

	driver.findElement(By.xpath(Locators.txtbox_registration_number)).sendKeys(registrationNumber); 
		}		
	

	@Then("^I click on Find Vehicle search button$")
	public void iClickOnFindVehicleSearchButton() {
		driver.findElement(By.xpath(Locators.btn_find_vehicle)).click();
	}

	@Then("^I should see the registered Vehicle details$")
	public void iShouldSeeTheRegisteredVehicleDetails() {
	    WebElement ResultFor = driver.findElement(By.xpath(Locators.verify_result_txt));
	    WebElement CoverStart = driver.findElement(By.xpath(Locators.verfiy_coverStart_Date));
	    WebElement CoverEnd = driver.findElement(By.xpath(Locators.verfiy_coverEnd_Date));
	    Assert.assertEquals(true, ResultFor.isDisplayed());
	    Assert.assertEquals(true, CoverStart.isDisplayed());
	    Assert.assertEquals(true, CoverEnd.isDisplayed());

	}
	
	
	@Then("^I should get an appropriate Error Message ([^\"]*)$")
	public void iShouldSeeAnAppropriateErrorMessage(String Error) throws Throwable {
		
		driver.findElement(By.xpath(Locators.verfiy_error_msg)).getText().contains(Error);
		System.out.println(driver.findElement(By.xpath(Locators.verfiy_error_msg)).getText().contains(Error));
		}
	
	@Then("^I should see the Error Message ([^\"]*)$")
	public void iShouldSeeTheErrorMessage(String Error) throws Throwable {
		
		driver.findElement(By.xpath(Locators.verfiy_error_msg_specialchar)).getText().contains(Error);
		System.out.println(driver.findElement(By.xpath(Locators.verfiy_error_msg_specialchar)).getText().contains(Error));
		}
	
	
	
	@And("^I close the browser$")
	public void closeBrowser() throws Throwable{
		driver.close();
		driver.quit();
	}
	
	
	
	
}