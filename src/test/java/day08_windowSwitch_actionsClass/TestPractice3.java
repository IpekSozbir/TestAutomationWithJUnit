package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class TestPractice3 extends TestBaseEach {

    @Test
    public void test01 () {

        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");


        // 2- Elektronics Products yazisinin gorunur oldugunu test edin
        WebElement electronicsIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframeElementi);

        WebElement elektronicsProductsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(elektronicsProductsYaziElementi.isDisplayed());


        // 3- Dell bilgisayar urun isminin 'DELL Core I3 1 1th Gen' oldugunu test edin
        WebElement dellElementi = driver.findElement(By.id("pictext1"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();


        // 4- Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        dellElementi.click();
        ReusableMethods.urlIleWindowDegistir(driver,"https://testotomasyonu.com/product/58");
        ReusableMethods.bekle(2);
        WebElement urunFiyatElementi = driver.findElement(By.className("price-wrap"));
        String expectedUrunFiyati = "$399.00";
        String actualUrunFiyati = urunFiyatElementi.getText();

        Assertions.assertEquals(expectedUrunFiyati,actualUrunFiyati);


        // 5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver,"https://testotomasyonu.com/discount");
        WebElement fashionIframeElementi = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframeElementi);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[text()='Fashion']"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());


        // 6- Sayfayi kapatin
    }
}
