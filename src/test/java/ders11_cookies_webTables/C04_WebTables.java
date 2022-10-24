package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // en alttaki web table'da 10 satir oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//table//tr"));
        Assert.assertTrue(satirlarListesi.size()==10);

        // sutun sayisinin 14 oldugunu test edin
        List<WebElement> ilkSatirDataListesi = driver.findElements(By.xpath("//table//tr[1]/td"));
        Assert.assertTrue(ilkSatirDataListesi.size()==14);

        // 3. sutunu yazdirin
        List<WebElement> ucuncuSutunDataListesi = driver.findElements(By.xpath("//table//tr/td[3]"));

        for (WebElement each: ucuncuSutunDataListesi
             ) {
            System.out.println(each.getText());
        }
        // 5.satiri yazdirin
        System.out.println("==============");

        List<WebElement> besinciSatirDataListesi = driver.findElements(By.xpath("//table//tr[5]"));
        for (WebElement each: besinciSatirDataListesi
        ) {
            System.out.println(each.getText());
        }
        // 3.satir, 5.sutundaki basligin Home Service oldugunu test edin
        WebElement ucuncuSatirBesinciSutun= driver.findElement(By.xpath("//table//tr[3]/td[5]"));
        String expectedIcerik="Home Service";
        String actualData=ucuncuSatirBesinciSutun.getText();

        Assert.assertTrue(actualData.contains(expectedIcerik));
        // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun

        dataYazdir(5,5);

   bekle(5);
    }

    public void dataYazdir(int satir, int sutun) {

        String dataXpathi= "//table//tr["+satir+"]/td["+sutun+"]";

        WebElement arananData= driver.findElement(By.xpath(dataXpathi));


        System.out.println(satir + ".satir, "+ sutun+ ".ci sutundaki data : " + arananData.getText());
    }
}
