package pageobject;

import org.openqa.selenium.By;

import static base.BrowserStartStop.driver;
/**
 * The Class represents CheckboxPage
 *
 * @author Kamalesh N
 */
public class CheckboxPageObj {

    /** Locator. */
    By practiceSite = By.xpath("//div[@id=\"LinkList74\"]//child::a[text()='Practice Site']");
    By checkbox = By.xpath("//a[text()='Checkbox']");

    public By manualCheckbox = By.xpath("//form[@id='checkboxes']//child::label[1]");

    By seleniumDriver = By.xpath("//form[@id='checkboxes']//child::label[3]");

    /**
     * Click Login in to practiceSite.
     * Navigate to checkbox menu
     */
    public void practiceSiteButton(){
        driver.findElement(practiceSite).click();
    }
    public void checkboxMenu(){
        driver.findElement(checkbox).click();
    }
    public void seleniumDriverCheckbox(){
        driver.findElement(seleniumDriver).click();
    }
    public void manualCheckbox(){driver.findElement(manualCheckbox).click();}

}
