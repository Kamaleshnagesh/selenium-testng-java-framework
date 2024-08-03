package testcase;

import base.BrowserStartStop;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.CheckboxPageObj;
import pageobject.LoginPageObject;

/**
 * The Class CheckboxTest.
 *
 * @author Kamalesh N
 */
public class CheckboxTest extends LoginPageObject {

    BrowserStartStop base = new BrowserStartStop();
    LoginTest login = new LoginTest();
    CheckboxPageObj checkboxObj = new CheckboxPageObj();
    /**
     * Setup & Login.
     */
    @BeforeClass
    public  void login() {
        base.browserStart();
        login.login();
        login.closeEventTap();
    }
    /**
     * Checkbox validation test.
     */
    @Test
    public void checkbox() throws InterruptedException {
        //Select Practice Site button
        checkboxObj.practiceSiteButton();
        //Select Checkbox Menu
        checkboxObj.checkboxMenu();
        Thread.sleep(1000);
        boolean manualIsEnabled= driver.findElement(checkboxObj.manualCheckbox).isEnabled();
        if (manualIsEnabled){
            checkboxObj.seleniumDriverCheckbox();
        }
        else {
            checkboxObj.manualCheckbox();
        }
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
