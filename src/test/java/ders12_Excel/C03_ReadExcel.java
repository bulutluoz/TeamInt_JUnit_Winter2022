package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExceltest() throws IOException {
        // ulkeler excel'ine gidin
        // 32.satirdaki ulke isminin ingilizce Canada oldugunu test edelim

        String dosyaYolu= System.getProperty("user.home") +"/Desktop/ulkeler.xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        String actualIsim= workbook
                                .getSheet("Sayfa1")
                                .getRow(31)
                                .getCell(0)
                                .toString();
        String expectedisim="Canada";

        Assert.assertEquals(expectedisim,actualIsim);
    }
}
