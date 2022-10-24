package ders10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class C04_Senkronizasyon {

/*
 Testlerimizi calistirirken
 internet, bilgisayarimizin hizi veya calistigimiz uygulamadan kaynaklanan gecikmeler olabilir

Bu durumda testimiz failed olmamasi icin kodlarimiz ile calisma ortamimizi(internet + bilgisayar +
calistigimiz uygulama) senkronize etmek gerekir

Senkronizasyon problemlerinden java'dan 1, selenium'dan 2 yardimci vardir.

1- Thread.sleep() Java'dan gelir
   ve dinamik degildir.
   yazilan sure kadar kodlarin alt satira gecmesini bekletir.
   Thread.sleep esnek olmadigi icin, gorev degil sure odakli calistigi icin
   testlerin gereksiz yere uzun surmesine sebep olabilir
   Bunun icin de test yazilirken kullanilmasi tercih edilmez
2- implicitlyWait(max.bekleme suresi)
   Selenium'dan gelir
   Dinamiktir, yani gorev odaklidir,
   her adimda max.sure beklemek yerine, gorevin gerceklesecegi sure kadar bekler
   max sure beklemedigi icin fazladan zaman harcanmasinin onune gecer

   implicitlyWait tum class'i kapsar
   tum class'daki herbir locate vb. islem icin dinamik bekleme suresi saglar

   max. bekleme suresi doldugu halde gorev gerceklesmemis olursa
   hata verir.

   implictly wait icin max bekleme suresini ne uzun ne de cok kisa olmasi tercih edilmez
   optimum bir max bekleme suresi belirlenmelidir.

3- Explicitly wait
   Eger test sirasinda yapacagimiz herhangi bir islem icin
   implicitly wait ile belirledigimiz sure yetmiyorsa
   tum testlerdeki implictly wait surelerini artirmak yerine
   sadece o teste ve sadece o isleme ozel bekleme olusturulabilir

   explicitly wait tek bir goreve odaklanmis bekleme suresi olusturur
   explicitly wait de dinamiktir, yani sureye degil, goreve odaklanir
   gorev erken tamamlanirsa, explicitly wait daha fazla beklemeden testin kalanina gecisi saglar


 */

    @Test
    public void test01() throws InterruptedException {
        // extends yapmadan ve implicitly wait olmadan
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        // youtube'a gidip cookies'i kabul edip
        driver.get("https://www.youtube.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        // ikinci video'ya tiklayalim

        driver.findElement(By.xpath("//div[@class= 'ytp-inline-preview-scrim ytp-inline-preview-scrim-clear']")).click();
    }
}
