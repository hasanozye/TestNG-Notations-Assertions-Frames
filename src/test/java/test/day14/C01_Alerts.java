package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C01_Alerts {
    SoftAssert assertion1;
    //todo
    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    // ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    // ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
        driver.switchTo().alert().accept();

        String result1 =driver.findElement(By.xpath("//p[text()=\"You successfully clicked an alert\"]")).getText();
        assertion1 = new SoftAssert();
        assertion1.assertEquals(result1,"You successfully clicked an alert","first alert is not right.");
    }

    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
        driver.switchTo().alert().dismiss();
        String  result2 = driver.findElement(By.xpath("//p[text()=\"You clicked: Cancel\"]")).getText();
        assertion1 = new SoftAssert();
        assertion1.assertTrue(result2.contains("successfuly"),"BROTHER YOUR METHOD2 AINT OWRKIN RIGHT MY G");

    }
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Hasan bABA");
        driver.switchTo().alert().accept();
        String assert3= driver.findElement(By.xpath("//p[text()=\"You entered: Hasan BABA\"]")).getText();
        assertion1= new SoftAssert();
        assertion1.assertTrue(assert3.contains("Hasan BABA"),"method 3 aint right my g");


    }

    @AfterClass
    public void tearDown(){
        assertion1.assertAll();
        driver.close();

    }


}
