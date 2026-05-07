package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywrightTest {

	public static void main(String[] args) {
		
		Playwright pw =  Playwright.create();
		BrowserType browserType = pw.chromium();
		
		//headless mode
	//	Browser browser = browserType.launch();
		
		//Normal mode
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
		Page page = browser.newPage();
		page.navigate("https://reqres.in/");
		String title = page.title();
		System.out.println("Title is" +title);
		
		browser.close();
		pw.close();

	}

}
