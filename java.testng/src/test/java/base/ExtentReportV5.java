package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Class handles the report activities.
 *
 * @author Kamalesh N
 */
public class ExtentReportV5 {

    /** The extent reports. */
    public ExtentReports extentReports;
    /** The extentSpark reports. */
    public ExtentSparkReporter sparkReporter;
    /** The Extent Config File. */
    File reporterConfig = new File(Constants.EXTENT_CONFIG_PATH);
    public ExtentTest test;

    /** Gets the extent reports. */
    public void setReportFile() {
        extentReports = new ExtentReports();
        File reportFile = new File(Constants.REPORT_FILE_PATH);
        sparkReporter = new ExtentSparkReporter(reportFile);
        try {
            sparkReporter.loadXMLConfig(reporterConfig);
        } catch (IOException e) {
            throw new RuntimeException("Config file not found"+ e);
        }
        extentReports.attachReporter(sparkReporter);
    }

    /** System basis info updated on the report. */
    public void systemInfo(){
        extentReports.setSystemInfo("OS" , System.getProperty("os.name"));
        extentReports.setSystemInfo("JAVA Version",System.getProperty("java version"));
    }

    /** erase any previous data on the report and create a new report*/
    public void flush() {
        extentReports.flush();
        File f = new File(Constants.REPORT_FILE_PATH);
        try {
            Desktop.getDesktop().browse(f.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
