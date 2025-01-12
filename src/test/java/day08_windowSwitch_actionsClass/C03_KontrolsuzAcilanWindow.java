package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseEach;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01 () {

     // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkWindowWHD = driver.getWindowHandle();


    // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();


    // acilan yeni window'a gecip
        Set<String> tumWHDseti = driver.getWindowHandles();
        String ikinciWindowWHD = "";

        for(String each : tumWHDseti) {
            if(! each.equals(ilkWindowWHD))  {
                ikinciWindowWHD= each;
            }
        }

        driver.switchTo().window(ikinciWindowWHD);

    // buyuk basligin "Elemental Selenium" oldugunu test edin
        String expectedBuyukBaslik = "Elemental Selenium";
        String actualBuyukBaslik = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedBuyukBaslik,actualBuyukBaslik);
    }
}
