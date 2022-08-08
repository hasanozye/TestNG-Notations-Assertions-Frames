package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C03_Webtables extends TestBase {
    //todo
    //  /*     table() metodu oluşturun
    // ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
    // ○ Table’daki başlıkları(headers) konsolda yazdırın.
    // ● printRows() metodu oluşturun //tr
    // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
    // ● printCells() metodu oluşturun //td
    // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    // ● printColumns() metodu oluşturun
    // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    // ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    // ○ 5.column daki elementleri konsolda yazdırın.*/


    // table() metodu oluşturun
    @Test
    public void table() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(2000);

        // ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
        List <WebElement> tbody = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("tbody.size() = " + tbody.size());

        // ○ Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement> baslik=driver.findElements(By.xpath("//thead//th"));
        for (WebElement each: baslik){
            System.out.println("each.getText() = " + each.getText());

        }
    }

    // ● printRows() metodu oluşturun //tr
    @Test
    public void printsRow() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(2000);

        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> table = driver.findElements(By.xpath("//table//tr"));
        System.out.println("table.size() = " + table.size());


        for (WebElement tablerow : table){
            System.out.println("tablerow.getText() = " + tablerow.getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement row4=driver.findElement(By.xpath("//table//tr[4]"));
        System.out.println("row4.getText() = " + row4.getText());

    }

    // ● printCells() metodu oluşturun //td
    @Test
    public void printCells() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(2000);

        // ○ table’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> cells = driver.findElements(By.xpath("//table//td"));
        System.out.println("cells.size() = " + cells.size());

        // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (WebElement cellCounter : cells){
            System.out.println("cellCounter.getText() = " + cellCounter.getText());
        }


    }

    // ● printColumns() metodu oluşturun
    @Test
    public void printColums() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(2000);

        // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> column = driver.findElements(By.xpath("//tr[6]//td"));
        System.out.println("column.size() = " + column.size());

        List<WebElement>office = driver.findElements(By.xpath("//tbody//td[4]"));
        for (WebElement officeColumn : office){
            System.out.println("officeColumn.getText() = " + officeColumn.getText());
        }


    }






}
