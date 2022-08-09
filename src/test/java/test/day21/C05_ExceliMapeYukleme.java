package test.day21;

import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapeYukleme {

    @Test
    public void test01(){
        String path = "src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi="Sayfa1";

        Map<String ,String > ulkelerMap=C03_ReusableMethodsExcel.excelToMap(path,sayfaAdi);
        //Mapi kullanarak "Cuba" bilgilerini yazdırınız..
        System.out.println("ulkelerMap.get(\"Cuba\") = " + ulkelerMap.get("Cuba"));

    }


}
