package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class C03_BasicAuthentication extends TestBaseEach {
    @Test
    public void test01 () {
        // 1- Bir class olusturun : BasicAuthentication
        // 2- https://testotomasyonu.com/basicauth sayfasina gidin
        // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        // Html komutu : https://username:password@URL
        // Username    : membername
        // Password    : sunflower


        // driver.get("https://testotomasyonu.com/basicauth");
        // sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
        // ancak otomasyon ile gittigimizde kullanici adi ve sifresi bolumunu locate edemedigimiz icin kullanamayiz
        // Bunun yerine kullandigimiz url'in sahibi olan sirketin bize verecegi kullanici adi ve sifresini
        // yine sirketin bize tarif edecegi yontemle url'e eklemeliyiz

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement basicAuthYaziElementi = driver.findElement(By.tagName("h1"));
        Assertions.assertTrue(basicAuthYaziElementi.isDisplayed());
    }
}
