package ders13_excel_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C05_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // tum sayfanin fotografini cekelim

        tumSayfaResimCek();
        // arama kutusuna Nutella yazip, fotografini cekelim

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");

        webelementScreenshot(aramaKutusu);
        aramaKutusu.submit();

        // Aramayi yapip, sonucun nutella icerdigini test edin
        // ve sonuc yazisinin fotografini cekin


        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedkelime="Nutella";
        String actualYazi= sonucYaziElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedkelime));

        webelementScreenshot(sonucYaziElementi);

    }
}
