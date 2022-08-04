package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    //todo
    // Yeni Class olusturun ActionsClassHomeWork
    //    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //    //2- Hover over Me First" kutusunun ustune gelin
    //    //3- Link 1" e tiklayin
    //    //4- Popup mesajini yazdirin
    //    //5- Popup'i tamam diyerek kapatin
    //    //6- “Click and hold" kutusuna basili tutun
    //    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //    //8- “Double click me" butonunu cift tiklayin



    @Test
    // Yeni Class olusturun ActionsClassHomeWork
    public void ActionsClassHomework () throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        WebElement hOmF = driver.findElement(By.xpath("//button[text()=\"Hover Over Me First!\"]"));
        WebElement link1= driver.findElement(By.xpath("(//a[text()=\"Link 1\"])[1]"));

        //2- Hover over Me First" kutusunun ustune gelin
        actions.moveToElement(hOmF).perform();

        //3- Link 1" e tiklayin
        actions.click(link1).perform();

        //4- Popup mesajini yazdirin
        String textAlert =driver.switchTo().alert().getText();
        System.out.println("textAlert = " + textAlert);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();


        WebElement clickAHOLD= driver.findElement(By.xpath("//p[text()=\"Click and Hold!\"]"));

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHoldText = clickAHOLD.getText();
        System.out.println("clickAHOLD = " + clickAndHoldText);

        //6- “Click and hold" kutusuna basili tutun
        actions.clickAndHold(clickAHOLD).perform();
        Thread.sleep(3000);
        actions.release().perform();

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe= driver.findElement(By.xpath("//h2[text()=\"Double Click Me!\"]"));
        actions.doubleClick(doubleClickMe).perform();

    }

}
