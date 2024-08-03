package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static base.BrowserStartStop.driver;
/**
 * The Class represents DropDownPage
 *
 * @author Kamalesh N
 */
public class DropDownPageObj {
    /** Locator. */
    By practiceSite = By.xpath("//div[@id=\"LinkList74\"]//child::a[text()='Practice Site']");
    By dropDown = By.xpath("//a[text()='Dropdown']");
    By selectDropdown = By.id("selectDropdown");
    By dropdown2 = By.xpath("//div[@class='select-selected']");
    By seleniumConcept = By.xpath("//div[text()='Dropdown']");

    /**
     * Click Login in to practiceSite.
     * Navigate to dropDown menu
     */
    public void practiceSiteButton(){
        driver.findElement(practiceSite).click();
    }
    public void dropDownMenu(){
        driver.findElement(dropDown).click();
    }

    public void selectLanguage(){
        WebElement dropdown = driver.findElement(selectDropdown);
        Select s = new Select(dropdown);
        s.selectByValue("python");
    }
    public void selectSeleniumConcept(){
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(dropdown2)).perform();
        driver.findElement(seleniumConcept).click();
    }
}
