package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_05_WebBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Browser() {
        //Mở 1 url bất kỳ
        driver.get("https://live.techpanda.org/");

        //Đóng Browser - Không quan tâm có bao nhiêu tab, window
        driver.quit();

        //Đóng Browser - Chỉ đóng tab hiện tại
        driver.close();

        driver.findElement(By.cssSelector(""));


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
