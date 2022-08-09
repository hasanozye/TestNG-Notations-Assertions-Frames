package test.day21;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {

        //todo
        // *Biz fis ile okuduğumuz excel dosyasını projemiz içerisinden kullanmak için
        // *Apochi POI dependency yardımıyla bir Worbook oluşturduk.
        // * Bu worbook sayesinde bir adet kopya oluşturup kullanıyoruz.
        // * Excelin yapısı itibariyle hücreye ulaşmak için workbooktan başlayıp sheet ,row,cell ekadar gidip objeleri oluşturmamız lazım.


        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(5);
        Cell cell = row.getCell(2);

        System.out.println("cell = " + cell); //Angola

        String expected = "Angola";
        Assert.assertEquals(cell.getStringCellValue(),expected);

        row = sheet.getRow(40);
        cell = row.getCell(2);

        System.out.println("cell = " + cell);








    }


}
