package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_FileUploadTesti extends TestBaseEach {

    @Test
    public void test01 () {
        // 1.https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");


        //2.chooseFile butonuna basin
        WebElement chooseFileButonElementi = driver.findElement(By.id("file-upload"));

             /*
             chooseFile butonuna bastigimizda bilgisayarimizdaki dosya yapisi cikiyor

            WebDriver ile bilgisayarimizdaki fiziki dosya yapisina mudahale edemeyecegimiz icin
            selenium bize sendKeys(dosyaYolu) yapma firsati verir

             */


        //3.Yuklemek istediginiz dosyayi secin
        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/deneme.txt";
        chooseFileButonElementi.sendKeys(dinamikDosyaYolu);
        ReusableMethods.bekle(1);


        //4.Upload butonuna basin
        driver.findElement(By.id("file-submit"))
                        .click();
        ReusableMethods.bekle(1);


        //5.“File Uploaded!” textinin goruntulendigini test edin
        WebElement fileUploadedYaziElementi = driver.findElement(By.tagName("h3"));
        Assertions.assertTrue(fileUploadedYaziElementi.isDisplayed());

    }
}
