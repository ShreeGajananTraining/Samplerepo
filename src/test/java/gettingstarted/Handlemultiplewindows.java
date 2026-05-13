package gettingstarted;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handlemultiplewindows {

	public static void main(String[] args) {
		

		
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		//For one page or one tab use below
		//Page page = browser.newPage();
		
		//For multiple tabs use below
		BrowserContext context = browser.newContext();
		//This is for 1st tab
		Page page = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		//Get all the social media
		Locator allLinks = page.locator("//div[@class='social']//a");
		
		for (int i=0;i<allLinks.count(); i++)
		{
		allLinks.nth(i).click();
		}
	
		//Get all the pages
	List<Page> allPages = context.pages();
	for(Page p : allPages)
	{
		String title = p.title();
		
		if(title.contains("Facebook"))
		{
			p.bringToFront();
			p.locator("//input[@name='email']").last().fill("xyz@gmail.com");
			break;
		}
		
		page.bringToFront();
		p.getByPlaceholder("Enter Email").fill("admin@emaikl.com");
	}
	
	
	
	
	
	
	}







}
