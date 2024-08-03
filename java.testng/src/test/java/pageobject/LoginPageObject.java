package pageobject;

import base.BrowserStartStop;
import org.openqa.selenium.By;
/**
 * The Class represents LoginPage
 *
 * @author Kamalesh N
 */

public class LoginPageObject extends BrowserStartStop {

    /** Locator. */
    By userName = By.id("username");
    By password = By.id("password");
    By login = By.xpath("//button[text()='Login']");
    /** Login in. */
    public void userName (String name){

        driver.findElement(userName).sendKeys(name);
    }
    public void password (String pass){

        driver.findElement(password).sendKeys(pass);
    }
    public void loginButton(){

        driver.findElement(login).click();
    }

}
