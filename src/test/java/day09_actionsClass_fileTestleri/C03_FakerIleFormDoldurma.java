package day09_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C03_FakerIleFormDoldurma extends TestBaseEach {

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
                Fromdaki tum kutulari tek tek locat etmek yerine firstName kutusuna click() yapip
                isim gonderdikten sonra
                sonraki kutulara gecisi TAB tusu ile yapalim
                 */

        WebElement firstNameKutusuElementi = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String fakeSifre = faker.internet().password();
        String fakeMail = faker.internet().emailAddress();

        ReusableMethods.bekle(1);

        actions.click(firstNameKutusuElementi)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        driver.findElement(By.id("btn-submit-form")).click();


        //5- Kaydin olusturuldugunu test edin
            // Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
            // kaydin olustugunu test edebilmek icin giris yapalim

        WebElement emailKutusuelementi = driver.findElement(By.id("email"));
        WebElement passwordKutusuelementi = driver.findElement(By.id("password"));
        WebElement submitButonuElementi = driver.findElement(By.id("submitlogin"));

        emailKutusuelementi.sendKeys(fakeMail);
        passwordKutusuelementi.sendKeys(fakeSifre);
        submitButonuElementi.click();

        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        Assertions.assertTrue(logoutButonu.isDisplayed());
        logoutButonu.click();
    }
}
