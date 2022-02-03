package base;
           // for crossBrowser testing.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver openChromebrowser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\ChromeDriver key\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		return driver;
	}
	
	
	public static WebDriver openFirefoxbrowser()
	{
		
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		return driver;
	}

}
