import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

    @Test
    public void searchFligh(){

        WebElement flightOptionOneWayRB = driver.findElement(By.xpath("//input[@value='oneway']"));
        flightOptionOneWayRB.click();

        Select passengers = new Select(driver.findElement(By.name("passCount")));
        passengers.selectByValue("2");

        Select departingFrom = new Select(driver.findElement(By.name("fromPort")));
        departingFrom.selectByValue("Frankfurt");

        Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
        fromMonth.selectByIndex(8);

        Select fromDay = new Select(driver.findElement(By.name("fromDay")));
        fromDay.selectByIndex(10);

        Select arrivingIn = new Select(driver.findElement(By.name("toPort")));
        arrivingIn.selectByValue("Paris");

        Select toMonth = new Select(driver.findElement(By.name("toMonth")));
        toMonth.selectByIndex(9);

        Select toDay = new Select(driver.findElement(By.name("toDay")));
        toDay.selectByIndex(10);

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='Business']"));
        serviceClass.click();

        Select airline = new Select(driver.findElement(By.name("airline")));
        airline.selectByVisibleText("Blue Skies Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();


    }

   @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
