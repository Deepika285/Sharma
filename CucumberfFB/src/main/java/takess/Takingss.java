package takess;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import facebook.CucumberfFB.Baseclass;


public class Takingss extends Baseclass {
	public static String Screenshot(WebDriver driver1, String Screenshotname) throws IOException {
		File src=((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
	    String dest = System.getProperty("user.dir") + "\\Screenshot\\" + Screenshotname + System.currentTimeMillis() + ".png";
	    File destination = new File(dest);
	    FileUtils.copyFile(src, destination);
	    return dest;
	}

}
