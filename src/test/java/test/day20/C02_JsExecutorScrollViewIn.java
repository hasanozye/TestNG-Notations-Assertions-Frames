package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C02_JsExecutorScrollViewIn extends TestBase {
    //todo
    // 1- Yeni bir class olusturun : ScroolInto
    // 2- /movita.com gidin
    // 3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki
    // 4- istediginiz çözüm sayfasi acildigini test edin

    @Test
    public void actions() throws InterruptedException {
        driver.get("https://www.movita.com.tr");

        WebElement click = driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));
        Actions actions =new Actions(driver);
        actions.scrollToElement(click);
        click.click();
    }

    @Test
    public void jsExecutor() throws InterruptedException {
        driver.get("https://www.movita.com.tr");
        WebElement clickButton = driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", clickButton);
        Thread.sleep(3000);

        jse.executeScript("arguments[0].click()",clickButton);

        List<WebElement> cozumtexts = driver.findElements(By.tagName("h3"));
        System.out.println("cozumtexts.size() = " + cozumtexts.size());

        for (WebElement each: cozumtexts){
            System.out.println("each.getText() = " + each.getText());
        }

        Assert.assertTrue(cozumtexts.size()==4,"this is wrong");


    }









}
