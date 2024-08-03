package listeners;
import base.ExtentReportV5;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenshotUtil;

/**
 *The Class MyListener the report activities.
 *
 *@author Kamalesh N.
 * The listener interface for receiving report events. The class that is
 * interested in processing a report event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addReportListener<code> method. When the report event
 * occurs, that object's appropriate method is invoked.
 * ReportEvent
 */


public class MyListener implements ITestListener  {

    ExtentReportV5 ReportV5 = new ExtentReportV5();
    ScreenshotUtil screenshotUtil = new ScreenshotUtil();

    /**
     * Gets the test name.
     *
     * @param result the result
     * @return Test Name
     */
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }
    /**
     * Gets the test description.
     *
     * @param result the result
     * @return Test Description
     */
    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ?
                result.getMethod().getDescription()
                : result.getMethod().getConstructorOrMethod().getName();
    }


    @Override
    public void onTestStart(ITestResult result) {
        ReportV5.test=ReportV5.extentReports
                .createTest(getTestName(result),getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportV5.test.log(Status.PASS, getTestName(result)+": Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Throwable t = result.getThrowable();
        String cause = "";
        if (t != null)
            cause = t.getMessage();
        ReportV5.test.fail(getTestName(result)+": Test Failed --------> "  + cause,
                MediaEntityBuilder.createScreenCaptureFromPath
                (screenshotUtil.addScreenShotPath(getTestName(result))).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportV5.test.log(Status.SKIP, getTestName(result)+": Skipped");
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ReportV5.test.fail
                (getTestName(result)+": Test Failed",MediaEntityBuilder.createScreenCaptureFromBase64String
                        (screenshotUtil.addScreenShotBase64()).build());
    }

    @Override
    public void onStart(ITestContext context) {
        ReportV5.setReportFile();
        ReportV5.systemInfo();
    }

    @Override
    public void onFinish(ITestContext context) {
        ReportV5.flush();
    }

}
