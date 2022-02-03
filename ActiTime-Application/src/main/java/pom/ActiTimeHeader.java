package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeHeader {
	

	
	@FindBy (xpath="//a[@class='content users']")  ////a[@class='content users']
	private WebElement clickOnUser;
	
	@FindBy (xpath="//a[@class='content reports']")  //   //a[@class='content reports']"
	private WebElement clickOnReport;
	
	@FindBy (xpath="//a[@id='logoutLink']")        //    /a[@id='logoutLink']
	private WebElement clickOnLogout;

	 // to verify text
	
	
	
	
	public ActiTimeHeader(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
		 
	}
	
	public void clickOnUserTab()
	{
		clickOnUser.click();
	}
	
	public void clickOnReportTab()
	{
		clickOnReport.click();
	}
	
	public void clickOnLogoutTab()
	{
		clickOnLogout.click();
	}
	
}


