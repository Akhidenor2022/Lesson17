import org.eclipse.sisu.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class KongaWebSignupTest {

    //import the selenuim WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is and double-click to open
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Open on the chrome browser
        driver = new ChromeDriver();
        //2.Input the Konga Url in the chromebrowser and press enter
        driver.get("https://www.konga.com");
        Thread.sleep(5000);
        //Test1. Verify that existing customer user is redirected to the landing page
        if(driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("correct Landing page");
        else
            //Fail
        System.out.println("wrong landing page");

    }

      @Test
      public void PostiveTest () throws InterruptedException {
        //3. Maximise the page
        driver.manage().window().maximize();
        //4. Click on the Login/Signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //5. Enter Email Address or phone Number field
          //Test2. Verify that existing customer can login with valid email address and password details
         driver.findElement(By.id("username")).sendKeys("banjoko@robot-mail.com");
        //6. Input Password
        driver.findElement(By.id("password")).sendKeys("Password12@");
        //7. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        //8. Locate My Account and click
          driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
          //9. Logout form the Account
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();

    }

}