package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class TestPractice4 extends TestBaseEach {

    @Test
    public void test01 () {

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");


        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElementi = driver.findElement(By.id("draggable"));
        WebElement dropHereElementi = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();
        ReusableMethods.bekle(6);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi =  "Dropped!";
        String actualYazi = dropHereElementi.getText();
        System.out.println(dropHereElementi.getText());

        Assertions.assertEquals(expectedYazi,actualYazi);
    }
}
