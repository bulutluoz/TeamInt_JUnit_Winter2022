package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void amazonTesti(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // en altdaki web table'dan home service secenegini tiklayin
        driver.findElement(By.xpath("//table//tr[3]//td[5]")).click();
        // ilgili sayfaya gittigini test edin

        WebElement baslikYaziElementi= driver.findElement(By.xpath("//img[@alt='Home services appointments during COVID-19']"));

        Assert.assertTrue(baslikYaziElementi.isDisplayed());

        bekle(5);


        // tum tablo body'sinde care kelimesi gecmedigini test edin


        WebElement tableBody= driver.findElement(By.xpath("//table/tbody"));

        System.out.println(tableBody.getText());

        Assert.assertFalse(tableBody.getText().contains("care"));


    }
}
