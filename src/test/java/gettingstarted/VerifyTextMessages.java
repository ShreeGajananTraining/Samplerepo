package gettingstarted;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyTextMessages {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".submit-btn").click();
		String expected = "Email and Password is required";
		String message = page.locator(".errorMessage").textContent();
		System.out.println(message);
		//Assert.assertEquals(expected, message);
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(expected);
		
		
		
		
		
	}

}
