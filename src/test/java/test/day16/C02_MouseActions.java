package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {
    //todo
    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //  Cizili alan uzerinde sag click yapalim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim.
    // Tamam diyerek alert’I kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void mouseActions() throws InterruptedException {

        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement kare = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));

        //  Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        actions.contextClick(kare).perform();
        Thread.sleep(3000);


        // Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim.

        String text = driver.switchTo().alert().getText();
        String expectedText= "You selected a context menu";
        Assert.assertEquals(text,expectedText);

        // Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        String page1=driver.getWindowHandle();

        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> pageHandles=driver.getWindowHandles();
        String page2="";

        for (String each :pageHandles) {
            if (!each.equals(page1)){
                page2 = each;
            }
        }

        driver.switchTo().window(page2);
        String expectedElement="Elemental Selenium";
        String actualElement=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualElement,expectedElement,"Elemental Selenium Yoktur.");








    }
}
