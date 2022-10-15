package ders06_junit;

import org.junit.Assert;
import org.junit.Test;

public class C07_Assertions {
    int sayi1= 10;
    int sayi2= 20;
    int sayi3= 30;

    /*
    JUnit de Assert class'indaki hazir method'lar gerceklesen sonuclarin
    beklentilerimize uygun olup olmadigini kontrol eder

    expected result ile actual result ayni ise test PASSED
    expected result ile actual result farkli ise test FAILED

    genel olarak ifade etmek istersek
    test cumlesi olumlu ise assertTrue
    test cumlesi olumsuz ise assertFalse tercih edilir

    Assertion'nin failed oldugu satirda kodlarin calismasi durur
    o method'un icerisinde failed olan assertion'dan sonraki satirlar CALISTIRILMAZ

     */

    @Test
    public void test01(){


        /*
        Assert class'inda cok kullanacagimiz 4 hazir method bulunur
        Assert.assertTrue
        Assert.assertFalse
        Assert.assertEquals
        Assert.assertNotEquals
         */

        // sayi1'in sayi2'den kucuk oldugunu test edin
        Assert.assertTrue(sayi1<sayi2);

        // sayi1'in sayi2'den buyuk olmadigini test edin
        Assert.assertFalse(sayi1>sayi2);

        // sayi1'in sayi2'ye esit oldugunu test edin
        Assert.assertEquals(sayi1,sayi2);
    }

    @Test
    public void test02(){

        Assert.assertEquals(sayi3, sayi1+sayi2); // PASSED
    }
    @Test
    public void test03(){

        Assert.assertNotEquals(sayi3, sayi2); // PASSED
    }

    @Test
    public void test04(){

        Assert.assertTrue(sayi3==sayi2); // FAILED
    }

    @Test
    public void test05(){

        Assert.assertFalse(sayi3==sayi2); // Passed
    }

    @Test
    public void test06(){

        Assert.assertNotEquals(sayi3, sayi1+sayi2); // FAILED
    }

    @Test
    public void test07(){

        Assert.assertTrue(sayi3<sayi2); // FAILED
    }

    @Test
    public void test08(){

        Assert.assertFalse(sayi3>sayi2); // FAILED
        System.out.println("Bu satir yazdirilacak mi ?");
    }
}
