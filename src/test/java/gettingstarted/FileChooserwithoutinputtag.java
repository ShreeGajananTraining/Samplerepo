package gettingstarted;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForFileChooserOptions;
import com.microsoft.playwright.Playwright;

public class FileChooserwithoutinputtag {

	public static void main(String[] args) {
		
		Browser browser =Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/upload");

		//when we have custom tag and id (upload file without input tag)
		FileChooser fileChooser = page.waitForFileChooser(()-> page.locator("#drag-drop-upload").click());

		//fileChooser.setFiles(Paths.get(System.getProperty("user.dir")+"/Files/Screenshot.png"));	
		Path[] files = {Paths.get(System.getProperty("user.dir")+"/Files/Screenshot.png"),
				Paths.get(System.getProperty("user.dir")+"/Files/Screenshot - Copy1.png")
				
				};
		fileChooser.setFiles(files);
		
	
	
	}

}
