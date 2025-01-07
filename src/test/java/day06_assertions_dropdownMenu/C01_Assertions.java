package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    /*
    AssertEquals(a,b) ile AssertTrue(a==b)
    eger assertion PASSED olursa yukaridaki methodlar arasinda hic bir fark yoktur
    ancak assertion FAILED oldugunda assertEquals() expected(a) ve actual(b) degerlerini karsilastirip
    aradaki farki bize otomatik olarak gosterir
    Ama assertTrue kullanildiginda sadece true bekliyorduk false oldu der
    Bu sebeple mumkun oldugu surece AssertEquals kullanmayi tercih ederiz
     */

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https://testotomasyonu.com";
    String url2 = "https://testotomasyonu.com/";

    @Test
    public void test01 () {
        // c'nin a ile b'nin toplamina esit oldugunu test edin
        Assertions.assertEquals(c,a+b);
        Assertions.assertTrue(c==a+b);
        // "esit" ifadesi gecen durumlarda assertEquals tercih edilir
    }

    @Test
    public void test02 () {
        // b'nin a ile c'nin toplamina esit oldugunu test edin
        Assertions.assertEquals(b,a+c);
        // Expected :20
        //Actual   :40
        //<Click to see difference>
    }

    @Test
    public void test03 () {
        // b'nin a ile c'nin toplamina esit oldugunu test edin
        Assertions.assertTrue(b==a+c);
        //Expected :true
        //Actual   :false
        //<Click to see difference>
    }

    @Test
    public void test04 () {
        //url1 ile url2'nin ayni oldugunu test edin
        Assertions.assertEquals(url1,url2);
        // Expected :https://testotomasyonu.com
        //Actual   :https://testotomasyonu.com/
        //<Click to see difference>
    }

    @Test
    public void test05 () {
        //url1 ile url2'nin ayni oldugunu test edin
        Assertions.assertTrue(url1.equals(url2));
        // Expected :true
        //Actual   :false
        //<Click to see difference>
    }

    @Test
    public void test06() {
        //url'in "best" kelimesi icermedigini test edin

        /* if (! url1.contains("best")) {
             System.out.println("Best testi PASSED");
         } else System.out.println("Best testi FAILED");
         */

        Assertions.assertFalse(url1.contains("best"));
        // if'le yapacak olsan ! kullanacagın bir kontrol varsa onu assertFalse ile yapabilirsin
    }
}
