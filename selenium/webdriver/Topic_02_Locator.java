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
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_ID() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.id("search")).sendKeys("Samsung");
        driver.findElement(By.id("firstname")).sendKeys("Bui Thu");
    }

    @Test
    public void TC_02_Class() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.className("page-header-container"));
        driver.findElement(By.className("skip-links"));


    }

    @Test
    public void TC_03_Name() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.name("firstname"));
        driver.findElement(By.name("lastname"));
        driver.findElement(By.name("email"));

    }

    @Test
    public void TC_04_Link() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

    //Chỉ dùng được với đường link có text (text trên UI, không phải text trên HTML)
    //Truyền hết chuỗi text vào
        driver.findElement(By.linkText("ABOUT US"));
        driver.findElement(By.linkText("CUSTOMER SERVICE"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));
    }

    @Test
    public void TC_05_Partial_Link() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        //Chỉ dùng được với đường link có text (text trên UI, không phải text trên HTML)
        //Truyền hết chuỗi text vào cũng chạy được
        //Truyền 1 phần cũng chạy đươợc

        driver.findElement(By.partialLinkText("ABOUT"));
        driver.findElement(By.partialLinkText("CUSTOMER SERVICE"));
        driver.findElement(By.partialLinkText("ORDERS AND"));
    }

    @Test
    public void TC_06_Tag_Name() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        //Tìm nhiều element giống nhau
        int linkNumber = driver.findElements(By.tagName("a")).size();
        System.out.println("Tổng số lượng link: " + linkNumber);

    }

    @Test
    public void TC_07_Css() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        //Css với id
        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("#search"));
        driver.findElement(By.cssSelector("input#search"));

        //Css với Class
        driver.findElement(By.cssSelector("div[class='skip-links']"));
        driver.findElement(By.cssSelector(".skip-links"));
        driver.findElement(By.cssSelector("div.skip-links"));

        //Ngoại lệ với các Class nhiều tên
        driver.findElement(By.cssSelector("input.input-text.validate-email.required-entry"));

        //Class với Name
        driver.findElement(By.cssSelector("input[name='lastname']"));


        //Class với link
        //Css không dừng được với link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer-service/']"));


        //Class với partial link
        driver.findElement(By.cssSelector("a[href^='http://live.techpanda.or']"));
        driver.findElement(By.cssSelector("a[href*='panda.org/index.php/customer']"));
        driver.findElement(By.cssSelector("a[href$='ndex.php/customer-service/']"));

        //Css với tagname
        int linkNumber = driver.findElements(By.cssSelector("a")).size();
        System.out.println("Tổng số lượng link: " + linkNumber);


    }

    @Test
    public void TC_08_XPath() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        //XPath với ID
        driver.findElement(By.xpath("//input[@id='search']"));

        //XPath với Class
        driver.findElement(By.xpath("//div[@class='skip-links']"));

        //XPath với Name
        driver.findElement(By.xpath("//input[@name='lastname']"));

        //XPath với Link
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer-service/']"));
        driver.findElement(By.xpath("//a[text()='About Us']"));

        //XPath với partail link
        driver.findElement(By.xpath("//a[starts-with(@href,'http://live.techpanda.or')]"));
        driver.findElement(By.xpath("//a[contains(@href,'panda.org/index.php/customer')]"));
        //xpath không hỗ trợ ends-with
        //driver.findElement(By.xpath("//a[ends-with(@href,'index.php/customer-service/')]"));

        //XPath với ID tagName
        int linkNumber = driver.findElements(By.xpath("//a")).size();
        System.out.println("Tổng số lượng link: " + linkNumber);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
