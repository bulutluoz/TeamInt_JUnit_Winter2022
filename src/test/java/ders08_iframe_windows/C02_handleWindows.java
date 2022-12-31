package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_handleWindows {


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void windowtesti(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaWinHandDegeri= driver.getWindowHandle();
        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();
        /*
         Bir linke tikladigimizda driver'i acilan yeni window'a direk switch yapamayiz
         oncelikle o sayfanin window handle degerini bulmali
         ve o degeri kullanarak yeni sayfaya gecmeliyiz

         ilk sayfa WHD : CDwindow-28627133898E14448A33733211745B19

            Iki window'un window handle degerleri :
            [CDwindow-28627133898E14448A33733211745B19, CDwindow-16D881C607BD3D31BF6C8B124051C4A5]

         */

        Set<String> windowHandlesSeti= driver.getWindowHandles();

        String ikinciSayfaWinHandleDegeri="";

        for (String eachHandleDegeri: windowHandlesSeti
             ) {

            if (!eachHandleDegeri.equals(ilkSayfaWinHandDegeri)){
                ikinciSayfaWinHandleDegeri=eachHandleDegeri;
            }
        }

        driver.switchTo().window(ikinciSayfaWinHandleDegeri);
        System.out.println(driver.getTitle());

        // Acilan sayfadaki en bastaki yazinin gorunur oldugunu
        WebElement baslikElementi= driver.findElement(By.tagName("h1"));
        Assert.assertTrue(baslikElementi.isDisplayed());
        // ve yazinin Elemental Selenium oldugunu test edin
        String expectedYazi="Elemental Selenium";
        String actualYazi= baslikElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        /*
          driver.get() ile https://the-internet.herokuapp.com/iframe sayfasina gittik
          acilan yeni sayfanin url'i ise http://elementalselenium.com/

          bir test sirasinda birden fazla window aciliyorsa
          driver'a bu window'lar arasinda gecis yaptirabiliriz


         */


    }

    @After
    public void teardown(){
        driver.quit();
    }
}
