package pageobject;

import org.openqa.selenium.By;

import static base.BrowserStartStop.driver;
/**
 * The Class represents DatePickerPage
 *
 * @author Kamalesh N
 */
public class DatePickerPageObj {
    /** Locator. */
    By practiceSite = By.xpath("//div[@id=\"LinkList74\"]//child::a[text()='Practice Site']");
    By datePicker = By.xpath("//a[text()='DatePicker']");
    By dateSelect = By.id("date");
    /**
     * Click Login in to practiceSite.
     * Navigate to datePicker menu
     */
    public void practiceSiteButton(){
        driver.findElement(practiceSite).click();
    }
    public void datePickerMenu(){
        driver.findElement(datePicker).click();
    }
    public void dateSelect(String date){
      driver.findElement(dateSelect).sendKeys(date);
    }
}
