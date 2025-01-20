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

public class C01_ExplicitWait {

    // Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    // Iki metod icin de asagidaki adimlari test edin.
    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Textbox’in etkin olmadigini(enabled) dogrulayin
    // 3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
    // 4. Textbox’in etkin oldugunu(enabled) dogrulayin.
    // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.

    WebDriver driver;

    @Test
    public void implicitlyWaitTesti () {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        // 2. Textbox’in etkin olmadigini(enabled) dogrulayin
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());


        // 3. Enable butonuna tiklayin
        WebElement enableButtonu = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButtonu.click();

        // textbox etkin oluncaya kadar bekleyin
             // testimiz implicitlyWaitTest oldugu icin implicitlyWait'in yeterli olup olmadigini gormek icin
             //extra bekleme koymadik


        // 4. Textbox’in etkin oldugunu(enabled) dogrulayin.
        ReusableMethods.bekle(4);
        Assertions.assertTrue(textbox.isEnabled());

                /*
                ImplicitlyWait iki durumda bekleme yapar
                1- sayfanin yuklenmesi icin
                2- bir webElementin locate edilmesi icin

                gorevin 4. maddesinde textbox'in etkin olmasini beklememiz gerekiyor
                ancak bu bekle implicitlyWait'in gorev kapsaminda yok
                bu sebeple inplicitlyWait ile yaptigimizda 4.gorev FAILED olacaktir

                Testin PASSED olmasi icin mutlaka extra bekleme gerekir

                Ancak 5.gorevde gorulmeyen elementin gorunur olmasini ve
                locate edilebilmesini implicitlyWait bekler

                yani ozetle 4. gorevi implicitlyWait gerceklestirmemizi saglayamaz
                fakat 5.gorev icin yeterli olur

                4.gorevin gerceklesmesi icin Thread.sleep() kullandik
                 */


        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void explicitWait () {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));


        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        // 2. Textbox’in etkin olmadigini(enabled) dogrulayin
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());


        //3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButtonu = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButtonu.click();

        //ve textbox etkin oluncaya kadar bekleyin
        //explicitlyWait ile bekleyelim

                // 1. adim : bir wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
                // 2. adim : MUMKUNSE beklenecek objesi locate edip bir webElement olarak kaydet
                // (textbox'i biz kaydettik zaten)
                // 3. adim : wait objesine neyi bekelyecegini soyle
        wait.until(ExpectedConditions.elementToBeClickable(textbox));


        //4. Textbox’in etkin oldugunu(enabled) dogrulayin.
        Assertions.assertTrue(textbox.isEnabled());


        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        ReusableMethods.bekle(1);
        driver.quit();
    }
}
