package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        //Salutations
        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");
        //Speed
        selectItemInDropdown("span#speed-button ", "ul#speed-menu div", "Medium");
        //verify xem đúng giá trị đã chọn chưa
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(), "Medium");



    }

    @Test
    public void TC_02_React_Sematic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("div.dropdown", "div.item span.text", "Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector(".divider")).getText(), "Matt");


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



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
