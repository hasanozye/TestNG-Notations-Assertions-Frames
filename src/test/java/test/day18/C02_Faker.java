package test.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Collections;
import java.util.Set;

public class C02_Faker extends TestBase {
    //todo
    //   //"https://facebook.com/"  Adresine gidin
    //    //“create new account”  butonuna basin
    //    //“firstName” giris kutusuna bir isim yazin
    //    //“surname” giris kutusuna bir soyisim yazin
    //    //“email” giris kutusuna bir email yazin
    //    //“email” onay kutusuna emaili tekrar yazin
    //    //Bir sifre girin
    //    //Tarih icin gun secin
    //    //Tarih icin ay secin
    //    //Tarih icin yil secin
    //    //Cinsiyeti secin
    //    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //    //Sayfayi kapatin

    @Test
    public void test(){

        //"https://facebook.com/"  Adresine gidin
        driver.get("https://facebook.com/");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        WebElement day = driver.findElement(By.id("day"));
        Select daySelect = new Select(day);

        WebElement month = driver.findElement(By.id("month"));
        Select monthSelect = new Select(month);

        WebElement year = driver.findElement(By.id("year"));
        Select yearSelect= new Select(year);

        String  email = faker.internet().emailAddress();

        WebElement name =driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));

        //“firstName” giris kutusuna bir isim yazin
      actions.click(name).sendKeys(faker.name().firstName()).

              //“surname” giris kutusuna bir soyisim yazin
              sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).

              //“email” giris kutusuna bir email yazin
              sendKeys(Keys.TAB).sendKeys(email).
              sendKeys(Keys.TAB).sendKeys(email).

              //Bir sifre girin
              sendKeys(Keys.TAB).sendKeys(faker.internet().password()).perform();



      //Tarih icin gun secin
      daySelect.selectByVisibleText("10");

      //Tarih icin ay secin
      monthSelect.selectByVisibleText("Nis");

      //Tarih icin yil secin
      yearSelect.selectByVisibleText("2000");

      //Cinsiyeti secin
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).perform();

        WebElement erkek = driver.findElement(By.xpath("//label[text()=\"Erkek\"]"));
        Assert.assertTrue(erkek.isEnabled(),"ERKEK IS NOT SELECTED BITCHASS");

        WebElement diger =driver.findElement(By.xpath("//label[text()=\"Özel\"]"));
        Assert.assertFalse(diger.isSelected(),"CUSTOM SECILI BRO HATTTHEGFUCCKK");





    }

    @Test
    public void faker(){
        Faker faker = new Faker();
        System.out.println("faker.relationships().spouse() = " + faker.relationships().spouse());
        Set<String> str= Collections.singleton(faker.witcher().quote());
        System.out.println("str = " + str);


        for (String each : str ){
            System.out.println("each = " + each);
        }

    }



}
