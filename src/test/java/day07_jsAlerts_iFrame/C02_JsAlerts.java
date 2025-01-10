package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class C02_JsAlerts extends TestBaseEach {

    // 3 test method'u olusturup asagidaki gorevi tamamlayin

    /*
    Bir WebElemente click yaptigimizda
    driver objesi ortam degisikligi beklemez

    ayni window'da kalip farkli bir url'e gitmeyi bekler

    fakat bazi islemler yapildiginda
    farkli bir ortam olusabilir
    driver'i bu farkli ortama gecirmek icin
    driver.switchTo() kullanmamiz gerekir

    Bu durumlardan birisi de JavaScript Alert'lerdir.

    JavaScript Alert calistiginda normal window uzerinde islem yapamayiz
    Sag tus yapip locate alamadigimiz icin alert uzerinde driver'i calistiramayiz
    Driver'in javaScript Alert'e gecmesi ve orada islem yapabilmesi icin
    oncelikle JSAlert evrenine switch yapmasi gerekir
     */

    @Test
    public void jsAlertsTest(){
        //1. Test
        //  -  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert ");

        //  - 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();
        //  -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //  -  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmTest(){
        //2.Test
        //  - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //  - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();
        //  - Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();
        //  cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazisi = "You clicked: Cancel";
        WebElement sonucYazisiElementi = driver.findElement(By.id("result"));
        String actualSonucYazisi = sonucYazisiElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void jsPromptTest(){
        //3.Test
        //  - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //  - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();
        //  - Cikan prompt ekranina "Ipek" yazdiralim
        driver.switchTo().alert().sendKeys("Ipek");
        //  - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //  - Cikan sonuc yazisinin Ipek icerdigini test edelim
        String expectedSonuYaziIcerik = "Ipek";
        WebElement sonucYazisiElementi = driver.findElement(By.id("result"));
        String actualSonucYazisi = sonucYazisiElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonuYaziIcerik));
    }
}
