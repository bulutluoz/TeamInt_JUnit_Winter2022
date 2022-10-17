package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C04_TestBaseIlkTest extends TestBase {


    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
    }


}
