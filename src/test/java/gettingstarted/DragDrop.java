package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragDrop {

	public static void main(String[] args) {
		

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/droppable/");
		FrameLocator locate = page.frameLocator(".demo-frame");
		locate.locator("#draggable").dragTo(locate.locator("#droppable"));
		
		
		
		
		

	}

}
