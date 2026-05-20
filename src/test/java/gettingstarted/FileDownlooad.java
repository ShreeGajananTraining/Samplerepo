package gettingstarted;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownlooad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/download");
		
		Download download = page.waitForDownload(()->
		{
			page.locator("//a[@href='download/test.txt']").click();	
		}
					);
	//If we use below file will get deleted once the page is closed			
	//	System.out.println(download.suggestedFilename());
	//	System.out.println(download.url());
	//	System.out.println(download.path());
				
	//We need to provide path where to save files
		//Provide path
		String downloadPath = System.getProperty("user.dir")+"/Files/"+download.suggestedFilename();
		
		//where the file is saved to find that
		download.saveAs(Paths.get(downloadPath));
		
		//Assertions
		
		if(downloadPath.endsWith(".txt"))
		{
			System.out.println("Verified");
			}
		else {System.out.println("Not verified");
		browser.close();
		return;
		}
		
	/*	if(Files.size(Path.of(downloadPath))>0)
		{
			System.out.println("verified");
		}
		else
		 {System.out.println("Not verified");
			browser.close();
			return;
		}
		*/
		
		
		
	
	
	}

}
