package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void beforeClass(){
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("geo.enabled", false);
        option.addPreference("geo.provider.use_corelocation", false);
        driver = new FirefoxDriver(option);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://egov.danang.gov.vn/reg");

        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_tinhthanh")));

        select.selectByVisibleText("thành phố Hồ Chí Minh");
        Thread.sleep(3000);

        //Lấy ra option vừa chọn và verify
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "thành phố Hồ Chí Minh");

        //Kiểm tra 1 dropdown là single hay multiple
        Assert.assertFalse(select.isMultiple());

        //Lấy ra tất cả các item bên trong dropdown
        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_quanhuyen")));

        List<WebElement> districtElement = select.getOptions();
        List<String> districtText = new ArrayList<String>();

        for (WebElement district : districtElement){
            districtText.add(district.getText());
        }

        Assert.assertTrue(districtText.contains("quận 1"));
        Assert.assertTrue(districtText.contains("quận 12"));
        Assert.assertTrue(districtText.contains("quận Thủ Đức"));
        Assert.assertTrue(districtText.contains("quận Gò Vấp"));


    }

    @Test
    public void TC_02_Rode() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");

        new Select(driver.findElement(By.cssSelector("select#country")))
                .selectByVisibleText("Vietnam");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[id=map_search_query]")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
        Thread.sleep(3000);

        List<WebElement> dealerBranches = driver.findElements(By.cssSelector("div.dealer_branch h4"));
        Assert.assertEquals(dealerBranches.size(), 16);

        //For-Each
        for (WebElement dealerName : dealerBranches){
            System.out.println((dealerName.getText()));
        }

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
