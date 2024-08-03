package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static base.BrowserStartStop.driver;
/**
 * The Class represents MouseActionPage
 *
 * @author Kamalesh N
 */
public class MouseActionPageObj {

    /** Locator. */
    public Actions action;
    By practiceSite = By.xpath("//div[@id=\"LinkList74\"]//child::a[text()='Practice Site']");
    By mouseAction = By.xpath("//a[text()='Actions Class']");
    By rightClick = By.id("Right Click");
    By actionMessage = By.id("actionMsg");

    By doubleClick = By.id("Double Click");

    By drag =By.id("drag1");
    By Drop=By.id("Dropable");

    /**
     * Click Login in to practiceSite.
     * Navigate to mouseAction menu
     */
    public void practiceSiteButton(){
        driver.findElement(practiceSite).click();
    }
    public void mouseActionMenu(){
        driver.findElement(mouseAction).click();
    }
    public void rightClick(){
        action = new Actions(driver);
        action.contextClick(driver.findElement(rightClick)).perform();
        String getMessage = driver.findElement(actionMessage).getText();
        System.out.println("Message: "+ getMessage);
    }
    public void doubleClick(){
        action = new Actions(driver);
        action.doubleClick(driver.findElement(doubleClick)).perform();
        String getMessage = driver.findElement(actionMessage).getText();
        System.out.println("Message: "+ getMessage);
    }

    public void dragDrop(){
        action = new Actions(driver);
        action.dragAndDrop((driver.findElement(drag)), driver.findElement(Drop)).perform();
        String getMessage = driver.findElement(Drop).getText();
        System.out.println("Message: "+ getMessage);
    }

}
