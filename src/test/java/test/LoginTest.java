package test;

import org.testng.annotations.Test;

import factory.DriverManager;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	

	@Test
	public void loginwithValidCred()
	{
	
	 LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	 loginPage.clickloginLink();
	 loginPage.enterLoginDetails("pavanol", "test@123");
	 
	}
}
