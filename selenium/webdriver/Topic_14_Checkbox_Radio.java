package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Topic_14_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_checkbox() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        WebElement duaZoneCheckbox = driver.findElement(By.xpath("//label[text()=\"Dual-zone air conditioning\"]/preceding-sibling::span/input"));

        //scroll màn hình
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", duaZoneCheckbox);
        //Thread.sleep(2000);

        //click chọn và verify chọn thành công
        duaZoneCheckbox.click();
        Thread.sleep(2000);
        Assert.assertTrue(duaZoneCheckbox.isSelected());

        //hàm kiểm tra xem đã chọn chưa
        if(!duaZoneCheckbox.isSelected()){
            duaZoneCheckbox.click();
            Thread.sleep(2000);
        }


        //bỏ chọn và verify bỏ chọn
        duaZoneCheckbox.click();
        Thread.sleep(2000);
        Assert.assertFalse(duaZoneCheckbox.isSelected());


    }

    @Test
    public void TC_02_radio() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        WebElement petrol_147 = driver.findElement(By.xpath("//label[text()=\"2.0 Petrol, 147kW\"]/preceding-sibling::span/input"));
        petrol_147.click();
        Thread.sleep(2000);

        if(!petrol_147.isSelected()){
            petrol_147.click();
            Thread.sleep(2000);
        }

        Assert.assertTrue(petrol_147.isSelected());

    }

    @Test
    public void TC_03_select_all(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-input-wide input[type = \"checkbox\"]"));

        //select all item checkbox
        for(WebElement checkbox:allCheckboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

        //verify
        for (WebElement checkbox:allCheckboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        //deselect
        for(WebElement checkbox:allCheckboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }

        //verify
        for (WebElement checkbox:allCheckboxes){
            Assert.assertFalse(checkbox.isSelected());
        }

        //chọn 1 item
        for (WebElement checkbox:allCheckboxes){
            if(checkbox.getDomAttribute("value").equals("Epilepsy Seizures")){
                checkbox.click();
            }
        }


    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
