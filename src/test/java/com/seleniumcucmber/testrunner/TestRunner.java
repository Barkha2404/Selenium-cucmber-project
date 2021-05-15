package com.seleniumcucmber.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"Feature"},
		glue= {"com.selenium.cucmber.stepdef"},
		plugin= {"pretty","html:target/cucumber-report/report.html","json:target/cucumber.json"}, 
		monochrome=true,
		tags="@Data_Driven"
		
		)


public class TestRunner 
{
	
}
