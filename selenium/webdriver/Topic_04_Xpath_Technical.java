package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_04_Xpath_Technical {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");

        // text() = tuyệt đối -> lấy chính xác từng ký tự -> nằm trong node, mọi index
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']"));

        //contains[text(),''] -> lấy tương đối đoạn ký tự chứa trong element -> text nằm trong node chứa nó hoặc ở index đầu tiên
        driver.findElement(By.xpath("//h5[contains(text(),'Hello ')]"));

        //contains[.,''] -> Tổng 2 trường hợp trên
        driver.findElement(By.xpath("//h5[contains(.,'Michael Jackson')]"));

        //contains[string(),'']
        driver.findElement(By.xpath("//h5[contains(string(),'Michael Jackson')]"));

        //concat() -> Nôối chuỗi -> Nháy đơn bọc nháy đôi, nháy đôi bọc nháy đơn
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", ', \"What's happened?\")]"));

        // and, or
        driver.findElement(By.xpath("//input[@id='disable_password' and @type='password']"));
        driver.findElement(By.xpath("//input[@id='mail' or @name='user_email']"));

        //not-> áp dụng cho 2 element
        //driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));

    }

    @Test
    public void TC_02() {
        driver.get("https://live.techpanda.org/index.php/mobile.html");

        //outside parent
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]"));

    }

    @Test
    public void TC_03() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        //inside parent
        driver.findElement(By.xpath("//li[@class='ui-state-default ui-selectee'][20]"));
        driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));

        //position() -> giống index
        driver.findElement(By.xpath("//li[@class='ui-state-default ui-selectee'][position()=20]"));
        driver.findElement(By.xpath("//ol[@id='selectable']/li[position()=5]"));

        //last() -> lấy index cuối
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));

        //last()-1 -> lấy index gần cuối
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()-1]"));

        //count()
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)]"));
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)-3]"));

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
