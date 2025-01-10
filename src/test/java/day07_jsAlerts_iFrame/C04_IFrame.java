package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class C04_IFrame extends TestBaseEach {

    @Test
    public void test01 () {
        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");


        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        // electronics products yazisini unique olarak locate etmemize ragmen kullanamadik
        // HTML kodlari inceleyince kullanmak istedigimiz webelementin
        // bir iframe (gomulu HTML sayfa) icerisinde oldugunu belirledik
        // bir iframe icerisindeki elementi kullanabilmek icin
        // once o iframe'e gecis yapmamiz gerekir

        WebElement electronicsIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframeElementi);

        WebElement elektronicsProductsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(elektronicsProductsYaziElementi.isDisplayed());


        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElementi = driver.findElement(By.id("pictext1"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sale Up To 50% yazisinin gorunur oldugunu test edin

            // Iframe icine gecis yapinca, biz driver'i oradan cikarincaya kadar
            //driver iframe'in icinde kalir

        // driver.switchTo().parentFrame();
        // ic ice birden fazla katman olarak iframe varsa
        // bir ust katmana cikarir
        driver.switchTo().defaultContent();
        // ic ice birden fazla katman olarak iframe varsa
        // direkt anasayfaya cikarir
        WebElement saleUpYaziElementi = driver.findElement(By.xpath("//*[text()='Sale Up To 50%']"));
        Assertions.assertTrue(saleUpYaziElementi.isDisplayed());


        // 5- Fashion bolumundeki ilk urunu tiklayin
            //    fashion bolumu ayri bir IFrame icerisinde oldugundan , once o iFrame'e gecis yapmaliyiz
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIframe);

            // artik ilk urun isminde "Men Slim Fit" gectigini test edin
        WebElement fashionIlkElement = driver.findElement(By.xpath("(//*[@class='overlay'])[1]"));
            // bu xpath 3 element bulabiliyor
            // ANNCAAAKKK biz fashion iframe icinde oldugumuzdan
            // o iframe icinde olan tek bir elementi bize getirir

        String expectedIsimIcerik = "Men Slim Fit";
        String actualIsim = fashionIlkElement.getText();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));
    }
}
