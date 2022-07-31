package test.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethods {
    //todo
    // 2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    // arama yapin ve aramanizin gerceklestigini Test edin
    // 3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
    WebDriver driver;


    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @Test
    public void logoTest(){
        driver.get("https://www.amazon.com");
        WebElement logo =driver.findElement(By.cssSelector("#nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed(),"Logo didnt displayed man wtf u doooin?");
    }
    @Test(dependsOnMethods = "logoTest")
    public void aramaTesti(){

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.click();
        searchBox.sendKeys("Nutella", Keys.ENTER);
        String actualTilte=driver.getTitle();
        String arananKelime="Nutella";
        Assert.assertTrue(actualTilte.contains(arananKelime),"Nutella bulunamadı");
    }

    @Test(dependsOnMethods = "aramaTesti")
    public void priceTest(){
        driver.findElement(By.xpath("(//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[1]")).click();
        WebElement price=driver.findElement(By.xpath("(//span[@class=\"a-size-mini olpWrapper\"])[2]"));
        String actualPrice =price.getText();
        String expectedPrice="14.99";
        Assert.assertTrue(actualPrice.contains(expectedPrice),"it is not 14.99 in fact.");



    }


}
