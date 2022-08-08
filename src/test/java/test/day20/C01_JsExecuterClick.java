package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_JsExecuterClick extends TestBase {
    //TODO
    // amazon anasayfaya gidip
    // sell linkine JSExecuter ile tiklayin
    // ilgil sayfaya gittigimizi test edelim

    @Test
    public void jsExec() {

        // amazon anasayfaya gidip
        driver.get("https://www.amazon.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        // sell linkine JSExecuter ile tiklayin
        WebElement sell = driver.findElement(By.xpath("//a[text()=\"Sell\"]"));
        jse.executeScript("arguments[0].click();", sell);


    }


}
