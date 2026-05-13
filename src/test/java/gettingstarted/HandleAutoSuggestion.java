package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAutoSuggestion {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();
		page.navigate("https://www.google.com");
	//	page.pause();
		//page.getByPlaceholder("Search Google or type a URL").fill("PAyal");
		System.out.println("Hi");
		page.locator("xpath=//textarea[@title='Search']").fill("mukesh otwani ");
System.out.println("kkk");

Locator locator = page.locator("xpath=//ul[@role='listbox']//li");
	
	System.out.println(locator.count());
	
	for(int i=0; i<locator.count();i++)
	{
		
		String text = locator.nth(i).innerText();
	//	System.out.println(text);
		
		if(text.contains("playwright"))
		{
			locator.nth(i).click();
			System.out.println("oooo");
			break;
		}
	}
	
	
	}

}
