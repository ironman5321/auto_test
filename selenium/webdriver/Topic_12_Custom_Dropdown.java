package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Topic_12_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        //Tìm Dr.
        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");



    }

    private void selectItemInDropdown(String parentLocator, String childLocattor, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);
        //Hàm Wait Chờ cho tất cả các item được load ra
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childLocattor)));

        List<WebElement> allItem = driver.findElements(By.cssSelector(childLocattor));
        for (WebElement item : allItem){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

    @Test
    public void TC_02() {



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
