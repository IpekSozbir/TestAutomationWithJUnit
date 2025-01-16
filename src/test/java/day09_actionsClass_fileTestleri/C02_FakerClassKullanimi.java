package day09_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C02_FakerClassKullanimi {

    @Test
    public void test01() {

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); // Ross
        System.out.println(faker.name().nameWithMiddle()); // Candra Hegmann Robel Jr.
        System.out.println(faker.name().username()); // otha.metz

        System.out.println(faker.address().zipCode()); // 95071-0385
        System.out.println(faker.address().fullAddress()); // Suite 071 28739 Kirstie Track, Bartellberg, GA 07258
        System.out.println(faker.address().cityName()); // Lake Ashleytown

        System.out.println(faker.internet().emailAddress()); // kristofer.erdman@hotmail.com
        System.out.println(faker.internet().password()); //h9ga32g4yt
        System.out.println(faker.internet().url()); //www.leon-dubuque.org
    }
}
