package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitType;
import utilities.WaitUtilis;

public class LoginPage extends BasePage{

	@FindBy(xpath="//a[@id='login2']")
	private WebElement loginlink;
	
	@FindBy(xpath="//input[@id='loginusername']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	private WebElement loginbutton;
	
	
	public LoginPage(WebDriver driver) {
	    super(driver);
	}
	
	public void clickloginLink()
	{
		WaitUtilis.scrollToElement(loginlink);
		loginlink.click();
	}
	
	public void enterUsername(String uname)
	{
		WaitUtilis.waitAndClick(username, WaitType.LARGE);
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickLoginButton()
	{
		loginbutton.click();
	}
	public void enterLoginDetails(String username,String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	
}
