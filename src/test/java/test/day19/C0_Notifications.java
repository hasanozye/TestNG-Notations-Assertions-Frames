package test.day19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C0_Notifications extends TestBase {


    @Test
    public void notification() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifcations");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com");
    }


}
