package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistTesti {

    @Test
    public void test01 () {

        // day09 package'i altinda deneme.txt dosyaisinin var oldugunu test edin

        /*
        Selenium'da tum islerimizi WebDriver ile yapiyoruz
        olusturdugumuz driver objesi bizim adimiza
        istedigimiz tum islemleri yapiyor

        ancak WebDriver adindan da anlasilabilecegi gibi
        web'de kullanilabilir, bilgisayarimizdaki dosyalara erisemez

        bilgisayarimizdaki dosyalara erismek icin Java'dan yardim aliriz
        Java ile dosyaya ulasabilmek icin ise dosyanin dosya yolunu bilmeliyiz
         */

        String denemeDosyaYolu = "src/test/java/day09_actionsClass_fileTestleri/deneme.txt";

        System.out.println(Files.exists(Paths.get(denemeDosyaYolu))); // true

        String yanlisDosyaYolu = "src/test/java/day09_actionsClass_fileTestleri/deneme.txt1";

        System.out.println(Files.exists(Paths.get(yanlisDosyaYolu))); // false


        Assertions.assertTrue(Files.exists(Paths.get(denemeDosyaYolu))); //PASSED



        // day09 package'i altinda deneme1.txt dosyaisinin var olmadigini test edin

        Assertions.assertFalse(Files.exists(Paths.get(yanlisDosyaYolu))); // PASSED

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String downloadsDenemeDosyaYolu = "/Users/muratsozbir/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(downloadsDenemeDosyaYolu))); // PASSED
    }
}
