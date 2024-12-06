package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
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
        driver.get("https://live.techpanda.org/"); //*

        //Đóng Browser - Không quan tâm có bao nhiêu tab, window
        driver.quit();  //*

        //Đóng Browser - Chỉ đóng tab hiện tại
        driver.close();

        //Tìm 1 element với tham số truyền vào l locator
        driver.findElement(By.cssSelector(""));  //*

        //Tìm nhiều element với tham số truyền vào l locator
        driver.findElements(By.cssSelector(""));  //*

        //Cách 1 - Sử dụng luôn không lưu trữ
        Assert.assertEquals(driver.getCurrentUrl(), "https://web.skype.com/?openPstnPage=true");

        //Cách 2 - Lấy ra url của page hiện tại
        String homePage = driver.getCurrentUrl();
        //Sử dụng
        driver.get(homePage);
        Assert.assertEquals(homePage, "https://web.skype.com/?openPstnPage=true");

        //Lấy ra title ở page hiện tại
        driver.getTitle();

        //Lấy ra window ID ở page hiện tại
        driver.getWindowHandle();

        //Lấy ra tất cả window ID của các tab/ window
        driver.getWindowHandles();

        //Lấy ra source code của page hiện tại
        driver.getPageSource();

        //Alert
        driver.switchTo().alert();  //*
        //SwichTo vào frame/iframe
        driver.switchTo().frame("");  //*
        driver.switchTo().defaultContent(); //SwichTo lại trang cha
        driver.switchTo().parentFrame(); //SwichTo từ frame con ra frame cha(nhiều frame lồng nhau)

        //Window - Tab
        driver.switchTo().window("");  //*
        driver.switchTo().newWindow(WindowType.TAB).get("https://web.skype.com/?openPstnPage=true");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://web.skype.com/?openPstnPage=true");

        //Set timeout để tìm element(áp dụng cho 2 hàm findElement/ findElements)
        //Trường hợp không tìm thấy -> chờ hết tgian mới báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  //*
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(30));

        //Set timeout để chờ page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //Set timeout để chờ ddoanjj code js được thực thi thành công
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //Browser: full screen/ maximize/ minimize
        driver.manage().window().maximize();  //*
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();

        //Set browser có kích thước bao nhiêu (Responsive)
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().getSize();

        //Set browser ở vị trí nào
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();

        //Selenium Log: Browser/ Driver/ Network
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().logs().get(LogType.CLIENT);
        driver.manage().logs().get(LogType.SERVER);

        driver.manage().logs().getAvailableLogTypes();

        //Quay lại tảng trước đó
        driver.navigate().back();
        //Chuyển tiếp đến trang trước đó
        driver.navigate().forward();
        //Refesh lại trang
        driver.navigate().refresh();


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
