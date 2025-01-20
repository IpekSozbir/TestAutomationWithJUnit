package day10_wait_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C03_OlmayanElementiTestEtme extends TestBaseEach {

    @Test
    public void test01(){

        /*
            Olmayan veya gorunmeyen bir WebElementi test etmek icin
            olusacak exception'i belirleyip
            exception olusmasini TESTIN PASSED olmasi icin bir basamak yapmaliyiz

            exception olusmamasi durumunda ise TEST FAILED olmalidir
         */

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //2. Remove butonuna basin ve
        WebElement chexboxButonu=driver.findElement(By.xpath("(//*[@*='checkbox'])[2]"));
        WebElement removeButonu =driver.findElement(By.xpath("(//*[@*='button'])[1]"));
        removeButonu.click();

        // it's gone yazisi gorununceye kadar bekleyin
        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));


        //3. checkbox'in gorunur olmadigini test edin
        /*
            checkbox'i daha onceden locate ettigimiz icin
            StaleElementReferenceException verdi,

            eger onceden locate etmemis olsaydik
            bu satirda locate etmeye calissaydik
            implicitlyWait suresi kadar bekler ve sonra
            NoSuchElementException verirdi
         */

        try {
            chexboxButonu.click();
            Assertions.assertTrue(false,"checkbox gorunur durumda");
            // checkbox kutusunun OLMAMASI gerekiyor
            // VARSA ve click yapabildiysek TEST FAILED OLMALIDIR
        } catch (StaleElementReferenceException e) {
            // StaleElementReferenceException olusmasi
            // o elementin gorunur olmadigini ispatlar
            // testin PASSED OLMASI gerekir
            Assertions.assertTrue(true);
        }


        //4. Add buttonuna basin
        WebElement addButonu=driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        addButonu.click();

        //5. checkbox'in gorunur oldugunu test edin

        WebElement chexboxButonu2=driver.findElement(By.xpath("//*[@id='checkbox']"));

        Assertions.assertTrue(chexboxButonu2.isDisplayed());
    /*
        try {
            chexboxButonu2.click();
            Assertions.assertTrue(true);
        }catch (StaleElementReferenceException e){
            Assertions.assertTrue(false,"checkbox gorunur durumda");
        }catch (NoSuchElementException e){
            Assertions.assertTrue(false);
        }
    */
    }
}

