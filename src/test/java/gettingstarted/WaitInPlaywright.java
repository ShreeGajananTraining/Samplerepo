package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitInPlaywright {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		
		//30 seconds wait for navigation
	//	page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		//for 60 seconds
		page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html",
				new Page.NavigateOptions().setTimeout(60000));
		
	//	page.setDefaultNavigationTimeout(60000);
		page.locator("//button[text()='Click me to start timer']").click();
		
		//here text is visible after 15 secs so wait for element cna be
		
		 page.locator("//p[text()='WebDriver']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));
		System.out.println("IS visible"  +page.locator("//p[text()='WebDriver']").isVisible() );
		
		
		
		
		
		
		
	}

}
