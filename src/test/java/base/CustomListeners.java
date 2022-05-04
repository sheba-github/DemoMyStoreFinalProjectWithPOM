package base;


import java.io.IOException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;
import util.Utilities;



public class CustomListeners extends BaseClass implements ITestListener,ISuiteListener {

	public 	String messageBody;
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {

		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Below is for extent report, it will attach screenshot in the extent report
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.INFO, test.addScreenCapture(Utilities.screenshotName));
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" FAIL");

		
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {

		//below is for extent report
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestStart(ITestResult arg0) {

		test = rep.startTest(arg0.getName().toUpperCase());
	
	}

	public void onTestSuccess(ITestResult arg0) {

		//Below information will log into extent Report
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onFinish(ISuite arg0) {
		
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
	
	}

}
