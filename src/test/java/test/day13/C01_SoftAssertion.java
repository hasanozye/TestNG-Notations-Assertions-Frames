package test.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class C01_SoftAssertion {

    @Test
    public void test() {
        int a = 10;
        int b = 20;
        int c = 30;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a > b, "1. Test is failed");//fail
        softAssert.assertTrue(a > c, "2. test is fail");//fail
        softAssert.assertTrue(b > a, "3. test is fail");//pass
        softAssert.assertTrue(c > a, "4. test fail");//pass
        softAssert.assertTrue(c < a, "5.Test fail");//fail




        System.out.println();
    }
}
