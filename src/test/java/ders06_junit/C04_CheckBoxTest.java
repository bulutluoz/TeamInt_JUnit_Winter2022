package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxTest {
    // a. Verilen web sayfasına gidin.
    //	     https://the-internet.herokuapp.com/checkboxes
    //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //  c. Checkbox1'in secili olmadigini ve
    //     Checkbox2'nin secili oldugunu test edin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //  c. Checkbox1'in secili olmadigini ve
        //     Checkbox2'nin secili oldugunu test edin

        if (checkBox1.isSelected()){
            System.out.println("Checkbox1 secili, test FAILED");
        }else{
            System.out.println("Checkbox1 secili degil, test PASSED");
        }

        if (checkBox2.isSelected()){
            System.out.println("Checkbox2 secili, test PASSED");
        }else{
            System.out.println("Checkbox2 secili degil, test FAILED");
        }

    }

    @After
    public void teardown(){
        driver.close();
    }
    }
