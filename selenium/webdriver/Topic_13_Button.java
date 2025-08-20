package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_13_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {
        driver.get("https://www.fahasa.com/customer/account/create");
        By registerButton = By.cssSelector("button.fhs-btn-register");

        //clickable
        //Chờ cho 1 ele không được click trong 10s
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(registerButton)));


        //Text hiển thị đúng
        Assert.assertEquals(driver.findElement(By.cssSelector("button.fhs-btn-register span")).getText().trim(), "Đăng ký");


        //Background color
        String backgroundRegister = driver.findElement(registerButton).getCssValue("background-color");
        Assert.assertEquals(backgroundRegister, "rgba(0, 0, 0, 0)");
        Assert.assertEquals(Color.fromString(backgroundRegister).asHex().toUpperCase(), "#000000");



        //Disable/ Enable
        //Khi mong đợi ele là enable -> assertTrue
        //Khi mong đợi ele là disable -> assertFalse
        Assert.assertFalse(driver.findElement(registerButton).isEnabled());


    }

    @Test
    public void TC_02_Login_button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton)
                .getCssValue("background-color"))
                .asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("blthu@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("1213123!@Aa");

        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton)
                        .getCssValue("background-color"))
                .asHex().toUpperCase(), "#C92127");




    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
