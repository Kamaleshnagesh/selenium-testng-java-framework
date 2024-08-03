package testcase;

import base.BrowserStartStop;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.EventCalenderPageObject;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

/**
 * The Class EventCalendarTest.
 *
 * @author Kamalesh N
 */
public class EventCalendarTest extends EventCalenderPageObject {

    BrowserStartStop base = new BrowserStartStop();
    LoginTest login = new LoginTest();
    /**
     * Setup & Login.
     */
    @BeforeClass
    public void login() throws IOException {
        base.browserStart();
        login.login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login.switchToEventCalenderTap();
    }

    @Test (priority = 7)
    public void EventSelection() throws AWTException {
    driver.switchTo().frame("iframeCalendar");
    dateSelection();
    addEventName(FileReader("eventName"));
    addEventDesc(FileReader("eventDesc"));
    if (element(eventTime).isSelected()){
        System.out.println("Selected");
    }
    else {
        selectEventTime();
    }
    selectEventType();
    imageUpload();
    save();
    driver.switchTo().alert().accept();
    }


   @Test (priority = 8)
   public void eventVerification(){
        dateSelection();
        Assert.assertEquals(FileReader("eventName"),getText(eventText));
        Assert.assertEquals(FileReader("eventDesc"),getText(eventDesc));
        close();
    }
    /**
     * Wrap up.
     */
    @AfterClass
    public void wrapUp() {
        base.browserStop();
        System.out.println("Stop");
    }
}
