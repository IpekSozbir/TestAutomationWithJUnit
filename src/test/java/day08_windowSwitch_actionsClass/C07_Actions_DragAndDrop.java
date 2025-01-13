package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_Actions_DragAndDrop extends TestBaseEach {

    @Test
    public void test01 () {

        // 1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");


        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement acceptableButonElementi = driver.findElement(By.xpath("//*[.='Acceptable']"));
        WebElement dropHereKutusuElementi = driver.findElement(By.xpath("//*[.='Drop Here']"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.dragAndDrop(acceptableButonElementi, dropHereKutusuElementi).perform();


        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziTesti = driver.findElement(By.xpath("//*[.='Dropped!']"));
        String expectedYazi= "Dropped!";
        String actualYazi = droppedYaziTesti.getText();
        Assertions.assertEquals(expectedYazi,actualYazi);


        // 4- Sayfayi yenileyin
        driver.navigate().refresh();


        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElement = driver.findElement(By.xpath("//*[.='Not Acceptable']"));
        dropHereKutusuElementi = driver.findElement(By.xpath("//*[.='Drop Here']"));
        actions.dragAndDrop(notAcceptableElement,dropHereKutusuElementi).perform();


        // 6- “Drop Here” yazisinin degismedigini test edin
        expectedYazi = "Drop Here";
        actualYazi = dropHereKutusuElementi.getText();
        Assertions.assertEquals(expectedYazi,actualYazi);
    }
}
