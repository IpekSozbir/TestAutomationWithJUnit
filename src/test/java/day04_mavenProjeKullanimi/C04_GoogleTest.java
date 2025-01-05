package day04_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");


        //2- cookies uyarisini kabul ederek kapatin
        //driver.findElement(By.xpath("//div[.='Accept all']")).click();
        //cookie cikarsa ama locate degisir kontrol etmek gerekir


        //3- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");


        //4- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        //5- Sayfayi kapatin
        ReusableMethods.bekle(1);
        driver.quit();

    }
}
