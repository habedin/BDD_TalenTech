package com.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^I open Chrome driver$")
	public void i_open_Chrome_driver() {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe"); // gets driver location
		driver = new ChromeDriver(); // calls driver
		driver.manage().window().maximize(); // maximizes window
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // sets up default wait time of 5 seconds after every action
		wait = new WebDriverWait(driver, 5);
	}

	@When("^I navigate to demo\\.oscommerce\\.com$")
	public void i_navigate_to_demo_oscommerce_com() {
		driver.get("https://demo.oscommerce.com/");
	}

	@Then("^I should be taken to OS Commerce$")
	public void i_should_be_taken_to_OS_Commerce() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.oscommerce.com/");
		Assert.assertEquals(driver.getTitle(), "osCommerce Demo");
		driver.close();
	}

}
