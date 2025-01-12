package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01 () {

        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");


        // Sayfadaki textin “Opening a new window” oldugunu dogrulayin
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        // Sayfa basliginin(title) “The Internet” oldugunu dogrulayin
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
        ReusableMethods.bekle(2);

        String ilkWindowWHD = driver.getWindowHandle();


        // Click Here butonuna basin
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();


        // Acilan yeni pencerenin sayfa basliginin (title) “New Window” oldugunu test edin
        ReusableMethods.bekle(5);
        System.out.println("Click Here Butonu'na bastiktan sonra title: " + driver.getTitle());

        /*
            driver.getWindowHandle() icerisinde oldugu window'un WHD'ini bize getirir
            biz de kaydedebiliriz

            bir window'un window handle degerini kaydettikten sonra
            nerede olursak olalim bu window'a gecis yapabiliriz
            driver.switchTo().window(hedefWindowunWHD); ile gecis yapabiliriz

            Kontrolsuz window acildiginda driver beklemedigi bir durum oldugundan
            yeni window'a gecmez
            eski window'da kalir
            yeni window'a gecemedigimiz icin yeni window'un WHD'ini de alamayiz

         */

        Set<String> tumWHDseti = driver.getWindowHandles();
        System.out.println("Tum WHD'leri Seti: " + tumWHDseti);
        System.out.println("Ilk sayfanin WHD Degeri: " + ilkWindowWHD);
        String ikinciWindowWHD = "";

        for(String each : tumWHDseti) {
            if(! each.equals(ilkWindowWHD))  {
                ikinciWindowWHD= each;
            }
        }

        driver.switchTo().window(ikinciWindowWHD);
        System.out.println("Bulmaca cozdukten sonra title: " + driver.getTitle());


        // Sayfadaki textin “New Window” oldugunu dogrulayin
        yaziElementi = driver.findElement(By.tagName("h3"));
        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        // Bir onceki pencereye geri dondukten sonra sayfa basliginin “The Internet” oldugunu test edin
        driver.switchTo().window(ilkWindowWHD);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
    }
}
