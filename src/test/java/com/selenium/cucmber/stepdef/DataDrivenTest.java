package com.selenium.cucmber.stepdef;


import org.junit.Assert;

import com.selenium.pageobject.Calculator;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataDrivenTest
{
	Calculator c=new Calculator ();
	@Before("@Data_Driven")
	public void openBrowser()
	{
		c.openBrowser("chrome");
	}
	
	@Given("Open chrome and navigate to calculate page")
	public void open_chrome_and_navigate_to_calculate_page() throws Exception
	{
		c.openApplication(c.readdataPropertiesFile("url_calculator"));
		c.exportPageObjectElement_Calculator();
	}

	@When("Enter two numbers {string} and {string} with operator {string}")
	public void enter_two_numbers_and_with_operator(String firstNumber, String secondNumber, String operator) throws Exception
	{
		c.handleTextBox(c.txtFirstNumber, firstNumber);
		c.handleDropDown(c.dropDownOperator, operator);
		c.handleTextBox(c.txtSecondNumber, secondNumber);
		c.handleClickEvent(c.btnGO);
		c.waitSec(4);
	}

	@Then("Validate output {string}")
	public void validate_output(String result) 
	
	{
		String output =c.getTextWebElement(c.outputValue);
		Assert.assertEquals(result, output);
		
	}
	@After("@Data_Driven")
	public void closeBrowser()
	{
		c.closeBrowser();
	}
}
