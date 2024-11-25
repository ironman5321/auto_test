package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_02_Locator_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_ID() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname"));
    }

    @Test
    public void TC_02_Class() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.className("inputsearch2"));
    }

    @Test
    public void TC_03_Link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.linkText("Hướng dẫn sử dụng"));
    }

    @Test
    public void TC_04_Partial_Link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.partialLinkText("thanh toán"));
    }

    @Test
    public void TC_05_Name() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.name("txtEmail"));
    }

    @Test
    public void TC_05_Tag_Name() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        int inputNumber = driver.findElements(By.tagName("input")).size();
        System.out.println("Tổng số lượng input: " + inputNumber);
    }

    @Test
    public void TC_06_Css() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("#txtEmail"));
        driver.findElement(By.cssSelector(".inputsearch2"));
        driver.findElement(By.cssSelector("a[href='https://alada.vn/cau-hoi-thuong-gap.html']"));
        driver.findElement(By.cssSelector("a[href^='https://alada.vn/']"));
        driver.findElement(By.cssSelector("a[href*='alada.vn/cau-hoi-thuong-gap']"));
        driver.findElement(By.cssSelector("a[href$='cau-hoi-thuong-gap.html']"));

        int inputNumber = driver.findElements(By.cssSelector("input")).size();
        System.out.println("Tổng số lượng input: " + inputNumber);
    }

    @Test
    public void TC_07_XPath() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtEmail']"));
        driver.findElement(By.xpath("//input[@class='inputsearch2']"));
        driver.findElement(By.xpath("//a[text()='Câu hỏi thường gặp']"));
        driver.findElement(By.xpath("//a[starts-with(@href,'https://alada.vn/huong-dan-thanh')]"));
        driver.findElement(By.xpath("//a[contains(@href,'https://alada.vn/huong-dan-thanh')]"));

       int inputNumber = driver.findElements(By.xpath("//input")).size();
       System.out.println("Tổng số lượng input: " + inputNumber);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
