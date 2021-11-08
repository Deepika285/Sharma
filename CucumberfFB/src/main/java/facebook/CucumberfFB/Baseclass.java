package facebook.CucumberfFB;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baseclass {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports extent;
	public ExtentSparkReporter spark;

	public Baseclass() {
		spark = new ExtentSparkReporter("ExtentedReport\\indexRep.html");
		extent = new ExtentReports();
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Test Report Techademy");
		spark.config().setReportName("Test Report Techademy");
		extent.attachReporter(spark);
	}

	public WebDriver initializeBrowser() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vivek\\eclipse-workspace\\CucumberfFB\\src\\main\\java\\facebook\\CucumberfFB\\prop.properties");

			prop.load(fis);
			String browserName = prop.getProperty("browser");
			String driverPath = prop.getProperty("driverPath");

			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
			} else {
				System.out.println("No browser Driver Specified");
				// Currently having only chrome driver in system so not specifying other can be
				// specified using if else if ladder.
			}

			// Implicit wait to avoid element not found exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Maximize browser
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

	public void getScreenshot(String result) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("C:\\Users\\vivek\\eclipse-workspace\\CucumberfFB\\Screenshot\\screenshot.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
