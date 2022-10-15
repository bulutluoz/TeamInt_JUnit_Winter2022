package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass {

    // amazon sayfasina gidin
    // uc ayri test method'u olusturup
    // Nutella, java ve Selenium icin arama yapip, arama sonuclarini yazdirin

    /*
      @BeforeClass ve @AfterClass notasyonlarinin kullanildigi method'lar
      static olmak ZORUNDADIR

      JUnit Test method'larini ongoremeyecegimiz bir sira ile calistirir
      Test method'larini yazarken tamaminin bagimsiz olarak da
      calistirilabilecegini goz onunde bulundurmaliyiz
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void testNutella(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonucElementi.getText());
    }

    @Test
    public void testJava(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonucElementi.getText());
    }

    @Test
    public void testSelenium(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Selenium" + Keys.ENTER);
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonucElementi.getText());
    }


    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
