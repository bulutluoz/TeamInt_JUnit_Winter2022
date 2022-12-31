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


        driver.get("https://www.wisequarter.com");

        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        WebElement beklen= driver.findElement(By.xpath("(//h3[@class='elementor-icon-box-title'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView();",beklen);

        WebElement goToCareerPage= driver.findElement(By.xpath("//i[@class='fas fa-paper-plane']"));
        goToCareerPage.click();

        bekle(10);


    }
}
