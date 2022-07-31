package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {
    WebDriver driver;
    //todo
    // 3 test methodu olusturun
    // 1. amazon ana sayfasina
    // 2. https://github.com/ ana sayfaya
    // 3. facebook ana sayfaya gitsin
    // ve sayfa title'larini yazdirsin

    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test (priority = 4)
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test (priority = 3)
    public void github(){
        driver.get("https://www.github.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test (priority = 2)
    public void facebook(){
        driver.get("https://www.facebook.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    @Test (priority = 1)
    public void yahoo(){
        driver.get("https://www.yahoo.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }








}
