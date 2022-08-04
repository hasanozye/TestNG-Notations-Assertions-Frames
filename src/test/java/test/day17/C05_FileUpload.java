package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //todo
    // https://the-internet.herokuapp.com/upload adresine gidelim
    // chooseFile butonuna basalim
    // Yuklemek istediginiz dosyayi secelim.
    // Upload butonuna basalim.
    // “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void upload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileSec=driver.findElement(By.xpath("(//input[@type=\"file\"])[1]"));
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\Deneme1\\appium.xlsx";
        fileSec.sendKeys(dosyaYolu);
        Thread.sleep(3000);

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);

        WebElement sonuc =driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonuc.isDisplayed());



    }

}
