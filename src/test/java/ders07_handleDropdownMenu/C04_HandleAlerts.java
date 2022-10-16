package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HandleAlerts {

    /*
      Otomasyon sirasinda karsimiza iki tur alert cikar
      1- HTML alerts :
         diger HTML elementleri gibi locate edilebilir
         otomasyonda kullanilabilir
      2- javaScript alerts
         HTML kodlarla locate edilemez
         dolayisla da click, getText gibi method'lar calismaz

       javaScript alert'ler icin tek yontemimiz vardir
       switchTo( ) kullanarak allert'e gecmekl
       ve alert'un izin verdigi islevleri yapmak
     */

    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //		○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //		“You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //		○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //		“successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //		○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //		OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //		○ 1. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        //		alert'deki OK butonuna tıklayın ve
        driver.switchTo().alert().accept();

        //		result mesajının “You successfully clicked an alert” oldugunu test edin.

        String expectedSonucYazisi= "You successfully clicked an alert";
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        Thread.sleep(2000);
    }

    @Test
    public void dismissalertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //		○ 2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //		uyarıdaki Cancel butonuna tıklayın ve
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        //		result mesajının “successfuly” icermedigini test edin.
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();
        String unexpectedSonuc="successfuly";

        Assert.assertFalse(actualSonucYazisi.contains(unexpectedSonuc));
    }

    @Test
    public void sendKeysTesti() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 3. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        //  uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Nevzat Celik");
        Thread.sleep(3000);
        //		OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //		ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedIsim="Nevzat Celik";
        Thread.sleep(3000);
        Assert.assertTrue(actualSonucYazisi.contains(expectedIsim));
    }

    @After
    public void teardown(){
        driver.close();
    }
}
