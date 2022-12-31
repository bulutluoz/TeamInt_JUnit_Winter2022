package ders10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void downloadTesti(){

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.xpath("//*[text()='logo.png']")).click();

        bekle(5);

        String dosyaYolu= System.getProperty("user.home")+ "/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}


