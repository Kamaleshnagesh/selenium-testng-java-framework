package testcase;

import base.BrowserStartStop;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.DatePickerPageObj;
import pageobject.LoginPageObject;

/**
 * The Class DatePickerTest.
 *
 * @author Kamalesh N
 */
public class DatePickerTest extends LoginPageObject {
    BrowserStartStop base = new BrowserStartStop();
    LoginTest login = new LoginTest();

    DatePickerPageObj datePickerPageObj = new DatePickerPageObj();
    /**
     * Setup & Login.
     */
    @BeforeClass
    public  void login(){
        base.browserStart();
        login.login();
        login.closeEventTap();
    }

    @Test
    public void datePicker() throws InterruptedException {
        //Select Practice Site Option
        datePickerPageObj.practiceSiteButton();
        //Select Date Picker Menu
        datePickerPageObj.datePickerMenu();
        Thread.sleep(1000);
        datePickerPageObj.dateSelect(FileReader("date"));
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
