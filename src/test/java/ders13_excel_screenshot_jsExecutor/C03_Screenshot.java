package ders13_excel_screenshot_jsExecutor;

import org.junit.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        tumSayfaResimCek();

        bekle(1);

        driver.get("https://www.youtube.com");

        tumSayfaResimCek();
    }
}
