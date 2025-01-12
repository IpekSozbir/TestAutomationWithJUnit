package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_HedefUrlIleWindowDegistirme extends TestBaseEach {

    @Test
    public void test01 () {

        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");


        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();


        // acilan yeni window'a gecip
        String hedefUrl = "https://elementalselenium.com/";


        // acik olan tum window'larin whd'lerini kaydedelim
        Set<String> tumWindowWHDseti = driver.getWindowHandles();


        // bir for-each loop ile tum whd'leri gozden gecirip
        // her wwhd sayfasina gecelim
        // eger gectigimiz sayfada url hedef url'e esit ise loop'u bitirelim
        for (String eachWHD :tumWindowWHDseti) {
            driver.switchTo().window(eachWHD);
            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }


        // buyuk basligin "Elemental Selenium" oldugunu test edin
        String expectedBuyukBaslik = "Elemental Selenium";
        String actualBuyukBaslik = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedBuyukBaslik,actualBuyukBaslik);
    }
}
