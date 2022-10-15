package ders06_junit;

import org.junit.*;

public class C02_Notasyonlar {

    @BeforeClass
    public static void setupClass(){
        System.out.println("Before Class Calisti");
    }

    @AfterClass
    public static void teardownClass(){
        System.out.println("After Class Calisti");
    }

    @Before
    public void setupMethod(){
        System.out.println("Before calisti");
    }

    @After
    public void afterMethod(){
        System.out.println("After calisti");
    }

    @Test
    public void test1(){
        System.out.println("Test1 calisti");
    }

    @Test
    public void test2(){
        System.out.println("Test2 calisti");
    }

    @Test
    public void test3(){
        System.out.println("Test3 calisti");
    }
}
