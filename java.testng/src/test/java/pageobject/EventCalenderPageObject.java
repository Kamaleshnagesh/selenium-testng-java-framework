package pageobject;

import base.BrowserStartStop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
/**
 * The Class represents EventCalenderPage
 *
 * @author Kamalesh N
 */

public class EventCalenderPageObject extends BrowserStartStop {
    /** Locator. */
     By dateSelection = By.id("currentDay");
     By eventName = By.id("txtTitle");
     By eventDescription = By.id("txtDesc");
     By eventIncludePerson = By.id("selectNo");
     public By eventTime = By.id("txtCheckBox");

     By eventType = By.id("txtType");

     By eventTypeName = By.xpath("//li[text()='Business']");

     By eventReferFile = By.id("imageUpload");

     By buttonSave = By.id("btnSave");

    public By eventText = By.id("eventText");

    public By eventDesc = By.id("eventDesc");

     By buttonClose = By.xpath("//div[@class='btn_event']//child::button[@class='btnClose']");
    /**
     * Click Login in to practiceSite.
     * Navigate to  dateSelection menu
     */
    public void dateSelection(){
        driver.findElement(dateSelection).click();
    }

    public void addEventName(String eName){
        driver.findElement(eventName).sendKeys(eName);
    }

    public  void addEventDesc(String eDesc){
        driver.findElement(eventDescription).sendKeys(eDesc);
    }

    public void selectEventPerson(){
        driver.findElement(eventIncludePerson).click();
    }

    public void selectEventTime(){
       driver.findElement(eventTime).click();
    }

    public void selectEventType(){
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(eventType)).perform();
        driver.findElement(eventTypeName).click();
    }
    public void imageUpload() throws  AWTException {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(eventReferFile)).perform();
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection stringSelection = new StringSelection(FileReader("eventImage"));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public WebElement element(By key){
        return driver.findElement(key);
    }

    public String getText(By key){
        return driver.findElement(key).getText();
    }

    public void save(){
        driver.findElement(buttonSave).click();
    }

    public void close(){
        driver.findElement(buttonClose).click();
    }
}
