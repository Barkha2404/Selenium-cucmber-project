package com.selenium.cucmber.stepdef;

import org.junit.Assert;

import com.selenium.pageobject.Calculator;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorTest {

	
	Calculator c=new Calculator ();
	
	@Before("@Mul or @Add or @Sub")
	
	public void openBrowser()
	{
		c.openBrowser("chrome");
	}
	
	@Given("Open application url for testing")
	public void open_application_url_for_testing() throws Exception
	{
	    
		
		c.openApplication(c.readdataPropertiesFile("url_calculator"));
		c.exportPageObjectElement_Calculator();

	}

	@When("User should enter two enter and perform Addition operation")
	public void user_should_enter_two_enter_and_perform_addition_operation() throws Exception 
	{
		c.handleTextBox(c.txtFirstNumber, "4");
		c.handleDropDown(c.dropDownOperator, "+");
		c.handleTextBox(c.txtSecondNumber, "3");
		c.handleClickEvent(c.btnGO);
		c.waitSec(4);
	}
	

	@Then("Result should get display and verify output value for Addition.")
	public void result_should_get_display_and_verify_output_value_for_addition() 
	{
		Assert.assertEquals("7", c.getTextWebElement(c.outputValue));
	}
	    

	@When("User should enter two enter and perform Subtraction operation")
	public void user_should_enter_two_enter_and_perform_subtraction_operation() throws Exception 
	{
	    
		c.handleTextBox(c.txtFirstNumber, "4");
		c.handleDropDown(c.dropDownOperator, "-");
		c.handleTextBox(c.txtSecondNumber, "1");
		c.handleClickEvent(c.btnGO);
		c.waitSec(4);

	}

	@Then("Result should get display and verify output value for Subtraction.")
	public void result_should_get_display_and_verify_output_value_for_subtraction()
	{
		Assert.assertEquals("3", c.getTextWebElement(c.outputValue));
	}

	@When("User should enter two enter and perform Multiplication operation")
	public void user_should_enter_two_enter_and_perform_multiplication_operation() throws Exception
	{
	    

		c.handleTextBox(c.txtFirstNumber, "3");
		c.handleDropDown(c.dropDownOperator, "*");
		c.handleTextBox(c.txtSecondNumber, "3");
		c.handleClickEvent(c.btnGO);
		c.waitSec(4);

	}

	@Then("Result should get display and verify output value for Multiplication.")
	public void result_should_get_display_and_verify_output_value_for_multiplication() {
	   
		Assert.assertEquals("9", c.getTextWebElement(c.outputValue));
	}
	
	@After("@Mul or @Add or @Sub")
	public void closeBrowser() 
	{
		c.closeBrowser();
	}
}
