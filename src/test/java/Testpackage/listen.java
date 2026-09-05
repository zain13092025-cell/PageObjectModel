package Testpackage;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class listen extends Baseclass implements ITestListener
{
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void launch() {
		// TODO Auto-generated method stub
		super.launch();
	}

	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		super.terminate();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		
	ITestListener.super.onTestStart(result);
	String testname = result.getMethod().getMethodName();
	test = extent.creatTest(testname);
	thread.set(test);
	thread.get().info("i am running automation framework.");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		ITestListener.super.onTestSuccess(result);
		System.out.println("test is pass");
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		ITestListener.super.onTestFailure(result);
		System.out.println("test is failed");
	
	
	String testname=result.getMethod().getMethodName();
	
	try {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_HH_mm_ss");
		String timestamp = now.format(formatter);
		
		w = (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
		
		TakesScreenshot tc = (TakesScreenshot) w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/test.png");
	    Files.copy(src, dest);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}