package day10_wait_cookies;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseEach;

public class TestPractice1 extends TestBaseEach {
    @Test
    public void test01() {

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirstButton = driver.findElement(By.xpath("(//*[@class=\"dropbtn\"])[1]"));
        actions.moveToElement(hoverOverMeFirstButton).perform();
        //3. "Link 1" e tiklayin
        WebElement link1WebElementi =driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.doubleClick(link1WebElementi).perform();

        //4. Popup mesajini yazdirin
        driver
                .switchTo()
                .alert()
                .getText();

        //5. Popup'i tamam diyerek kapatin
        driver
                .switchTo()
                .alert()
                .accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButtonu = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHoldButtonu).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHoldGetTextElementi = driver.findElement(By.xpath("//*[@id='click-box']"));
        clickAndHoldGetTextElementi.getText();


        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMeButtonu = driver.findElement(By.xpath(" //*[@id='double-click']"));
        actions.doubleClick(doubleClickMeButtonu).perform();
    }
}
