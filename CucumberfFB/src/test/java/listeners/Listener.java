package listeners;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import facebook.CucumberfFB.Baseclass;
import takess.Takingss;



public class Listener extends Baseclass implements ITestListener{
	Baseclass d = new Baseclass();


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test= extent.createTest(driver.getTitle());
		String Screenshotpath = null;
		if(result.getStatus()==ITestResult.SUCCESS) {
			try {
				Screenshotpath = Takingss.Screenshot(driver, "Screenshotforextentreport");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		test.pass(result.getName());
		test.pass("Test matched", MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		extent.flush();
		}

	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test3= extent.createTest(driver.getTitle());
		String Screenshotpath = null;
		if(result.getStatus()==ITestResult.FAILURE) {
			try {
				Screenshotpath = Takingss.Screenshot(driver, "Screenshotforextentreport");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test3.log(Status.FAIL, result.getThrowable());
			test3.fail("Test not matched", MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		}
		//		try {
		//			
		//			d.getScreenshot(result.getName());
		//			
		//			test.fail(result.getThrowable());
		//			extent.flush();
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}




}
