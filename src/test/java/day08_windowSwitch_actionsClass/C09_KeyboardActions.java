package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseEach;

public class C09_KeyboardActions extends TestBaseEach {

    @Test
    public void test01 () {

        // 1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");


        //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("ı")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER).perform();


        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[.='DELL Core i3 11th Gen - (8 GB/256 GB SSD/32 GB E...']"));
        String expectedIsimIcerik = "DELL Core I3";
        String actualIsim = urunIsimElementi.getText();
        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));
    }

}
