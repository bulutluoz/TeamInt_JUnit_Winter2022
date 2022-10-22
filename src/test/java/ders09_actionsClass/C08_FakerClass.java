package ders09_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C08_FakerClass {

    @Test
    public void test01(){

        Faker faker=new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().fullName());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.internet().password());
    }
}
