package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {


    @Test
    public void test01(){
        /*
          Klavye'de cok fazla tus olsa da her bir tusla ilgili temel iki islem var

          1- tek seferlik basmak
            sendKeys(keys.ENTER)
          2- uzun sureli basmak ve isim bitince tustan elimizi kaldirmak
             - basmak icin keyDown()
             - basili tusu birakmak icin keyUp()
         */

        // amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        /*
        // arama kutusuna nutella yazin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella");
        // aramayi yapmak icin ENTER tusuna basin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

        bekle(2);
        // arama kutusunu temizleyelim
        driver.navigate().back();


         */
        // arama kutusuna actions class'ini kullanarak SamsungA71 yazdirin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        bekle(2);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

            bekle(5);
    }

}
