package Testpackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class listen implements ITestListener {
    private static final ExtentReports EXTENT = createReport();
    private static final ThreadLocal<ExtentTest> CURRENT_TEST = new ThreadLocal<>();

    private static ExtentReports createReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Application", "Web UI Automation Suite");
        extent.setSystemInfo("Browser", "Chrome");
        return extent;
    }

    @Override
    public void onTestStart(ITestResult result) {
        CURRENT_TEST.set(EXTENT.createTest(result.getMethod().getQualifiedName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        CURRENT_TEST.get().pass("Test completed successfully");
        removeTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = CURRENT_TEST.get();
        test.fail(result.getThrowable());
        WebDriver driver = getDriver(result);
        if (driver != null) {
            try {
                Path screenshot = saveScreenshot(driver, result.getMethod().getMethodName());
                test.fail("Failure screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
            } catch (IOException | RuntimeException screenshotError) {
                test.warning("Unable to capture failure screenshot: " + screenshotError.getMessage());
            }
        }
        removeTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        CURRENT_TEST.get().skip("Test skipped");
        removeTest();
    }

    @Override
    public void onFinish(ITestContext context) {
        EXTENT.flush();
    }

    private static WebDriver getDriver(ITestResult result) {
        Object instance = result.getInstance();
        return instance instanceof Baseclass ? ((Baseclass) instance).w : null;
    }

    private static Path saveScreenshot(WebDriver driver, String testName) throws IOException {
        Path directory = Paths.get("test-output", "screenshots");
        Files.createDirectories(directory);
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
        Path destination = directory.resolve(testName + "_" + timestamp + ".png");
        Files.write(destination, ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        return destination.toAbsolutePath();
    }

    private static void removeTest() {
        CURRENT_TEST.remove();
    }
}
