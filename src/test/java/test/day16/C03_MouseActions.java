package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_MouseActions extends TestBase {
    //todo
    // https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void goPage(){
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMe= driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropHere= driver.findElement(By.xpath("(//div[@id=\"droppable\"])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();

        String droppedText = driver.findElement(By.xpath("//p[text()=\"Dropped!\"]")).getText();
        String firstText = dropHere.getText();

        Assert.assertEquals(droppedText,firstText);







    }


}
