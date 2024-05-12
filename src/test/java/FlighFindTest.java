import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlighFindTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
    }

    @Test
    public void verifyLangPage(){
        WebElement flightFinderSection = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));
        Assert.assertTrue(flightFinderSection.isDisplayed());

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
