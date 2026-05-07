package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogut {

	public static void main(String[] args) {
		
		Page page = null;
		Browser browser = null;
	try 
	{
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
	page = browser.newPage();
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	System.out.println("Link");
	PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
	System.out.println("url open");
	
	//Login
	page.locator("#email1").fill("admin@email.com");
	page.getByPlaceholder("Enter Password").fill("admin@123");
	//page.getByText("Sign in").click();
	page.locator("xpath = //button[@class='submit-btn']").click();
	
	
	}
	
	finally
	{
	//page.close();
	//browser.close();
	}
	}

}
