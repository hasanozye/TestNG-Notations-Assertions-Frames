package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;

public class C02_BasicAuthentication {
    WebDriver driver;
    //todo
    // 1- Bir class olusturun : BasicAuthentication
    // 2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //    Html komutu : https://url/
    //    Username     : admin
    //    password      : admin
    // 4- Basarili sekilde sayfaya girildigini dogrulayin

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.get("https://the-internet.herokuapp.com/basic_auth");


    }


    @Test
    public void test() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokupapp.com/basic_auth");
        driver.findElement(By.xpath("//button[@id=\"details-button\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id=\"proceed-link\"]")).click();

    }


}
