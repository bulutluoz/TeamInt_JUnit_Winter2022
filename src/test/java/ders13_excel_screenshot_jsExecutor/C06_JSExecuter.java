package ders13_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecuter extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidelim
            driver.get("https://www.amazon.com");

        // sell butonuna Js executor ile basalim

        WebElement sellLinki= driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",sellLinki);



        // bir alert olusturup yasasinnn yazdiralim

        jse.executeScript("alert('yasasinnnn');");



        bekle(5);

        driver.switchTo().alert().accept();
    }
}
