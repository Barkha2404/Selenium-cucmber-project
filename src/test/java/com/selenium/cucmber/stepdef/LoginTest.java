package com.selenium.cucmber.stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	WebDriver w;
	
	@Given("Browser should be open with login page")
	public void browser_should_be_open_with_login_page() 
	{
			WebDriverManager.chromedriver().setup();
			w=new ChromeDriver();
			w.get("http://demo.testfire.net/login.jsp");
				
	}

	@When("User should log-in using Username and password")
	public void user_should_log_in_using_username_and_password() 
	{
		w.findElement(By.id("uid")).clear();
		w.findElement(By.id("uid")).sendKeys("admin");
		
		w.findElement(By.id("passw")).clear();
		w.findElement(By.id("passw")).sendKeys("admin");
		
	}

	@When("Click on login button")
	public void click_on_login_button() throws Exception
	{
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
	}

	@Then("Home Page should get Open and verify page title.")
	public void home_page_should_get_open_and_verify_page_title() 
	{
		String pageTitle=w.getTitle();
		Assert.assertEquals("Altoro Mutual", pageTitle);
	}

	@Then("Close browser")
	public void close_browser() {
	    w.quit();
	}


}
