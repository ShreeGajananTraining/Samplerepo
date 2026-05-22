package gettingstarted;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

//class
public class CrossBrowsertesting {
	
	//To access from every test and method
	Playwright pw;
	Browser browser;
	Page page;

//setup method - browser depends on browser name e.g chrome , firefox or edge 	
//we need to provide parameters 
	
	@Parameters("BrowserName")
	@BeforeMethod
	public void setup(@Optional ("Chrome") String browserName)
	{
		//In detail
	//	Playwright pw = Playwright.create();
	//	BrowserType browserType = pw.chromium();
	//	browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		//Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		pw = Playwright.create();
	//We want diff browserType for diff browser so initially keep it null
		BrowserType browserType = null;
		
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			browserType = pw.chromium();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) 
		{
			browserType = pw.firefox();
		}
		else if (browserName.equalsIgnoreCase("Safari")) 
		{
			browserType = pw.webkit();
		}
		
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		page = browser.newPage();
		
		
	}
	
	
	
//Test no 1 will run based on parameter
	@Test
	public void loginTest() throws InterruptedException
	{
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	Thread.sleep(3000);
	System.out.println(page.title());
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		page.close();
		browser.close();
		pw.close();
		
	}
	
	
	
}
