package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Topic_0111111 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://moviecms.visengroup.com/admin/sign-in");
        driver.findElement(By.cssSelector("input[name=\"account\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("123123!@Aa");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        WebElement dropdown = driver.findElement(By.cssSelector("button[class=\"btn btn-sm fw-bold btn-primary\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).pause(Duration.ofSeconds(1)).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement langItem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(@class,'menu-title') and contains(normalize-space(.),'Tiếng Anh (Mỹ)')]")));
        langItem.click();

        driver.findElement(By.xpath("//span[contains(text(), 'Quản lý phim')]")).click();

        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();

        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
        driver.findElement(By.cssSelector("a.next")).click();
//        driver.findElement(By.cssSelector("a.next")).click();
//        driver.findElement(By.cssSelector("a.next")).click();
//        driver.findElement(By.cssSelector("a.next")).click();
//        driver.findElement(By.cssSelector("a.next")).click();
//        driver.findElement(By.cssSelector("a.next")).click();
//        driver.findElement(By.cssSelector("a.next")).click();


        System.out.println("15");
        List<WebElement> Elements = driver.findElements(By.cssSelector("div[class=\"custom-movie-info\"] h3"));
        for (WebElement el : Elements) {
            System.out.println(el.getText());
        }



    }

    @Test
    public void TC_02() {



    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}
