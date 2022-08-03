package test.day13;
//todo
// Yeni bir Class Olusturun : C03_SoftAssert
// 1. http://zero.webappsecurity.com/ Adresine gidin
// 2. Sign in butonuna basin
// 3. Login kutusuna “username” yazin
// 4. Password kutusuna “password” yazin
// 5. Sign in tusuna basin
// 6. Only Banking Pay Bills sayfasina gidin
// 7. “Purchase Foreign Currency” tusuna basin
// 8. “Currency” drop down menusunden Eurozone’u secin
// 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
// //! 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin .

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C03_SoftAssert {
    WebDriver driver;

    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//button[@id =\"signin_button\"]")).click();

        WebElement userName =driver.findElement(By.xpath("//input[@id=\"user_login\"]"));
        userName.sendKeys("username");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"user_password\"]"));
        password.sendKeys("password",Keys.ENTER);

        driver.navigate().back();

        driver.findElement(By.xpath("//strong[text() =\"Online Banking\"]")).click();
        driver.findElement(By.xpath("//span[@id=\"pay_bills_link\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Purchase Foreign Currency\"]")).click();
        WebElement currency = driver.findElement(By.xpath("//select[@id=\"pc_currency\"]"));

        Select select = new Select(currency);
        select.selectByVisibleText("Eurozone (euro)");
        SoftAssert dropDown = new SoftAssert();
        String euro = "Eurozone (Euro)";
        String actual = select.getFirstSelectedOption().getText();
        dropDown.assertEquals(actual,euro,"no what omegalul?");


        String actualSwitzerland=select.getFirstSelectedOption().getText();
        String expectedSw="Switzerland";
        dropDown.assertEquals(actualSwitzerland,expectedSw,"NO MAAAN ITS NOT EQQUAAL FUUUCK.");

        String  actual1Switzerland="";
        String  expectedSwitzerland="Switzerland";
        String  expectedSwitzerland2="Switzerland";

        List<WebElement> drdList=select.getOptions();

        for (WebElement each:drdList) {
            actualSwitzerland+=each.getText()+",";
        }
        System.out.println("actualSwitzerland = " + actualSwitzerland);
//! actualSwitzerland = Select One,Australia (dollar),Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht),
        dropDown.assertTrue(actualSwitzerland.contains(expectedSwitzerland),"Switzerland para birimini bulamadım.");
        dropDown.assertFalse(actualSwitzerland.contains(expectedSwitzerland2),"\"Switzerland para birimini var\"");

        dropDown.assertAll();








    }
}
