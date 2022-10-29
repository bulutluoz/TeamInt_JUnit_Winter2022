package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_HandleDDM {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void ddmTest() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ddmElementi= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select= new Select(ddmElementi);
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);

        System.out.println(    select.getFirstSelectedOption().getText()    );


        Thread.sleep(2000);
        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        //	4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> optionsList= select.getOptions();

        for (WebElement eachWebElement: optionsList
             ) {
            System.out.println(eachWebElement.getText());
        }

        //	5. Dropdown’un boyutunun 3 oldugunu test edin

        Assert.assertEquals(3,optionsList.size());


    }
    @After
    public void teardown(){
        driver.close();
    }
}
