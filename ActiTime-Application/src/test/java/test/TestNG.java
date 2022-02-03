package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;
import pom.ToverifyAccountLeft;

public class TestNG extends Base{

	private WebDriver driver;
	private pom.ActiTimeHeader actiTimeHeader;
	private pom.ActitimeLogin actitimeLogin;
	private ToverifyAccountLeft toverifyAccountLeft;
	private SoftAssert soft;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;

	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("launchTheBrowser");
		
		
		if(browser.equals("chrome"))
		{
			 driver = openChromebrowser();
		}
	       
		if(browser.equals("firefox"))
		{
			driver=openFirefoxbrowser();	
		}
	        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void loginActiTime() throws InterruptedException {
		driver.get("http://localhost/login.do");
		Thread.sleep(3000);
		actitimeLogin = new pom.ActitimeLogin(driver);
		actitimeLogin.sendUsername();
		Thread.sleep(3000);
		actitimeLogin.sendPassword();
		actitimeLogin.clickOnloginButton();

		actiTimeHeader = new pom.ActiTimeHeader(driver);

		soft = new SoftAssert();
	}

	@Test
	public void toverifyUsertab() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		actiTimeHeader.clickOnUserTab();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "http://localhost/administration/userlist.do");

		// soft Assert.

		String title = driver.getTitle();

		soft.assertNotEquals(title, "actiTIME -  User List ");

		

		toverifyAccountLeft = new ToverifyAccountLeft(driver);

		String buttonName = toverifyAccountLeft.accountleft();
		
		 soft.assertEquals(buttonName, "4 accounts left");

		soft.assertAll();

	}

	@Test
	public void toVerifyReportTab() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actiTimeHeader.clickOnReportTab();
		Thread.sleep(3000);
		String url1 = driver.getCurrentUrl();

		// Assert.assertEquals(url1, "http://localhost/reports/reports.");
	}

	@AfterMethod
	public void logOutFormActitime() {

		actiTimeHeader.clickOnLogoutTab();

	}

	@AfterClass
	public void closeTheBrowser() {
		System.out.println("closed");
		driver.quit();
	}

}
