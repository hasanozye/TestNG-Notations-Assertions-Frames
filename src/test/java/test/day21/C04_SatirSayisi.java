package test.day21;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_SatirSayisi {

    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum(); //this here works with index
        int sayfadakiFizikselSatirNo=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); //indexle degil sayfa sayisi ile çalışır

        System.out.println("satirSayisi = " + satirSayisi);
        System.out.println("sayfadakiFizikselSatirNo = " + sayfadakiFizikselSatirNo);

        int satirSayisi2=workbook.getSheet("Sayfa2").getLastRowNum();
        int sayfadakiFizikselSatirNo2=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("satirSayisi2 = " + satirSayisi2);
        System.out.println("sayfadakiFizikselSatirNo2 = " + sayfadakiFizikselSatirNo2);


    }


}
