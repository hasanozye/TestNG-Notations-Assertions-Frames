package test.day18;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    //todo
    // Yeni bir class olusturun : cookiesAutomation
    // Amazon anasayfaya gidin
    // tum cookie’leri listeleyin
    // Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //  ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
    // olusturun ve sayfaya ekleyin
    // eklediginiz cookie’nin sayfaya eklendigini test edin
    // ismi skin olan cookie’yi silin ve silindigini test edin
    // tum cookie’leri silin ve silindigini test edin


    @Test
    // Yeni bir class olusturun : cookiesAutomation
    public void cookiesAutomation() {

        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        int count = 1;
        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie each : cookies) {
            System.out.println((count++) + ".cookie = " + each);

        }

        // Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size() > 5, "Cookiler 5 den buyuk degil. Sorry Fella.");

        Cookie cook = driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cook = " + cook);
        Assert.assertEquals(cook.getValue(), "USD");

        // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        Cookie myCook = new Cookie("en sevdigim cookie","visneli");
        driver.manage().addCookie(myCook);




    }


}
