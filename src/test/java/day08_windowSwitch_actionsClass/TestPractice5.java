package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class TestPractice5 extends TestBaseEach {

    @Test
    public void test01 () {

        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


        // 2- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();
        ReusableMethods.bekle(1);


        // 3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertMesaj = "You selected a context menu";
        String actualAlertMesaj = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertMesaj,actualAlertMesaj);


        // 4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();


        // 5- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium"))
                .click();
        ReusableMethods.bekle(1);


        // 6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        ReusableMethods.urlIleWindowDegistir(driver,"https://elementalselenium.com/");
        WebElement h1Tagi = driver.findElement(By.className("hero__title"));
        String expectedh1TagiYazisi = "Elemental Selenium";
        String actualh1TagiYazisi = h1Tagi.getText();

        Assertions.assertEquals(expectedh1TagiYazisi,actualh1TagiYazisi);



    }
}
