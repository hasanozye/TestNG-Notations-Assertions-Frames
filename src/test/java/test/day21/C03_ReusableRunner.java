package test.day21;

import org.testng.Assert;
import org.testng.annotations.Test;


public class C03_ReusableRunner {


    @Test
    public void test01(){
        String path = "src/test/java/resources/ulkeler.xlsx";
        String eR ="Azerbaycan";
        String actual= String.valueOf(C03_ReusableMethodsExcel.excelToMap(path,"Sayfa1"));
        Assert.assertEquals(actual,eR,"NOPE");

    }



}
