package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToverifyAccountLeft {

	   // textverify.
	 private WebDriver driver;
	  
	
    @FindBy (xpath="//span[@id='licenseCountId']")
     private WebElement verify;
	    
    
    
    public ToverifyAccountLeft (WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    }
    
    
    public String accountleft()
    {
    	String createNewAccounttest= verify.getAttribute("id");
    	return createNewAccounttest;
    	
    }
    
}
