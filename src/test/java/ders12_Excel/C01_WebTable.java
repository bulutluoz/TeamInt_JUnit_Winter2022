package ders12_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {

    @Test
    public void webtableTesti(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriListesi=
                driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));

        for (WebElement eachElement:baslikElementleriListesi
             ) {
            System.out.print(eachElement.getText() + "---");
        }
        //  3. 3.sutunun basligini yazdirin
        System.out.println("");
        System.out.println(baslikElementleriListesi.get(2).getText());
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> dataElementleriListesi=
                driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement eachElement:dataElementleriListesi
             ) {
            System.out.println(eachElement.getText());
        }
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int sayac=0;
        for (WebElement eachElement:dataElementleriListesi
             ) {

            if (!eachElement.getText().isBlank()){
                sayac++;
            }
        }
        System.out.println("Tabloda bos olmayan hucre sayisi : "+ sayac);
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriListesi=
                driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("tablodaki satir sayisi : " +satirElementleriListesi.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriListesi.size());
        //  8. Tablodaki 3.kolonu yazdirin
        //      tablo table tag'lari ile olusturulmadigindan data bilgisine dinamik olarak ulasamadik
        for (int i = 2; i < dataElementleriListesi.size(); i+=7) {

            System.out.println(dataElementleriListesi.get(i).getText());
        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        for (int i = 0; i < dataElementleriListesi.size(); i++) {
            if (dataElementleriListesi.get(i).getText().equalsIgnoreCase("Kierra")){
                System.out.println("Kierra'nin maasi : "+ dataElementleriListesi.get(i+4).getText());

            }
        }
        //10. class icerisinde bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }
}
