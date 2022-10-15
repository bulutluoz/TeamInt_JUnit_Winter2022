package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_BestBuyAssertions {

    // 1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
