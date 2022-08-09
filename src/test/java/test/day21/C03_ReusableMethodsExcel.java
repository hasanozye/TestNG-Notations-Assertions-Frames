package test.day21;

import com.google.common.collect.Table;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReusableMethodsExcel {


    public static Cell hucreGetir(String path, String sayfaIsmi, int satirIndex, int hucreIndex) {
        Cell cell = null;
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            cell = workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cell;
    }

}
