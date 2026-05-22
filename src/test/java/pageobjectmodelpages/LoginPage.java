package pageobjectmodelpages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

	//Locators
	private Locator usernameLocator;
	private Locator passwordLocator;
	private Locator submitButtonLocator;
	
	//COnstructor
	//Everytime object is created this constructor is called
	//3 locators will get initialised when constructor is called
//	As we want to use page.locator so we are pasing arg as Page page
	public LoginPage(Page page) 
	{
		usernameLocator = page.locator("#email1");
		passwordLocator = page.locator("#password1");
		submitButtonLocator = page.locator(".submit-btn");
		
	}
	
	// 1  - create login method and pass parAMETER
	// 2 - create method of each action and pass parameter
	
	//Action or Methods
	
	public void loginToApplication(String user , String pass)
	{
		usernameLocator.fill(user);
		passwordLocator.fill(pass);
		submitButtonLocator.click();
		
	}
	
	
	
	
}
