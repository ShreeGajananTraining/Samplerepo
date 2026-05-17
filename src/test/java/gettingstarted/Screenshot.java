package gettingstarted;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Screenshot {

	public static void main(String[] args) {
Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		Page page = browser.newPage();
		page.navigate("https://www.naukri.com/");
		
		//screenshot of locator
		page.locator("//a[@title='Jobseeker Login']").screenshot(new ScreenshotOptions().setPath(Paths.get("File/Screenshotnew.png")));

		Utility.captureScreenshot(page);
		
		
	}

}



