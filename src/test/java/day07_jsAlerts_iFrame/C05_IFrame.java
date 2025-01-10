package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.util.List;

public class C05_IFrame extends TestBaseEach {
    @Test
    public void test01 () {
        // 1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");


        //2) sayfadaki iframe sayisini bulunuz
        List<WebElement> iframeListesi = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi: " + iframeListesi.size());


        //3) ilk iframe'deki (Youtube) play butonuna tiklayiniz
        driver.switchTo().frame(iframeListesi.get(0));
        WebElement playTusu = driver.findElement(By.xpath("//*[@aria-label='Play']"));
        playTusu.click();


        //4) ilk iframe'den cikip ana sayfaya donunuz
        driver.switchTo().defaultContent();


        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tiklayiniz
        driver.switchTo().frame(iframeListesi.get(1));
        driver.findElement(By.tagName("a")).click();
    }
}
