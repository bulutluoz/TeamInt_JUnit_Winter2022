package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01()  {
        // Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists”
        //    menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement accountAndListElementi= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(accountAndListElementi).perform();

        //3- “Create a list” butonuna basalim

        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement yourListElementi= driver.findElement(By.id("my-lists-tab"));
        Assert.assertTrue(yourListElementi.isDisplayed());
        bekle(5);
    }
}
