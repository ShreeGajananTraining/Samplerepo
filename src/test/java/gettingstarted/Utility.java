package gettingstarted;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.microsoft.playwright.Page;

public class Utility {

	public static byte[] captureScreenshot(Page page)
	{
		SimpleDateFormat customformat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		
		Date date = new Date();
		
		String newDate = customformat.format(date);
		byte[] arr = page.screenshot
				(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot/"+newDate+".png")));

return arr;	
	}
	
	
	
}
