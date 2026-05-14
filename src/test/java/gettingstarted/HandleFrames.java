package gettingstarted;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleFrames {

	public static void main(String[] args) {
		
		Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		Page page = browser.newPage();
		page.navigate("https://www.redbus.in/");
		
		page.locator("//button[@class='navOption___418cca']").click();
		page.locator("//button[@class='primaryButton___462797  ']").click();
		
		page.locator("//div//input[@type='tel']").fill("888888888");
		
	
		
		//Get all the frames
		List<Frame> allFrames = page.frames();
		System.out.println(allFrames.size());
		
		//To get particular frame by FrameLocator
	//	FrameLocator getFrame = page.frameLocator("//iframe[@class='modalIframe']");
	//	getFrame.locator("//input[@id=''mobileNoInp]").fill("76767677676");
		
		
		//Inshort above can be written as
		//page.frameLocator("//iframe[@class='modalIframe']").locator("//input[@id=''mobileNoInp]").fill("76767677676");
		
		
		//Second method to get frame bu url/src
	//Frame frameUrl = page.frameByUrl(Pattern.compile(".*login.*"));
	//frameUrl.locator("//input[@id=''mobileNoInp]").fill("76767677676");
		
		
		

	}

}
