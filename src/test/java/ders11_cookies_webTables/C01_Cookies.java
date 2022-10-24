package ders11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.youtube.com");

        driver.findElement(By.xpath("//*[text()='Accept all']")).click();

        Set<Cookie> cookiesSeti= driver.manage().getCookies();

        for (Cookie eachCookie: cookiesSeti
             ) {
            System.out.println(eachCookie);
        }

        System.out.println("==========");

        Cookie cookie=new Cookie("en guzel cookie", "bizim cookie");
        driver.manage().addCookie(cookie);

        cookiesSeti= driver.manage().getCookies();

        for (Cookie eachCookie: cookiesSeti
        ) {
            System.out.println(eachCookie);
        }

        bekle(3);
    }


}
