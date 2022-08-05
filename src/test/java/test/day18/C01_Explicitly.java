package test.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;

public class C01_Explicitly extends TestBase {
    //todo
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //   Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It’s back mesajinin gorundugunu test edin
    //! TestBase imlicitliwait comment yapalımmm

    @Test
    public void implicitWait() throws InterruptedException {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(itsGone.isDisplayed(),"it didnt displayed, check timer.");

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement itsBack =driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));

        // 7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(itsBack.isDisplayed(),"itsback msg didn't displayed. Check timer.");

    }


    @Test
    public void explicitWait() throws InterruptedException {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        // 4. Remove butonuna basin.
        WebElement remove =driver.findElement(By.xpath("(//button[@type=\"button\"])[1]"));
        remove.click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement itsGone = driver.findElement(By.id("message"));


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(itsGone.isDisplayed(),"it didnt displayed, check timer.");

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();

        //WebElement itsBack =driver.findElement(By.id("message"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack =driver.findElement(By.id("message"));
        Assert.assertTrue(itsBack.isDisplayed(),"itsback msg didn't displayed. Check timer.");

    }
}
