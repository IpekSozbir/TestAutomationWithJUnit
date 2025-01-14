package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class TestPractice2 extends TestBaseEach {

    @Test
    public void test01 () {

        //● https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");


        //● Sayfadaki textin “Add/Remove Elements” oldugunu dogrulayin
        String expectedText = "Add/Remove Elements";
        String actualText = driver.findElement(By.tagName("h2")).getText();

        Assertions.assertEquals(expectedText,actualText);


        //● Sayfa basliginin(title) “Test Otomasyonu” oldugunu doğrulayin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        String ilkWindowWhd = driver.getWindowHandle();


        //● ’Please click for Electronics Products’ linkine tiklayin
        driver.findElement(By.xpath("//*[.='Electronics Products']"))
                .click();
        ReusableMethods.bekle(2);

        //● Electronics sayfasinin acildigini test edin
        String ikinciWindowWhd = "";
        Set<String> tumWindowWHd = driver.getWindowHandles();
        for (String eachWhd : tumWindowWHd) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);
        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);


        //● Bulunan urun sayisinin 16 oldugunu test edin
        WebElement urunSayisiElementi = driver.findElement(By.className("product-count-text"));
        String sonucSayisiStr = urunSayisiElementi.getText().replaceAll("\\D","");
        int actualUrunSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedUrunSayisi = 16;
        Assertions.assertEquals(expectedUrunSayisi,actualUrunSayisi);


        //● Ilk actiginiz addremove sayfasina donun
        ReusableMethods.urlIleWindowDegistir(driver,"https://testotomasyonu.com/addremove/");


        //● Url’in addremove icerdigini test edin
        String expectedUrlIcerik = "addremove";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}
