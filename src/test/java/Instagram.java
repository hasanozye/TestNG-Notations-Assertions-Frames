import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.Scanner;

public class Instagram {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void InstaLogin(){

        driver.get("https://www.instagram.com");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("hasan.ozye", Keys.ENTER);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("XF659*zmz", Keys.ENTER);

    }




}
