package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_CheckboxTesti {

    static WebDriver driver ;

    @BeforeEach
    public void setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown () {
        driver.quit();
    }

    @Test
    public void test () {
        // a. Verilen web sayfasina gidin
        //     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);


        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiCheckBox.click();

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        carpintiCheckBox.click();


        // c. Sirt Agrisi ve Carpinti checkbox’larininin secili oldugunu test edin
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());


        // d. Seker ve Epilepsi checkbox’larininin secili olmadigini test edin
        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());
    }
}
