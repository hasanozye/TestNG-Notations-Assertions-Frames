package test.day22;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/veriler.xlsx";
        FileInputStream fis = new FileInputStream(path);

        //Exceli okumak
        Workbook workbook = WorkbookFactory.create(fis);

        //Sheet (sayfa seçimi)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //Sayfadan sonra satır seçimi
        Row row = sheet.getRow(0);
        
        /*
        Cell cell = row.getCell(0);
        Cell cell1 = row.getCell(1);
        Cell cell2 = row.getCell(2);

        System.out.println("cell.toString() = " + cell.toString());
        System.out.println("cell.toString() = " + cell1.toString());
        System.out.println("cell.toString() = " + cell2.toString()); 
        */
        int count=0;
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            System.out.println(count++ +".row.getCell(i).toString() = " + row.getCell(i).toString());

        }

        //icerisinde data olan satir sayisi
        int satirSayisi = sheet.getPhysicalNumberOfRows();
        System.out.println("satirSayisi = " + satirSayisi);

        //*Sheet içindeki son satir

        int sonSatir = sheet.getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);

        fis.close();
        workbook.close();


    }
}
