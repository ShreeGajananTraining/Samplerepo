package gettingstarted;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TracingDemo {
	@Test
public void loginTest()

{
		Browser browser = null;
		Page page = null;
		BrowserContext context = null;
		
		
		try {
		
		
		
	browser =Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
 context = browser.newContext();
	
	//start tracing
	
	context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
	page = context.newPage();
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	Assert.assertTrue(page.title().contains("Learn Automation Courses"));
	page.getByPlaceholder("Enter Email").fill("admin@email.com");
	page.getByPlaceholder("Enter Password").fill("admin@123");
	page.getByText("Sign in").last().click();
	PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
	page.getByAltText("manage").click();
	page.getByText("Sign out").click();
	PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
	
	//stop tracing
	context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Tracingnew.zip")));
	
		}
	
	finally {
	
	
	context.close();
	page.close();
	browser.close();
	
	}
	
	
	









}
}
