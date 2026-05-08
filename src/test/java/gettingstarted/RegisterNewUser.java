package gettingstarted;

import java.awt.print.Pageable;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class RegisterNewUser {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.getByText("New user? Signup").click();
		page.pause();
		PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isDisabled();
		page.locator("#name").fill("Payal S");
		page.getByPlaceholder("Email").fill("admin4321@gmail.com");
		page.getByPlaceholder("Password").fill("stream");
		page.locator("xpath=//label[text()='JavaScript']//preceding::input[1]").click();
PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='JavaScript']//preceding::input[1]")).isChecked();	
page.locator("xpath=//input[@value='Female']").click();
PlaywrightAssertions.assertThat(page.locator("xpath=//input[@value='Female']")).isChecked();
page.locator("#state").selectOption("Goa");
String hobbies[]= {"Playing", "Swimming"};
page.locator("#hobbies").selectOption(hobbies);
PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
page.locator(".submit-btn").click();
page.waitForTimeout(5000);

		

	}

}
