package testcase;

import base.BrowserStartStop;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.LoginPageObject;

import java.util.*;

/**
 * The Class LoginTest.
 *
 * @author Kamalesh N
 */
public class LoginTest extends LoginPageObject {
    /**
     * Setup.
     */
    BrowserStartStop base = new BrowserStartStop();
    @BeforeClass
    public void setup(){
        base.browserStart();
        System.out.println("Start");
    }

    /**
     * Login Validation
     */
    @Test (priority = 1)
    //Login with Valid username and password.
    public void login() {
        userName(FileReader("UserName"));
        password(FileReader("Password"));
        loginButton();
    }


    @Test (priority = 2)
    //Verifying Login page title.
    public void loginTitleVerification(){
        String actualTitle =FileReader("loginTitle");
        String expectedTitle = driver.getTitle();
        Assert.assertEquals (expectedTitle, actualTitle);
    }

    List<String> l;
    @Test (priority = 3)
    //Verifying Event calendar tap is opened.
    public void switchToEventCalenderTap() {


        Set<String> windows = driver.getWindowHandles(); // getting all open window information
        Iterator<String> windowIndex =windows.iterator(); // using Iterator to store the value in list
        l = new ArrayList <>();
        Assert.assertEquals(Integer.parseInt(FileReader("windowCount")),windows.size());
        for (int i=1; i<=windows.size(); i++ )
        {
            l.add(windowIndex.next());
        }
          driver.switchTo().window(l.get(1));
    }

    @Test (priority = 4)
    //Verifying Event Calendar page title.
    public void EventTitleVerification() {
        String eventCalendarActualTitle = FileReader("eventTitle");
        String eventCalendarExpTitle = driver.getTitle();
        Assert.assertEquals(eventCalendarActualTitle, eventCalendarExpTitle);
    }

    @Test (priority = 5)
    public void returnDefaultWindow(){

        driver.switchTo().window(l.getFirst());
    }

    public void closeEventTap(){
        switchToEventCalenderTap();
        driver.close();
        returnDefaultWindow();
    }
    /**
     * Wrap up.
     */
    @AfterClass
    public  void wrapUp() {
        base.browserStop();
        System.out.println("Stop");
    }
}
