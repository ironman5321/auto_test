package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_ID() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.id("textfield"));
    }

    @Test
    public void TC_02_Class() {
       


    }

    @Test
    public void TC_03_Name() {



    }

    @Test
    public void TC_04_Link() {



    }

    @Test
    public void TC_05_Partial_Link() {



    }

    @Test
    public void TC_06_Tag_Name() {



    }

    @Test
    public void TC_07_Css() {



    }

    @Test
    public void TC_08_XPath() {



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
