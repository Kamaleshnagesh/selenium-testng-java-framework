package testcase;

import base.BrowserStartStop;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.LoginPageObject;
import pageobject.MouseActionPageObj;
/**
 * The Class DatePickerTest.
 *
 * @author Kamalesh N
 */
public class MouseActionTest extends LoginPageObject {

    BrowserStartStop base = new BrowserStartStop();
    LoginTest login = new LoginTest();
    MouseActionPageObj mouseActionPageObj = new MouseActionPageObj();

    @BeforeClass
    public  void login() {
        base.browserStart();
        login.login();
        login.closeEventTap();
    }

    @Test (priority = 1)
    public  void mouseRightClick() {
        //Select Practice Site
        mouseActionPageObj.practiceSiteButton();
        //Select Mouse Action Menu
        mouseActionPageObj.mouseActionMenu();
        //Right Click with Action Class
        mouseActionPageObj.rightClick();
    }

    @Test (priority = 2)
    public  void mouseDoubleClick() {
        mouseActionPageObj.doubleClick();
    }

    @Test (priority = 3)
    public  void mouseDragDrop() {
        mouseActionPageObj.dragDrop();
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
