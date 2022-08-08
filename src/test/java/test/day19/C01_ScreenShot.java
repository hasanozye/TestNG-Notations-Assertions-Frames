package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {
    //todo
    // amazon anasayfaya gidin
    // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
    // Nutella icin arama yapin
    // sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin

    @Test
    public void testScreen() throws IOException {

        // amazon anasayfaya gidin
        driver.get("https://www.n11.com");


        TakesScreenshot screenshot = (TakesScreenshot) driver;



        File dosya = new File("TScreen/allPage.png");

        File geciciDosya =screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,dosya);


    }

}
