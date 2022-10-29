package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        // ulkeler excelinde turkce ulke isimleri Senegal iceriyor mu test edin
        // toplam 190 ulke oldugunu test edin
        // en uzun ulke isminin Mikronezya Federal Devletleri oldugunu test edin

        String dosyaYolu=System.getProperty("user.home")+ "/Desktop/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        List<String> ulkelerListesi= new ArrayList<>();
        int sonSatirIndexi= workbook
                                .getSheet("Sayfa1")
                                .getLastRowNum();

        for (int i = 0; i < sonSatirIndexi; i++) {

            ulkelerListesi.add(workbook.getSheet("sayfa1").getRow(i).getCell(2).toString());
        }

        ulkelerListesi.remove(0);
        // ulkeler excelinde turkce ulke isimleri Senegal iceriyor mu test edin

        Assert.assertTrue(ulkelerListesi.contains("Senegal"));

        // toplam 190 ulke oldugunu test edin

        Assert.assertEquals(190,ulkelerListesi.size());

        // en uzun ulke isminin Mikronezya Federal Devletleri oldugunu test edin

        String enUzunIsim="Macaristan";

        for (String each: ulkelerListesi
             ) {

            if (each.length()>enUzunIsim.length()){
                enUzunIsim=each;
            }
        }

        System.out.println("En uzun isimli ulke : " + enUzunIsim);
        Assert.assertEquals("Mikronezya Federal Devletleri",enUzunIsim);
    }
}
