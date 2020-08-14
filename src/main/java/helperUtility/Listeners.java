package helperUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.TestBase;

public class Listeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Test is finished");
		
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Test is successfully start.");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Test fail after some time");
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		/*try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		System.out.println("i failed executed listeners pass code");
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test is skipped");
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test is starting");
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test is successfully passed");
		
	}

}
