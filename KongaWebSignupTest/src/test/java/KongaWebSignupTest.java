import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class KongaWebSignupTest {

    //import the selenuim WebDriver
    private WebDriver driver;

    @Test
    public void start() throws InterruptedException {
        //locate where the chromedriver is and double-click to open
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Open on the chrome browser
        driver = new ChromeDriver();
        //2.Input the Konga Url in the chromebrowser and press enter
        driver.get("https://www.konga.com");
        Thread.sleep(5000);
        //3. Maximise the page
        driver.manage().window().maximize();
        //4. Locate and click on the Login tab
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        //5. Input Email Address or Phone Number
        driver.findElement(By.id("Email Address or Phone Number")).sendKeys("banjoko@robot-mail.com");
        //5. Input Password
        driver.findElement(By.id("Password")).sendKeys("Password12@");
        //6. Click on Login button
        driver.findElement(By.id("Login")).click();
        Thread.sleep(10000);
        //7. Logout form the Account
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a/svg")).click();

    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();

    }

}