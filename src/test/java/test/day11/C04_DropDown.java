package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {
    WebDriver driver;
    //todo
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin  ve yazdırın
    // Tüm dropdown değerleri(value) yazdırın
    // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
    // True , degilse False yazdırın.


    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void dropDowntest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));

        Select select = new Select(dropdown);
        select.selectByIndex(1);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        select.selectByValue("2");
        System.out.println("select.getSecondSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println("Option 1 = " + select.getFirstSelectedOption().getText());

        List<WebElement> optionList = select.getOptions();
        for (WebElement eachoption : optionList) {
            System.out.println("each: " + eachoption.getText());
        }
        int actualDrp =optionList.size();
        int expectedDrpTotal=4;
        Assert.assertEquals(expectedDrpTotal,actualDrp,"option sayisi beklentileri karşılamadı");


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }




}
