package test.day11;

import org.testng.annotations.Test;

public class C01_Notations1 {

        @Test (priority = 11)
        public void amazonTest(){
        System.out.println("aamazon test");

    }
        @Test (priority = -1)
        public void youTubeTest(){
        System.out.println("yutup test");

    }
        @Test (priority = 5)
        public void bestBuyTest(){
        System.out.println("bestBuy test");

    }

}
