package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

//todo
//   Yeni bir class olusturalim: MouseActions1
//    https://www.amazon.com/ adresine gidelim
//    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
//    mouse’u bu menunun ustune getirelim
//    “Create a list” butonuna basalim
//    Acilan sayfada “Your Lists” yazisi oldugunu test edelim

//todo
//doubleClick (): Öğeye çift tıklama yapar
//clickAndHold (): Fareyi serbest bırakmadan uzun tıklama yapar
//dragAndDrop (): Öğeyi bir noktadan diğerine sürükler ve bırakır
//moveToElement (): Fare işaretçisini öğenin üzerine gider
//contextClick (): Fare üzerinde sağ tıklama yapar

public class C01_MouseActions extends TestBase {

    @Test
    public void amazonList() throws InterruptedException {
        //* https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);

        //    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement list = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(list).perform();
        Thread.sleep(3000);

        //    “Create a list” butonuna basalim
        WebElement createElement = driver.findElement(By.linkText("Create a List"));
        Thread.sleep(3000);
        actions.click(createElement).perform();


        //    Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        String yourList = driver.findElement(By.xpath("//div[@role=\"heading\"]")).getText();
        Assert.assertTrue(yourList.contains("Your Lists"), "expected result is not matched with real result.");

    }

    @Test
    public void actions() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html#");

        Actions actions = new Actions(driver);
        WebElement dont = driver.findElement(By.xpath("//div[@id=\"click-box\"]"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String text = dont.getText();
        actions.clickAndHold(dont).perform();

        text =dont.getText();
        System.out.println("text = " + text);

        Thread.sleep(3000);
        actions.release(dont).perform();

        text =dont.getText();
        System.out.println("text = " + text);


    }


}
