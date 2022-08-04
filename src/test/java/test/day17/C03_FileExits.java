package test.day17;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExits {

    @Test
    public void testFilePath(){

        System.out.println("System.getProperty() = " + System.getProperty("user.home"));


        String path = System.getProperty("user.home")+"\\Desktop\\Deneme1\\appium.xlsx";
        System.out.println("PATH = " + path);
        System.out.println("Files.exists(Paths.get(path)) = " + Files.exists(Paths.get(path)));


        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        String pathPomXml=System.getProperty("user.dir")+"\\pom.xml";
        System.out.println("pathPomXml = " + pathPomXml);

        Assert.assertTrue(Files.exists(Paths.get(pathPomXml)),"pom xml yoktur.");
    }
}
