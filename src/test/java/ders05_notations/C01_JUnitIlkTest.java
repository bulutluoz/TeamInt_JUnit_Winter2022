package ders05_notations;

import org.junit.Test;

public class C01_JUnitIlkTest {
    /*
     JUnit ile
     1- bir class'da birden fazla bagimsiz test method'u olusturabiliriz
     2- Bu test method'larini istersek bagimsiz olarak calistirabilir
        istersek class level'dan tum method'lari calistirabiliriz
     3- @Test notasyonu ile main method bagimliligi ortadan kalkar
        @Test notasyonu kullanilan method'lar bagimsiz olarak calistirilabilir
     4- JUnit standart olarak calistirilan Test method'larinin basarili bir sekilde calistigini
        veya failed oldugunu raporlar
     5- JUnit Assert class'indan hazir method'lar yaparak testleri gerceklestirir
        boylece if-else ile expected ve actual sonuclari karsilastirmamiza gerek kalmaz
     6- JUnit failed olan testlerde actual ve expected datalarin farkini da raporlar
     */

    @Test
    public void test01(){
        System.out.println("test01");
    }

    @Test
    public  void test02(){
        System.out.println("test02");
    }

    @Test
    public void test03(){
        System.out.println("test03");
    }
}
