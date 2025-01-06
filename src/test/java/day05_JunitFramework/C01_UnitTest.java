package day05_JunitFramework;

import java.util.Random;

public class C01_UnitTest {

    public static void main(String[] args) {
        // Verilen bir tam sayiyi kontrol edip,
        // 3 basamakli pozitif bir tam sayi degilse "false",
        // 3 basamakli pozitif bir sayi ise "true" donduren bir method olusturun

        sayiKontrolMethodunuTestMethodu();

    }


    public static boolean sayiKontrol (int sayi) {
        if (sayi>=100 && sayi<=999) {
            return true;
        } else return false;
    }

    // sayi kontrol methodunun dogru calisip calismadigini kontrol eden bir test methodu olusturun


    public static void sayiKontrolMethodunuTestMethodu () {
        Random random = new Random();
        boolean testSonucu = true;

        // true dondurmesi gereken 10 degeri test etsin

        for (int i = 1; i <=10 ; i++) {
            int randomSayi = 100 + random.nextInt(899);

            if ( sayiKontrol(randomSayi) == false ) { // sayi kontrol methodunun dogru calismadigini gosterir
                testSonucu = false;
            }

        }

        if (testSonucu == true) {
            System.out.println("10 farkli sayi uretildi ve method kontrol testi PASSED");
        } else System.out.println("Sayi kontrol methodu dogru calismiyor. Test FAILED");
    }
}
