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

public class C09_YoutubeTest {
    // 1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void titleTest(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']")).click();

        // ○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin

        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void imageTesti(){
        //○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        driver.get("https://www.youtube.com");
        //driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']")).click();
        WebElement youtubeLogo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(youtubeLogo.isDisplayed());
    }

    @Test
    public void aramaKutusuTesti(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.youtube.com");
        //driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']")).click();
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }

    @Test
    public void negatifTitleTest(){
        driver.get("https://www.youtube.com");
        //driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']")).click();

        // ○ titleTest 	=> Sayfa başlığının “youTube” olmadigini test edin

        String expectedYanlisTitle="youTube";
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals(expectedYanlisTitle,actualTitle);

    }


    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
