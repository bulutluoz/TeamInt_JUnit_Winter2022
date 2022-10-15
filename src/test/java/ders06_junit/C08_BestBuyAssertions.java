package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test
    public void urlTest(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        driver.get("https://www.bestbuy.com/");

        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Test
    public void titleTest(){
       // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        driver.get("https://www.bestbuy.com/");

        String expectedYanlisIcerik= "Rest";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedYanlisIcerik));
    }

    @Test
    public void logoTesti(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        driver.get("https://www.bestbuy.com/");
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void francaisTesti(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        driver.get("https://www.bestbuy.com/");
        WebElement francaisElementi= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francaisElementi.isDisplayed());
    }


    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
