package com.selenium.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculator extends TestBase {

	@FindBy(css = "input[ng-model='first']")
	public WebElement txtFirstNumber;

	@FindBy(css = "input[ng-model='second']")
	public WebElement txtSecondNumber;

	@FindBy(css = "select[ng-model='operator']")
	public WebElement dropDownOperator;

	@FindBy(id = "gobutton")
	public WebElement btnGO;

	@FindBy(xpath="/html/body/div/div/form/h2")
	public WebElement outputValue;
	
	

	public void exportPageObjectElement_Calculator() {

		PageFactory.initElements(w, this);
	}

}
