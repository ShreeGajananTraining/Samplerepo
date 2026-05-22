package pageobjectmodeltest;


import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pageobjectmodelpages.LoginPage;

public class TestUsingPOM {

	//method
	@Test
	public void login()
	{
		
		Browser browser =   Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		//Create object of LoginPage class and as we have parameterized constructor we will pass that reference
		
		LoginPage loginPage = new LoginPage(page);
		
		//call the method
		loginPage.loginToApplication("admin@email.com","admin@123");
		
	
		
	}
	
	
	
	
	
}
