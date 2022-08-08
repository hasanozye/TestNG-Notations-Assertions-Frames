package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class TestBase {
    protected WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        //Thread.sleep(4000);
        //driver.quit();
    }

    public void screenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String day = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File allPage = new File("TScreenshot/allpage" + day + ".png");
        File geciciSayfa = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciSayfa, allPage);


    }

}


