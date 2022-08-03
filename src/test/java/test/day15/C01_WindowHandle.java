package test.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    //todo
    //    amazon.com a git
    //    Sayfana handell değerini al
    //    Yeni bir pencere aç
    //    bestbuy.com git
    //    yeni açılan pencerenin handel değerini al
    //    sonra bütün handelların değerini al
    //    şimdi yeni bir tab aç
//        facebook.com a git
    //    amazon.com a geri dön
    //    arama kısmına  Nutella yaz ve ara
//        sonra bestbuy.com geç, title  doğrula
    //    Şimdi de facebook.com penceresine git
//        title  facebook.com olduğunu  doğrula

    WebDriver driver;

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() {
        // amazon.com a git
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        String bestHandle = driver.getWindowHandle();
        System.out.println("bestHandle = " + bestHandle);

        Set<String> handless = driver.getWindowHandles();
        System.out.println("handless = " + handless);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        driver.switchTo().window(bestHandle);
        String bestTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bestTitle.contains("bestbuy.com"), "bestbuy.com içermiyor.");

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles.toString());

        String facebookHandle = "";


        for (String each : allHandles) {
            if (!each.equals(amazonHandle) || each.equals(bestHandle)) {
                facebookHandle = each;
            }

        }

        System.out.println("facebookHandle = " + facebookHandle);

        driver.switchTo().window(facebookHandle);
        String expURL = "https://www.facebook.com";
        String actURL = driver.getCurrentUrl();
        softAssert.assertEquals(actURL,expURL,"site doesnt exit my brotha.");

        softAssert.assertAll();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }


}
