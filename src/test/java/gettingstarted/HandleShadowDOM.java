package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowDOM {

	public static void main(String[] args) {
		
Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		Page page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
	//	Make sure root is open - closed is not allowed
//Xpath is not allowed use css selector
		
		Locator shadowroot = page.locator("div#userName");
		Locator element = shadowroot.locator("#kils");
		element.fill("hhhh");
	
	
	}

}
