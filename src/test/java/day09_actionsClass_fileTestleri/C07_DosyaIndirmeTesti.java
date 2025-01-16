package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyaIndirmeTesti extends TestBaseEach {

    @Test
    public void test01 () {
        // 1. https://the-internet.herokuapp.com/download adresine gidin
        driver.get("https://the-internet.herokuapp.com/download");


        //2. download.jpeg dosyasini indirin
        driver.findElement(By.xpath("//*[.='download.png']"))
                .click();
        ReusableMethods.bekle(2);


        //3. Dosyanin basariyla indirilip indirilmedigini test edelim
        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/download.png";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
