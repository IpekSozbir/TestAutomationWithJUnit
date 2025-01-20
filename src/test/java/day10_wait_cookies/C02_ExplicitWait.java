package day10_wait_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ExplicitWait {

    WebDriver driver;


    @Test
    public void implicitlyWaitTesti () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //2. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[@type='button'])[1]"))
                .click();


        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));
                                                                                    // //*[.="It's gone!"]

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@*='button'])[1]"))
                .click();


        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
                                                                                //  //*[.="It's back!"]

        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());

        ReusableMethods.bekle(1);
        driver.quit();


    }

    @Test
    public void explicitlyWaitTesti () {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //2. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[@type='button'])[1]"))
                .click();


        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));
        // //*[.="It's gone!"]

                /*
                itsGoneYaziElementi'nin gorunur olmasi icin BEKLEME(wait)'e ihtiyac var
                ama explicitlyWait icin de locate'e ihtiyac var
                boylece bu bir kisir dongu oluyor

                Selenium bu donguyu cozmek icin
                explicitly wait'de 3 adim yerine 2 adim atmamizi saglayan bir cozum uretmistir
                bu iki adimda locate ve bekleme islemini tek satirda yapiyoruz
                 */

            // 1. adim : wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2. ve 3. adim : bekleme yapmadan locate etmek mumkun olmadigi icin bekleme ve locate'i tek adimda yapacagiz
        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());


        //4. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]"))
                .click();


        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]")));
        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());


        ReusableMethods.bekle(1);
        driver.quit();
    }
}