package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_03_Relative_Locator_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Relative_Locator() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //Gender - Male
        driver.findElement(By.xpath("//input[@id='gender-male']"));

        //Gender - Female
        driver.findElement(By.xpath("//input[@id='gender-female']"));

        //First Name
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //Last Name
        driver.findElement(By.xpath("//input[@id='LastName']"));

        //Date of birth Day
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        //Date of birth Month
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));

        //Date of birth Year
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        //Email
        driver.findElement(By.id("Email"));

        //Company Name
        driver.findElement(By.id("Company"));

        //Newsletter
        driver.findElement(By.xpath("//input[@id='Newsletter']"));

        //Password
        driver.findElement(By.id("Password"));

        //Confirm Password
        driver.findElement(By.id("ConfirmPassword"));

        //Register Button
        driver.findElement(By.id("register-button"));

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
