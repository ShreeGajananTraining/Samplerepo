package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlePrompt {

	public static void main(String[] args) {
		
		
		Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page=browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		//By just clicking it is not showing alert so to get that handle use below
		//add this before click bcoz we want to register or we need listener fot this alert
		
		
		page.onDialog(dialog ->{
			String msg = dialog.message();
			System.out.println(msg);
			Assert.assertTrue(msg.contains(msg),"I am a JS prompt");
			dialog.accept("Mukesh Otwani");
			//dialog.dismiss();
		});
		
		page.locator("xpath = //button[text()='Click for JS Prompt']").click();
		
		
		


	}

}
