package utilities;

import base.BrowserStartStop;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
/**
 * The Class is responsible for ScreenShoot Util
 *
 * @author Kamalesh N
 */
public class ScreenshotUtil {

    /**
     * Adds the screenshot in File Path.
     *
     * @param fileName the message
     */

    public String addScreenShotPath(String fileName){
        File scrFile = ((TakesScreenshot) BrowserStartStop.driver).getScreenshotAs(OutputType.FILE);
        File DescFile = new File ("./Screenshot/"+fileName+".png");
        try {
            FileUtils.copyFile(scrFile,DescFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return DescFile.getAbsolutePath();
    }
    /**
    * Adds the screenshot in Base64.
    */
    public String addScreenShotBase64(){
        return ((TakesScreenshot) BrowserStartStop.driver).getScreenshotAs(OutputType.BASE64);

    }
}
