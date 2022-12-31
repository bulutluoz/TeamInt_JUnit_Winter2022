package ders13_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenshotWebelement extends TestBase {

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

        // sadece sonuc yazisi elementinin screenshot'ini cekelim
        // 1.adim screenshot cekecegimiz webelementi locate edelim

        // 2. 3. ve 4. adimlar tum sayfa screenshot ile ayni

        File istenenElementSShot= new File("target/ScreenShot/SonucyazisiScrenshot.jpeg");

        File geciciResim= sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,istenenElementSShot);

    }
}
