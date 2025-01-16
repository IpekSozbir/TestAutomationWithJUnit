package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_FormDoldurma extends TestBaseEach {

    @Test
    public void test01 () {

        // 1- https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");


        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[text()='Account'])[1]"))
                .click();


        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up '] "))
                .click();


        //4- Ad, soyad, mail ve sifre kutularina deger yazin ve Sign Up butonuna basin

                /*
                Fromdaki tum kutulari tek tek locate etmek yerine firstName kutusuna click() yapip
                isim gonderdikten sonra
                sonraki kutulara gecisi TAB tusu ile yapalim
                 */

        WebElement firstNameKutusuElementi = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(firstNameKutusuElementi)
                .sendKeys("Ipek")
                .sendKeys(Keys.TAB)
                .sendKeys("Sozbir")
                .sendKeys(Keys.TAB)
                .sendKeys("ipek@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        driver.findElement(By.id("btn-submit-form")).click();


        //5- Kaydin olusturuldugunu test edin
            // Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
            // kaydin olustugunu test edebilmek icin giris yapalim

        WebElement emailKutusuElementi = driver.findElement(By.id("email"));
        WebElement passwordKutusuElementi = driver.findElement(By.id("password"));
        WebElement submitButonuElementi = driver.findElement(By.id("submitlogin"));

        emailKutusuElementi.sendKeys("ipek@gmail.com");
        passwordKutusuElementi.sendKeys("12345");
        submitButonuElementi.click();

       WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        Assertions.assertTrue(logoutButonu.isDisplayed());
        logoutButonu.click();
    }
}
