package testcase;

import base.BrowserStartStop;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.DropDownPageObj;
import pageobject.LoginPageObject;
/**
 * The Class DropDownTest.
 *
 * @author Kamalesh N
 */
public class DropDownTest extends LoginPageObject {

    BrowserStartStop base = new BrowserStartStop();
    LoginTest login = new LoginTest();
    DropDownPageObj dropDownPageObj = new DropDownPageObj();
    /**
     * Setup & Login.
     */
    @BeforeClass
    public void login() {
        base.browserStart();
        login.login();
        login.closeEventTap();
    }

    @Test
    public void checkbox() throws InterruptedException {
        //Select Practice Site button
        dropDownPageObj.practiceSiteButton();
        //Select Dropdown menu
        dropDownPageObj.dropDownMenu();
        Thread.sleep(1000);
        dropDownPageObj.selectLanguage();
    }

    @Test
    public void checkbox1(){
        dropDownPageObj.selectSeleniumConcept();
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
