package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handlewindows {

	public static void main(String[] args) {
		

	
	Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	//For one page or one tab use below
	//Page page = browser.newPage();
	
	//For multiple tabs use below
	BrowserContext context = browser.newContext();
	//This is for 1st tab
	Page page = context.newPage();
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	
	//This is for 2nd tab
	Page newTab = context.waitForPage(()-> 
	{
	page.locator("//a[contains(@href,'facebook')]").first().click();
	});
	
	newTab.locator("//input[@name='email']").last().fill("xyz@gmail.com");
	page.bringToFront();
	newTab.bringToFront();
	page.bringToFront();
	
	newTab.close();

	
	
	
	
	
	
	
	}

}
