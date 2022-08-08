package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    //todo//amazona gidin
    //  //3 farkli test methodu ile java, honey ve elma aratip
    //    //sonuc sayfasini screenshot'i kaydedin

    @Test
    public void java() throws IOException {
        driver.get("https://www.amazon.com");

        WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("Java"+ Keys.ENTER);
        screenShot();



    }

    @Test
    public void honeyTest() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("honey"+ Keys.ENTER);
        screenShot();



    }

    @Test
    public void elmaTest() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("elma"+ Keys.ENTER);
        screenShot();


    }


}
