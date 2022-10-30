package ders13_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotTumSayfa extends TestBase {

    @Test
    public void test01() throws IOException {

        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapalim

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedkelime="Nutella";
        String actualYazi= sonucYaziElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedkelime));

        // Tum sayfanin screenshot'ini almak icin 4 adim gerekiyor

        // 1- TakesScreenShot objesi olusturup
        //    deger olarak cast ettigimiz driver'i atayalim
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2- resmi kaydedecegimiz bir dosya olusturulur

        File tumSayfaSShot= new File("target/ScreenShot/tumSayfaScrenshot.jpeg");


        // 3- screenshot objesi kullanarak fotografi cekip, gecici dosyaya kaydet

        File geciciResim= tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi hazirladigim file'a kopyalayalim

        FileUtils.copyFile(geciciResim,tumSayfaSShot);

    }
}
