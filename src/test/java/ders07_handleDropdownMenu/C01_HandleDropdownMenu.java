package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_HandleDropdownMenu {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
        /*
          Dropdown menuler ozel web elementleridir ve select tag'i ile olusturulurlar
          1- dropdown menuyu locate edelim
          2- dropdown menulerden option secebilmek icin Select class'indan obje olusturmaliyiz
             obje'ye handle etmek istedigimiz dropdown'i parametre olarak girmeliyiz
          3- locate ettigimiz ve select objesi olusturdugumuz menuden option secmek icin
             - index
             - value
             - visibletext
             ile istedigimiz option'i secebiliriz.
         */
    @Test
    public void dropdownTest(){
        // amazona gidin
        driver.get("https://www.amazon.com");
        // Arama kutusunun solundaki search-in menusunden Electronics'i secin

        WebElement dropdownWebelement= driver.findElement(By.id("searchDropdownBox"));

        Select select= new Select(dropdownWebelement);

        select.selectByVisibleText("Electronics");

        // arama cubuguna Java yazip aratin

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        // bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String aramaSonucStr=aramaSonucElementi.getText();
        // System.out.println(aramaSonucStr); // 1-24 of 127 results for "Java"

        int indexOfOf=aramaSonucStr.indexOf("of");
        int indexOfResults=aramaSonucStr.indexOf("results");

        int aramaSonucSayisiInt= Integer
                                    .parseInt(aramaSonucStr
                                    .substring(indexOfOf+3,indexOfResults-1));

        Assert.assertTrue(aramaSonucSayisiInt>1000);

    }



    @After
    public void teardown(){
       driver.close();
    }
}
