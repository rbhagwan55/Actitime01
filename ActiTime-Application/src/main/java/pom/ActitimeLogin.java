package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLogin {
	
	@FindBy (xpath="//input[@placeholder='Username']")
	 private WebElement username;
	
	@FindBy (xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement loginButton;
	
	  // constructor
	public ActitimeLogin( WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}
	
	//perform Action on webelement.
	
	public void sendUsername()
	{
		username.sendKeys("admin");
	}
	
	
	public void sendPassword()
	{
	    password.sendKeys("manager");
	}
	
	public void clickOnloginButton()
	{
		loginButton.click();
	}
	

}
