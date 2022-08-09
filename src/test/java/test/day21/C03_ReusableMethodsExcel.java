package test.day21;

import com.google.common.collect.Table;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReusableMethodsExcel {


    public static Map<String, String> excelToMap(String path, String sayfaAdi) {
        Map<String, String> map = new TreeMap<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);

            int satirSayisi = workbook.getSheet(sayfaAdi).getLastRowNum();
            String key = "", value = "";

            for (int i = 0; i < satirSayisi; i++) {
                key = workbook.getSheet(sayfaAdi).getRow(i).getCell(0).getStringCellValue();
                value = workbook.getSheet(sayfaAdi).getRow(i).getCell(1).getStringCellValue() + " " +
                        workbook.getSheet(sayfaAdi).getRow(i).getCell(2).getStringCellValue() + " " +
                        workbook.getSheet(sayfaAdi).getRow(i).getCell(3).getStringCellValue();

                map.put(key, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
