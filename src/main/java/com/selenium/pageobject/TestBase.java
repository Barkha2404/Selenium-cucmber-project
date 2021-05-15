package com.selenium.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver w;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fi;
	public static Properties prop;

	public static void init() throws Exception {

		fi = new FileInputStream(projectPath + "\\config\\config.properties");
		prop = new Properties();
		prop.load(fi);

	}

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			w = new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}

	}

	public void openApplication(String url) {
		w.get(url);
	}

	public void closeBrowser() {

		w.quit();
	}

	public void handleTextBox(WebElement we, String value) {

		we.sendKeys(value);
	}

	public void handleClickEvent(WebElement we) {

		we.click();
	}

	public String getTextWebElement(WebElement we) {
		return we.getText();
	}

	public String getCurrentPageTitle() {
		return w.getTitle();
	}

	public void handleDropDown(WebElement we, String value) {
		Select s = new Select(we);
		s.selectByVisibleText(value);
	}

	public void handleAlert() {
		try {
			w.switchTo().alert().accept();
		} catch (Exception e) {

		}
	}

	public void handleFrame(WebElement we) {
		w.switchTo().frame(we);
	}

	public void waitSec(int sec) throws Exception {
		sec = sec * 1000;
		Thread.sleep(sec);
	}

	public static void takeScreenShot(String fileName) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\" + fileName + ".png"));

	}

	/*public static String takeScreenShotListenerClass(ITestResult result, String status) throws Exception {

		String ScreenshotName;

		ScreenshotName = result.getMethod().getMethodName() + ".png";

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);

		if (status.equalsIgnoreCase("passed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Pass\\" + ScreenshotName));
		} else if (status.equalsIgnoreCase("failed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Fail\\" + ScreenshotName));
		}
		return ScreenshotName;

	}*/

	public String readdataPropertiesFile(String key) throws Exception {

		init();
		return prop.getProperty(key);
	}

}
