package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_DropdownMenu extends TestBaseEach {

    @Test
    public void test01 () {
        // https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Secenek 1’i (Option 1) secin ve yazdirin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        ReusableMethods.bekle(2);
        select.selectByIndex(1);
        System.out.println("Index kullanarak option 1: " + select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);


        //2.Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");
        System.out.println("Value kullanarak option 2: " + select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);


        //3.Visible Text(Gorunen metin) kullanarak Seçenek 1’i (Option 1) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println("Gorunur text ile option 1: " + select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);


        //4.Tum dropdown degerleri(value) yazdirin
            // 1. alternatif
        System.out.println("Tum dropdown: " + ddm.getText());
            // 2. alternatif
        System.out.println("Tum dropdown (method ile): " + ReusableMethods.stringListeyeDonustur(select.getOptions()));


        //5. Dropdown’un boyutunun 4 oldugunu test edin
        int expectedDropdownBoyutu = 4;
        int actualDropdownBoyutu = select.getOptions().size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);

    }

}
