package test.day17;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //todo
    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    // 2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    // 3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    // - https://the-internet.herokuapp.com/download adresine gidelim.
    // - text.txt dosyasını indirelim
    // 4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test (dependsOnMethods = "downloadTest")
    public void isExist(){
        String dosyaTXT =System.getProperty("user.home")+"\\Downloads\\text-file.txt";
        System.out.println("dosyaTXT = " + dosyaTXT);
        Assert.assertTrue(Files.exists(Paths.get(dosyaTXT)));


    }

    @Test ()
    public void downloadTest(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()=\"text-file.txt\"]")).click();




    }

}
