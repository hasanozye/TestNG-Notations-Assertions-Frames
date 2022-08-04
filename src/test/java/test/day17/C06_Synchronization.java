package test.day17;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Synchronization extends TestBase {
    //todo
    // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
    // disable butonuna basin
    // disabled yazisinin ciktigini test edin

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
        Thread.sleep(5000);
    }

}
