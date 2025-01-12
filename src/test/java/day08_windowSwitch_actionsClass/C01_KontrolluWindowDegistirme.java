package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_KontrolluWindowDegistirme extends TestBaseEach {

    @Test
    public void test01 () {

        /*
            Eger bize verilen gorevde yeni bir tab veya yeni bir window acilmasi isteniyorsa
            driver.switchTo().newWindow(WindowType.TAB); yada
            driver.switchTo().newWindow(WindowType.WINDOW); ile
            yeni bir tab veya window acip driver'i yeni window'a otomatik olarak gecirebiliriz

            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            hedef window'un WindowHandle degerini girmeliyiz

            Eger birden fazla window aciyorsak
            ve geri donmemiz gerekecekse acilan her window'un window handle degerini kaydetmek faydali olacaktir
         */


        // testotomasyonu sayfasina gidin
        driver.get("https://testotomasyonu.com");


        // window handle degerini kaydedin ve yazdirin
        String testOtomasyonuWHD =  driver.getWindowHandle();
        System.out.println(testOtomasyonuWHD);
        ReusableMethods.bekle(2);


        // yeni bir tab acip yeni tab'da wiseQuarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");


        // window handle degerini kaydedin ve yazdirin
        String wiseQuarterWHD =  driver.getWindowHandle();
        System.out.println(wiseQuarterWHD);
        ReusableMethods.bekle(2);


        // yeni bir window acarak arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");


        // window handle degerini kaydedin ve yazdirin
        String arabamWHD =  driver.getWindowHandle();
        System.out.println(arabamWHD);
        ReusableMethods.bekle(2);


        // wisequarter'in acik oldugu window'a donun ve url'in wisequarter icerdigini test et
        driver.switchTo().window(wiseQuarterWHD);
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));


        // testotomasyonu'nun acik oldugu window'a donun ve url'in testotomasyonu icerdigini test et
        driver.switchTo().window(testOtomasyonuWHD);
        driver.switchTo().window(wiseQuarterWHD);
        String expectedUrlTestOtomasyonuIcerik = "testotomasyonu";
        String actualUrlTestOtomasyonu = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}
