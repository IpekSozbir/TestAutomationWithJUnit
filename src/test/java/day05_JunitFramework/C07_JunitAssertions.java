package day05_JunitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_JunitAssertions {
    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Testotomasyonu ana sayfaya gidin
    // Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    // ve arama sonucunda urun bulunabildigini test edin
    // 3- Ilk urunu tiklayin
    // ve acilan sayfadaki urun isminde caseSensitive olmadan "phone" bulundugunu test edin


    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01  () { // anasayfaTesti
        // 1- Testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com");
        // Url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url beklendigi gibi degil");
    }

    @Test
    public void test02 () {  // urunAramaTesti
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));
        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualBulunanUrunSayisi>0,"Arama sonucunda urun bulunamadi");
    }

    @Test
    public void test3 () { // ilkUrunIsimTesti
        // 3- Ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();
        // ve acilan sayfadaki urun isminde caseSensitive olmadan "phone" bulundugunu test edin
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik),"Urun ismi phone icermiyor");
    }
}
